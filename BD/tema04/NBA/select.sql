-- ====================
-- @author Victor Piles
-- @since 07/02/2022 10:23
-- ====================

-- ====================
-- 2.SELECT CON LA INFO BÁSICA DE "PAU GASOL": CODIGO, ALTURA, EQUIPO,...
-- ====================
SELECT codigo, Nombre, Procedencia, Altura, Peso, Posicion, Nombre_equipo
FROM nba.jugadores
WHERE Nombre = 'Pau Gasol';

-- ====================
-- 3.SELECT AÑADIENDO A (2) LOS DATOS BÁSICOS DE SU EQUIPO: CONFERENCIA, DIVISIÓN, CIUDAD...
-- ====================
SELECT j.codigo,
       j.Nombre,
       j.Procedencia,
       j.Altura,
       j.Peso,
       j.Posicion,
       e.Nombre,
       e.Ciudad,
       e.Conferencia,
       e.Division
FROM nba.jugadores j,
     nba.equipos e
WHERE j.Nombre = 'Pau Gasol'
  AND j.Nombre_equipo = e.Nombre;

-- ====================
-- 4.SELECT CON LOS PARTIDOS GANADOS POR LOS LAKERS COMO LOCAL EN LA TEMPORADA 01/02
-- ====================
SELECT codigo, equipo_local, equipo_visitante, puntos_local, puntos_visitante, temporada
FROM nba.partidos,
     nba.equipos
WHERE equipo_local = 'Lakers'
  AND Nombre = 'Lakers'
  AND temporada = '01/02'
  AND puntos_local > puntos_visitante;

-- ====================
-- 5.SELECT CON TODOS LOS PARTIDOS GANADOS POR LOS LAKERS EN LA TEMPORADA 01/02
-- ====================
SELECT codigo, equipo_local, equipo_visitante, puntos_local, puntos_visitante, temporada
FROM nba.partidos,
     nba.equipos
WHERE ((equipo_local = 'Lakers' AND puntos_local > puntos_visitante) OR
       (equipo_visitante = 'Lakers' AND puntos_local < puntos_visitante))
  AND Nombre = 'Lakers'
  AND temporada = '01/02';

-- ====================
-- 6.SELECT CON LA SUMA DE LOS PUNTOS DE LOS LAKERS EN LA TEMPORADA 01/02
-- ====================
SELECT SUM(IF(equipo_local = 'Lakers', puntos_local, puntos_visitante))
FROM (SELECT equipo_local, puntos_local, puntos_visitante
      FROM nba.partidos,
           nba.equipos
      WHERE (equipo_local = 'Lakers' OR equipo_visitante = 'Lakers')
	    AND Nombre = 'Lakers'
	    AND temporada = '01/02') AS ganados_lakers;

-- ====================
-- 7.SELECT QUE MUESTRE EL NÚMERO DE PARTIDOS GANADOS POR "LEBRON JAMES" EN 06/07
-- ====================
SELECT COUNT(*)
FROM (SELECT partidos.codigo
      FROM nba.partidos,
           nba.jugadores,
           nba.equipos
      WHERE ((equipo_local = jugadores.Nombre_equipo AND puntos_local > puntos_visitante) OR
             (equipo_visitante = jugadores.Nombre_equipo AND puntos_local < puntos_visitante))
	    AND temporada = '06/07'
	    AND jugadores.Nombre = 'Lebron James'
	    AND jugadores.Nombre_equipo = equipos.Nombre) AS ganados_lebron;

-- ====================
-- 8.SELECT QUE MUESTRE TODOS LOS PARTIDOS GANADOS DE CADA EQUIPO
-- ====================
SELECT IF(puntos_local > puntos_visitante, equipo_local, equipo_visitante) ganador, COUNT(*)
FROM nba.partidos
GROUP BY ganador;

-- ====================
-- 9.SELECT QUE MUESTRE EL NÚMERO DE REBOTES POR PARTIDO Y POR EQUIPO
-- ====================
-- JUGADOR
SELECT Nombre, Rebotes_por_partido
FROM nba.estadisticas e,
     nba.jugadores j
WHERE j.codigo = e.jugador;

-- EQUIPO
SELECT Nombre_equipo, ROUND(SUM(Rebotes_por_partido))
FROM nba.estadisticas e,
     nba.jugadores j
WHERE j.codigo = e.jugador
GROUP BY Nombre_equipo;