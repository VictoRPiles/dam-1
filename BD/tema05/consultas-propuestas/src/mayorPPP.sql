/*
 Procedimiento: hay que sacar el jugador con mayor numero de puntos por partido en base a la posicion que se le de y la
 temporada por entrada al procedimiento.
 Cuando se haya obtenido se insertara en una nueva tabla estos valores.
 Y si no existiera el nombre del jugador o la temporada sacara un mensaje por pantalla como que no existe.
 */
CREATE PROCEDURE nba.mayorPPP(IN p_Posicion VARCHAR(5), IN p_Temporada VARCHAR(5))
BEGIN
	DECLARE thisCodigoJugador INT;
	DECLARE thisPuntos FLOAT;

	CREATE TABLE IF NOT EXISTS mayorPPP
	(
		Id            INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
		CodigoJugador INT             NOT NULL,
		Puntos        FLOAT,
		Posicion      VARCHAR(5),
		Temporada     VARCHAR(5)
	);

	SELECT jugador, Puntos_por_partido
	FROM estadisticas,
		 jugadores
	WHERE temporada = p_Temporada
	  AND Posicion = p_Posicion
	  AND jugador = jugadores.codigo
	ORDER BY Puntos_por_partido DESC
	LIMIT 1
	INTO thisCodigoJugador, thisPuntos;

	IF thisCodigoJugador IS NOT NULL THEN
		INSERT INTO mayorPPP(CodigoJugador, Puntos, Posicion, Temporada)
		VALUES (thisCodigoJugador, thisPuntos, p_Posicion, p_Temporada);
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe el jugador o temporada';
	END IF;
END;