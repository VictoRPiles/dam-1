USE jardineria;
-- ====================
-- Se deberá crear un tabla IMPRESION con los siguientes campos
-- ANYO  Varchar(4)
-- TEXTO VARCHAR (80)
-- LINEA INT
-- ====================

CREATE FUNCTION generarEspacios(longitud INT, longitud_campo INT) RETURNS VARCHAR(100)
	DETERMINISTIC
BEGIN
	DECLARE espacios INT;
	DECLARE cadena VARCHAR(100);

	SET espacios = 0;
	SET cadena = ' ';

	SET cadena = LEFT('                                                                               ',
					  longitud_campo - longitud);

	RETURN cadena;
END;

-- ====================
-- Comprueba si un cliente tiene pedidos.
-- ====================
CREATE FUNCTION tienePedidos(p_CodigoCliente INT) RETURNS BOOLEAN
	DETERMINISTIC
BEGIN
	DECLARE pedidos INT;

	SELECT COUNT(*)
	FROM pedidos,
		 detallepedidos
	WHERE jardineria.pedidos.CodigoCliente = p_CodigoCliente
	  AND jardineria.pedidos.CodigoPedido = jardineria.detallepedidos.CodigoPedido
	INTO pedidos;

	IF pedidos > 0 THEN
		RETURN TRUE;
	ELSE
		RETURN FALSE;
	END IF;
END;

-- ====================
-- Inserta la cabecera del informe y por cada cliente que tiene pedidos, inserta la información del cliente y
-- llama al procedimiento generarInformePedidos.
-- Crea la tabla impresion si no existe.
-- ====================
CREATE PROCEDURE generarInforme(IN anyo_actual VARCHAR(4))
BEGIN
	DECLARE terminar BOOLEAN;
	DECLARE thisCliente VARCHAR(500);
	DECLARE thisCodigoCliente INT;

	DECLARE cursorClientes CURSOR FOR SELECT CodigoCliente,
											 CONCAT('Cliente:', generarEspacios(0, 1),
													ApellidoContacto, generarEspacios(0, 1),
													NombreContacto,
													generarEspacios(LENGTH(NombreContacto) + LENGTH(ApellidoContacto),
																	LENGTH(NombreContacto) + LENGTH(ApellidoContacto) +
																	4),
													'NumeroCliente:', generarEspacios(0, 1),
													CodigoCliente)
									  FROM clientes;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET terminar = TRUE;

	CREATE TABLE IF NOT EXISTS impresion
	(
		linea INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		anyo  VARCHAR(4),
		texto VARCHAR(500)
	);

	-- I N F O R M E   A N U A L (año)
	INSERT INTO impresion (anyo, texto) VALUES (anyo_actual, CONCAT('I N F O R M E   A N U A L   ', anyo_actual));
	INSERT INTO impresion (anyo, texto) SELECT anyo_actual, '';

	OPEN cursorClientes;

	bucle:
	LOOP
		FETCH cursorClientes INTO thisCodigoCliente, thisCliente;

		IF terminar THEN
			LEAVE bucle;
		END IF;

		IF tienePedidos(thisCodigoCliente) THEN
			-- Cliente: (apellido1, nombre1)       NumeroCliente: (CodCliente1)
			INSERT INTO impresion (anyo, texto) VALUES (anyo_actual, thisCliente);

			CALL generarInformePedidos(anyo_actual, thisCodigoCliente);
		END IF;
	END LOOP;
END;

-- ====================
-- Inserta los datos de los pedidos de este cliente.
-- ====================
CREATE PROCEDURE generarInformePedidos(IN anyo_actual VARCHAR(4), IN thisCodigoCliente INT)
BEGIN
	INSERT INTO impresion (anyo, texto) SELECT anyo_actual, '';

	-- Gama       NúmeroPedidos       Importe
	INSERT INTO impresion (anyo, texto)
	VALUES (anyo_actual, CONCAT('Gama', generarEspacios(0, 46), 'NúmeroPedidos', generarEspacios(0, 2), 'Importe'));
	-- ----------------------------------------------------
	INSERT INTO impresion (anyo, texto)
	VALUES (anyo_actual, '------------------------------------------------------------------------------------------');

	--  (gama1)   (NPedidos1)              (Importe1)
	INSERT INTO impresion (anyo, texto)
	SELECT anyo_actual,
		   CONCAT(Gama, generarEspacios(CHAR_LENGTH(Gama), 50),
				  COUNT(detallepedidos.CodigoPedido),
				  generarEspacios(LENGTH(CAST(COUNT(detallepedidos.CodigoPedido) AS CHAR)), 15),
				  SUM(detallepedidos.Cantidad * detallepedidos.PrecioUnidad))
	FROM productos,
		 pedidos,
		 detallepedidos
	WHERE productos.CodigoProducto = detallepedidos.CodigoProducto
	  AND pedidos.CodigoCliente = thisCodigoCliente
	  AND pedidos.CodigoPedido = detallepedidos.CodigoPedido
	GROUP BY Gama;

	-- ----------------------------------------------------
	INSERT INTO impresion (anyo, texto)
	VALUES (anyo_actual, '------------------------------------------------------------------------------------------');

	-- TOTAL      (SPedidos1)              (SImportes1)
	INSERT INTO impresion (anyo, texto)
	SELECT anyo_actual,
		   CONCAT('TOTAL', generarEspacios(LENGTH('TOTAL'), 50),
				  COUNT(detallepedidos.CodigoPedido),
				  generarEspacios(LENGTH(CAST(COUNT(detallepedidos.CodigoPedido) AS CHAR)), 15),
				  SUM(detallepedidos.Cantidad * detallepedidos.PrecioUnidad))
	FROM detallepedidos,
		 pedidos
	WHERE pedidos.CodigoPedido = detallepedidos.CodigoPedido
	  AND CodigoCliente = thisCodigoCliente;

	INSERT INTO impresion (anyo, texto)
	SELECT anyo_actual, '##########################################################################################';
END;
-- DROP FUNCTION tienePedidos;
-- DROP PROCEDURE generarInforme;
-- DROP PROCEDURE generarInformePedidos;