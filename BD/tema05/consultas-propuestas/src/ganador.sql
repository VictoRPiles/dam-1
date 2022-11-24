/*
 Crea una select que muestre que equipo gana en cada uno de los partidos jugados.
 Debes mostrar el código del partido, el nombre de los equipos que participan, el nombre del equipo ganador y los puntos
 que ha obtenido.
 En caso de un empato los dos sería null.
 */
SELECT codigo,
	   equipo_local,
	   equipo_visitante,
	   IF(puntos_local = puntos_visitante, NULL,
		  IF(puntos_local > puntos_visitante, equipo_local, equipo_visitante)) GANADOR,
	   IF(puntos_local = puntos_visitante, NULL,
		  IF(puntos_local > puntos_visitante, puntos_local, puntos_visitante)) PUNTOS
FROM nba.partidos;