/*
 Nombre y procedencia de los jugadores cuya altura sea mayor o igual a 7-0 y cuyo equipo haya ganado al menos 1 partido
 como local en la temporada 02/03 con mas de 100 puntos.
 */
USE nba;
SELECT J.Nombre, J.Procedencia
FROM jugadores J,
	 equipos E,
	 partidos P
WHERE J.Nombre_equipo = E.Nombre
  AND J.Nombre_equipo = P.equipo_local
  -- OJO: también se puede comparar dos VARCHAR (VARCHAR > VARCHAR)
  AND (CAST(LEFT(Altura, LOCATE('-', Altura) - 1) AS UNSIGNED) >= 7 AND -- de VARCHAR a UNSIGNED INT (izquierda del '-')
	   CAST(RIGHT(Altura, LOCATE('-', Altura) - 1) AS UNSIGNED) >= 0) -- de VARCHAR a UNSIGNED INT (derecha del '-')
  AND P.puntos_local > P.puntos_visitante
  AND P.temporada = '02/03'
  AND P.puntos_local > 100
GROUP BY J.Nombre;