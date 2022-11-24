/*
 Procedimiento que se introduzca una temporada y se inserte en una tabla nueva:
 temporada, nombre del jugador, posicion, especialidad (puntos o asistencias o tapones o rebotes), media, nombre equipo, division
 Del jugador con mayor media de puntos por partido de la temporada.
 Del jugador con mayor media de asistencias por partido de la temporada.
 Del jugador con mayor media de tapones por partido de la temporada.
 Del jugador con mayor media de rebotes por partido de la temporada.
 Si no existe la temporada que salga un mensaje de error.
 Si la temporada ya fue insertada que salga un mensaje de error.
 */
CREATE PROCEDURE nba.mejoresJugadores(IN p_temporada VARCHAR(5))
BEGIN
	DECLARE v_IdPuntos INT;
	DECLARE v_MediaPuntos FLOAT;

	DECLARE v_IdAsistencias INT;
	DECLARE v_MediaAsistencias FLOAT;

	DECLARE v_IdTapones INT;
	DECLARE v_MediaTapones FLOAT;

	DECLARE v_IdRebotes INT;
	DECLARE v_MediaRebotes FLOAT;

	DECLARE temporadaRepetida INT;

	/* ========== TABLA ========== */

	CREATE TABLE IF NOT EXISTS mejoresJugadores
	(
		id            INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
		temporada     VARCHAR(5)      NOT NULL,
		nombreJugador VARCHAR(30)     NOT NULL,
		posicion      VARCHAR(5),
		especialidad  VARCHAR(20),
		media         FLOAT           NOT NULL,
		nombreEquipo  VARCHAR(20),
		division      VARCHAR(9)
	);

	/* ========== SELECTS MEJORES JUGADORES ========== */

	/* MAYOR MEDIA DE PUNTOS */
	SELECT jugador, Puntos_por_partido
	FROM estadisticas
	WHERE temporada = p_temporada
	ORDER BY Puntos_por_partido DESC
	LIMIT 1
	INTO v_IdPuntos, v_MediaPuntos;

	/* MAYOR MEDIA DE ASISTENCIAS */
	SELECT jugador, Asistencias_por_partido
	FROM estadisticas
	WHERE temporada = p_temporada
	ORDER BY Asistencias_por_partido DESC
	LIMIT 1
	INTO v_IdAsistencias, v_MediaAsistencias;

	/* MAYOR MEDIA DE TAPONES */
	SELECT jugador, Tapones_por_partido
	FROM estadisticas
	WHERE temporada = p_temporada
	ORDER BY Tapones_por_partido DESC
	LIMIT 1
	INTO v_IdTapones, v_MediaTapones;

	/* MAYOR MEDIA DE REBOTES */
	SELECT jugador, Rebotes_por_partido
	FROM estadisticas
	WHERE temporada = p_temporada
	ORDER BY Rebotes_por_partido DESC
	LIMIT 1
	INTO v_IdRebotes, v_MediaRebotes;

	/* ========== ERRORES ========== */

	IF v_IdPuntos IS NULL OR
	   v_IdAsistencias IS NULL OR
	   v_IdTapones IS NULL OR
	   v_IdRebotes IS NULL
	THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Temporada no encontrada';
	END IF;

	SELECT COUNT(*)
	FROM mejoresJugadores
	WHERE temporada = p_temporada
	INTO temporadaRepetida;

	IF temporadaRepetida > 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Temporada ya insertada';
	END IF;

	/* ========== INSERTS ========== */

	/* INFO DEL JUGADOR CON MAYOR MEDIA DE PUNTOS */
	INSERT INTO mejoresJugadores (temporada, nombreJugador, posicion, especialidad, media, nombreEquipo, division)
	SELECT p_temporada, jugadores.Nombre, Posicion, 'Puntos', v_MediaPuntos, equipos.Nombre, Division
	FROM jugadores,
		 equipos
	WHERE jugadores.codigo = v_IdPuntos
	  AND equipos.Nombre = jugadores.Nombre_equipo;

	/* INFO DEL JUGADOR CON MAYOR MEDIA DE ASISTENCIAS */
	INSERT INTO mejoresJugadores (temporada, nombreJugador, posicion, especialidad, media, nombreEquipo, division)
	SELECT p_temporada, jugadores.Nombre, Posicion, 'Asistencias', v_MediaAsistencias, equipos.Nombre, Division
	FROM jugadores,
		 equipos
	WHERE jugadores.codigo = v_IdAsistencias
	  AND equipos.Nombre = jugadores.Nombre_equipo;

	/* INFO DEL JUGADOR CON MAYOR MEDIA DE TAPONES */
	INSERT INTO mejoresJugadores (temporada, nombreJugador, posicion, especialidad, media, nombreEquipo, division)
	SELECT p_temporada, jugadores.Nombre, Posicion, 'Tapones', v_MediaTapones, equipos.Nombre, Division
	FROM jugadores,
		 equipos
	WHERE jugadores.codigo = v_IdTapones
	  AND equipos.Nombre = jugadores.Nombre_equipo;

	/* INFO DEL JUGADOR CON MAYOR MEDIA DE REBOTES */
	INSERT INTO mejoresJugadores (temporada, nombreJugador, posicion, especialidad, media, nombreEquipo, division)
	SELECT p_temporada, jugadores.Nombre, Posicion, 'Rebotes', v_MediaRebotes, equipos.Nombre, Division
	FROM jugadores,
		 equipos
	WHERE jugadores.codigo = v_IdRebotes
	  AND equipos.Nombre = jugadores.Nombre_equipo;
END;