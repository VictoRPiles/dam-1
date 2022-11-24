/*
Crea una select en la cual aparezcan todos los jugadores junto a su equipo correspondiente, que cumplan los siguientes
requisitos:
	- Tener un peso superior a 200lb.
	- Estar presente en la temporada 00/01.
	- Ganador de al menos un partido como local.
	- Tener una media de rebotes por partido igual o superior a 5 en esa misma temporada.
 */
SELECT Nombre, Nombre_equipo
FROM nba.partidos P,
	 nba.jugadores J,
	 nba.estadisticas E
WHERE Peso > 200
  AND J.codigo = E.jugador
  AND E.temporada = '00/01'
  AND E.Rebotes_por_partido >= 5
  AND (P.equipo_local = Nombre_equipo AND puntos_local > puntos_visitante)
GROUP BY Nombre;