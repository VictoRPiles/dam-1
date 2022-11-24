-- ====================
-- Desarrolla un procedimiento que rellene una tabla NGC_DESCR cuyos campos serán OBJECT y DESCR de la BDD de
-- Saguaro a partir de la columna NGC_DESC original que estaban separador por ";". Se deberán crear tantos registros
-- OBJECT, DESCR como datos separados por ";" tenga el campo NGC_DESCR y sólo si tiene datos. Realizalo para que el
-- procedimiento funcione en cualquier caso independientemente de la cantidad de ";" que haya (pueden ser teóricamente
-- infinitos).
-- OJO: Esto hace 60.000 aprox inserts
-- ====================
CREATE PROCEDURE saguaro.rellenarNGC()
BEGIN
	-- VARIABLES
	DECLARE nDelim INT;
	DECLARE i INT;
	DECLARE thisNgc_descr VARCHAR(55);
	DECLARE thisObject VARCHAR(17);
	DECLARE terminar BOOLEAN;
	-- CURSOR
	DECLARE datos CURSOR FOR SELECT object, ngc_descr FROM tmp;
	DECLARE EXIT HANDLER FOR NOT FOUND SET terminar = TRUE;

	-- CREA LA TABLA SI NO EXISTE
	CREATE TABLE IF NOT EXISTS ngc_descr
	(
		ID        INT AUTO_INCREMENT PRIMARY KEY,
		object    VARCHAR(17),
		ngc_descr VARCHAR(55)
	);

	OPEN datos;

	bucle:
	LOOP
		FETCH datos INTO thisObject, thisNgc_descr;

		IF terminar THEN
			LEAVE bucle;
		END IF;

		-- OBTENER EL NUMERO DE DELIMITADORES
		SET nDelim = ROUND((LENGTH(thisNgc_descr) - LENGTH(REPLACE(thisNgc_descr, ';', ''))) / LENGTH(';'));

		-- POR CADA DELIMITADOR -> INSERT thisObject, thisNgc_descr
		SET i = 1;
		WHILE i <= nDelim + 1
			DO
				-- TODOS HASTA EL DELIMITADOR NÚMERO i, DESPUÉS SELECCIONA SOLO EL ÚLTIMO
				INSERT INTO ngc_descr (object, ngc_descr)
				VALUES (thisObject, SUBSTRING_INDEX(SUBSTRING_INDEX(thisNgc_descr, ';', i), ';', -1));

				SET i = i + 1;
			END WHILE;
	END LOOP;
END;