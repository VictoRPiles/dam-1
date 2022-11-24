-- ====================
-- Realiza un procedimiento que cree una columna CATEGORIA (int) en la tabla clientes y la rellene según el volumen
-- de compra de compras que haya realizado (Suma Cantidad*PrecioUnitario)
--      1 -> Importe total superior a 50.000
--      2 -> Importes superiores a 10.000
--      3 -> Importes superiores a 1.000
--      4 -> Importes inferiores a 1.000
-- ====================
CREATE PROCEDURE jardineria.volumenCompras()
BEGIN
	DECLARE volumen FLOAT;
	DECLARE cat INT DEFAULT 0;
	DECLARE cli INT DEFAULT 0;

	DECLARE terminar INT DEFAULT FALSE;
	DECLARE elCursor
		CURSOR FOR
		SELECT CodigoCliente
		FROM clientes;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET terminar = TRUE;

	-- CREA LA COLUMNA SI NO EXISTE
	IF NOT EXISTS(SELECT NULL
				  FROM INFORMATION_SCHEMA.COLUMNS
				  WHERE TABLE_NAME = 'clientes'
					AND TABLE_SCHEMA = 'jardineria'
					AND COLUMN_NAME = 'Categoria') THEN
		ALTER TABLE clientes
			ADD Categoria INT;
	END IF;

	OPEN elCursor;

	-- POR CADA CLIENTE
	bucle:
	LOOP
		FETCH elCursor INTO cli;

		IF terminar THEN
			LEAVE bucle;
		ELSE
			-- CALCULA EL VOLUMEN DEL CLIENTE
			SELECT SUM(PrecioUnidad * Cantidad)
			FROM pedidos,
				 detallepedidos
			WHERE CodigoCliente = cli
			  AND pedidos.CodigoPedido = detallepedidos.CodigoPedido
			INTO volumen;

			-- CALCULA LA CATEGORIA DEL CLIENTE
			IF volumen > 50000 THEN
				SET cat = 1;
			ELSE
				IF volumen > 10000 THEN
					SET cat = 2;
				ELSE
					IF volumen > 1000 THEN
						SET cat = 3;
					ELSE
						SET cat = 4;
					END IF;
				END IF;
			END IF;

			-- APLICA EL VALOR EN LA COLUMNA
			UPDATE clientes SET Categoria = cat WHERE CodigoCliente = cli;
		END IF;
	END LOOP;
END;