/*
 Crea una función que convierta la altura de pies y pulgadas (como está guardada en la tabla jugadores) a centímetros
 Ejemplo:
 	select nba.alturaCm('6-9'); --->>  206
 */
USE nba;

CREATE FUNCTION nba.alturaCm(p_Pies VARCHAR(4)) RETURNS FLOAT
	DETERMINISTIC
BEGIN
	DECLARE enteros FLOAT;
	DECLARE decimales FLOAT;

	SET enteros = SUBSTRING_INDEX(p_Pies, '-', 1);
	SET decimales = RIGHT(p_Pies, 1) / 10;

	/* 1 pie = 30,48 cm */
	RETURN (enteros + decimales) * 30.48;
END;