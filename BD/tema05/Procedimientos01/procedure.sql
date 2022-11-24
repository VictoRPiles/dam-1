USE Jardineria;
-- ====================
-- 1.- Crear un procedimiento que acepte como argumento el nombre de un producto y muestre toda su informacion.
-- Si no lo encuentra debera imprimir el mensaje código de producto indexistente
-- ====================
CREATE PROCEDURE nomProd01(IN nombreproducto VARCHAR(70))
BEGIN
	DECLARE codigo VARCHAR(15);

	SELECT CodigoProducto
	INTO
		codigo
	FROM Jardineria.Productos
	WHERE Nombre = nombreproducto
	LIMIT 1;

	IF (codigo IS NOT NULL) THEN
		SELECT *
		FROM Jardineria.Productos
		WHERE Nombre = nombreproducto;
	ELSE
		SELECT 'PRODUCTO INEXISTENTE';
	END IF;
END;
-- ====================
-- 2.- Escribir y probar una funcion que admita como argumento el nombre de un producto y devuelva su precio.
-- ====================
CREATE FUNCTION nomProd02(nombreproducto VARCHAR(70))
	RETURNS DECIMAL(15, 2)
	DETERMINISTIC
BEGIN
	DECLARE pv DECIMAL(15, 2);

	SELECT PrecioVenta
	INTO
		pv
	FROM Jardineria.Productos
	WHERE Nombre = nombreproducto
	LIMIT 1;

	IF (pv IS NULL) THEN
		SET
			pv = -1;
	END IF;

	RETURN pv;
END;
-- ====================
-- 3.- Escribe una funcion que devuelva el precio del producto menos vendido
-- ====================
CREATE FUNCTION precioMenosVendido()
	RETURNS DECIMAL(15, 2)
	DETERMINISTIC
BEGIN
	DECLARE cp DECIMAL(15, 2);

	SELECT PrecioUnidad
	FROM (
		     SELECT CodigoProducto,
		            SUM(Cantidad) SUMA,
		            PrecioUnidad
		     FROM Jardineria.Detallepedidos
		     GROUP BY CodigoProducto
		     ORDER BY SUMA
		     LIMIT 1
	     ) cantidades
	INTO
		cp;

	RETURN cp;
END;
-- ====================
-- 4.- Escribe una funcion llamada ratio() que admita como argumento el nombre de un empleado y devuelva lo siguiente:
--     - BUENO si ha vendido en total mas de 6 productos distintos
--     - NORMAL si ha vendido entre 3 y 5
--     - MALO si ha vendido menos de 3.
-- ====================
CREATE FUNCTION ratio(nombreEmpleado VARCHAR(50)) RETURNS VARCHAR(6)
	DETERMINISTIC
BEGIN
	DECLARE ventasEmpleado INT;

	SELECT COUNT(*)
	FROM (
		     SELECT DISTINCT D.CodigoPedido,
		                     D.CodigoProducto,
		                     P.CodigoCliente,
		                     C.CodigoEmpleadoRepVentas,
		                     E.Nombre
		     FROM Jardineria.Detallepedidos D,
		          Jardineria.Pedidos P,
		          Jardineria.Clientes C,
		          Jardineria.Empleados E
		     WHERE D.CodigoPedido = P.CodigoPedido
			   AND P.CodigoCliente = C.CodigoCliente
			   AND C.CodigoEmpleadoRepVentas = E.CodigoEmpleado
			   AND E.Nombre = nombreEmpleado
	     ) ve
	INTO
		ventasEmpleado;

	CASE
		WHEN (ventasEmpleado >= 6) THEN RETURN 'BUENO';
		WHEN (ventasEmpleado >= 3) THEN RETURN 'NORMAL';
		ELSE RETURN 'MALO';
	END CASE;
END;
-- ====================
-- 5.- Escribe un procedimiento que acepte el nombre de un usuario, su contraseña y una palabra clave.
-- El procedimiento debe de guardar en una tabla el nombre de usuario y la contraseña encriptada con la palabra clave
-- ====================
CREATE TABLE passwdEncript
(
	Id     INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Nombre VARCHAR(50) NOT NULL,
	Passwd VARCHAR(50) NOT NULL
);

CREATE PROCEDURE passwdEncript(
	IN nombre VARCHAR(50),
	IN passwd VARCHAR(50),
	IN clave VARCHAR(50)
)
BEGIN
	INSERT
	INTO passwdEncript(Nombre,
	                   Passwd)
	VALUES (Nombre,
	        MD5(Passwd));
END;
-- ====================
-- 6.- Escribir una funcion que acepte el nombre de un usuario, su contraseña y una palabra clave. La funcion debe de
-- localizar al usuario y su contraseña en la tabla anterior si lo encuentra debe de devolver usuario "Usuario aceptado"
-- y sino "Acceso denegado".
-- ====================
CREATE FUNCTION accesoPasswd(
	nombre VARCHAR(50),
	passwd VARCHAR(50),
	clave VARCHAR(50)
) RETURNS VARCHAR(16)
	DETERMINISTIC
BEGIN
	DECLARE coincidencias INT;

	SELECT COUNT(*)
	FROM (
		     SELECT nombre
		     FROM jardineria.passwdEncript
		     WHERE nombre = passwdencript.Nombre
			   AND MD5(passwd) = passwdencript.Passwd
	     ) coinc
	INTO
		coincidencias;

	IF (coincidencias = 0) THEN
		RETURN 'Acceso denegado';
	ELSE
		RETURN 'Usuario aceptado';
	END IF;
END;
-- ====================
-- 7.- Escribir un procedimiento que muestre los pedidos que han tenido una fecha de entrega superior a la fecha esperada.
-- ====================
CREATE PROCEDURE pedidosSuperiorFecha(IN fecha DATE)
	DETERMINISTIC
BEGIN
	SELECT *
	FROM jardineria.pedidos
	WHERE FechaPedido > fecha;
END;
-- ====================
-- 8.- Escribir un procedimiento que inserte un nuevo pago la informacion de este pago se pasa como argumentos y
-- mediante excepciones debe cancelar la insercion si la cantidad a pagar es negativa dando un mensaje de aviso
-- ====================
CREATE PROCEDURE nuevoPago(
	IN nCodigoCliente INT,
	IN nFormaPago VARCHAR(40),
	IN nIDTransaccion VARCHAR(50),
	IN nFechaPago DATE,
	IN nCantidad DECIMAL(15, 2)
)
	DETERMINISTIC
BEGIN
	DECLARE EXIT HANDLER FOR SQLSTATE '45000'
		SELECT 'Cantidad menor que 0';

	IF (nCantidad < 0) THEN
		SIGNAL SQLSTATE '45000';
	END IF;

	INSERT
	INTO jardineria.pagos(CodigoCliente,
	                      FormaPago,
	                      IDTransaccion,
	                      FechaPago,
	                      Cantidad)
	VALUES (nCodigoCliente,
	        nFormaPago,
	        nIDTransaccion,
	        nFechaPago,
	        nCantidad);
END;
-- ====================
-- 9.- Crear un trigger que inserte un nuevo producto aplicandole un descuento del 10% si su precio supera el valor 20
-- y del 20% si el precio es superior a 40.
-- ====================
CREATE TRIGGER descuento
	BEFORE
		INSERT
	ON
		jardineria.productos
	FOR EACH ROW
BEGIN
	IF NEW.PrecioVenta > 20 THEN
		SET
			NEW.PrecioVenta = NEW.PrecioVenta * 0.9;
	ELSE
		IF NEW.PrecioVenta > 40 THEN
			SET
				NEW.PrecioVenta = NEW.PrecioVenta * 0.8;
		END IF;
	END IF;
END;
-- ====================
-- 10.- Escribir un trigger para asegurar que cualquier equipo de la NBA no pueda tener más de 15 jugadores.
-- ====================
CREATE TRIGGER nba.maxJugadoresNBA
	BEFORE
		INSERT
	ON
		nba.jugadores
	FOR EACH ROW
BEGIN
	DECLARE nJugadores INT;

	SELECT COUNT(*)
	FROM nba.jugadores
	WHERE Nombre_equipo = NEW.Nombre_equipo
	INTO
		nJugadores;

	IF nJugadores >= 15 THEN
		SIGNAL SQLSTATE '45000'
			SET
				MESSAGE_TEXT = 'Ya hay 15 jugadores en el equipo';
	END IF;
END;
-- ====================
-- 11.- Escribe un procedimiento que muestre la cantidad que debe un determinado cliente que se pasará como argumento.
-- ====================
CREATE PROCEDURE jardineria.deudaCliente(IN idCliente INT)
	DETERMINISTIC
BEGIN
	SELECT SUM(Cantidad)
	FROM jardineria.pagos
	WHERE CodigoCliente = 1;
END;
-- ====================
-- 12.- Mostrar un listado con el montante ingresado(pagado) por cada cliente de la empresa.
-- ====================
CREATE PROCEDURE jardineria.deudaTodosClientes()
	DETERMINISTIC
BEGIN
	SELECT SUM(Cantidad)
	FROM jardineria.pagos
	GROUP BY CodigoCliente;
END;

-- ====================
-- 13.- Crear una tabla y mediante un procedimiento inserta el total de rebotes, tapones y puntos de cada uno de los
-- jugadores de la NBA a lo largo de su trayectoria profesional. Utilizando cursores.
-- ====================
CREATE TABLE nba.totales
(
	Jugador INT,
	Puntos  INT,
	Rebotes INT,
	Tapones INT,
	PRIMARY KEY (Jugador)
);

CREATE PROCEDURE totales() -- FIXME: Al profesor le peta, no ejecuto por si acaso
BEGIN
	DECLARE p_jugador INT;
	DECLARE p_puntos INT;
	DECLARE p_rebotes INT;
	DECLARE p_tapones INT;
	DECLARE fin INT;
	DECLARE lista CURSOR FOR
		SELECT jugador,
		       ROUND(SUM(Puntos_por_partido))  Puntos,
		       ROUND(SUM(Tapones_por_partido)) Tapones,
		       ROUND(SUM(Rebotes_por_partido)) Rebotes
		FROM nba.estadisticas
		GROUP BY jugador;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;

	OPEN lista;
	SET fin = 0;

	bucle:
	LOOP
		FETCH lista INTO p_jugador,p_puntos, p_tapones, p_rebotes;

		IF fin = 1 THEN
			LEAVE bucle;
		END IF;

		INSERT INTO nba.totales (Jugador, Puntos, Rebotes, Tapones) VALUES (p_jugador, p_puntos, p_tapones, p_rebotes);
	END LOOP;

	CLOSE lista;
END;

-- ====================
--  14.- Procedimiento que nos muestra las columnas de una tabla (SHOW COLUMNS FROM...). Usando Prepared Statement.
-- =================
CREATE PROCEDURE nba.ej14(IN p_tabla VARCHAR(30))
BEGIN
	SET @`exp` = CONCAT('SHOW COLUMNS FROM ', p_tabla);
	PREPARE sentencia FROM @`exp`;
	EXECUTE sentencia;
END;

-- ====================
-- 15.- Procedimiento que reenumere el campo autoincrementativo de una tabla.
-- ====================
CREATE PROCEDURE jardineria.ej15()
BEGIN
	DECLARE p_ID VARCHAR(50);
	DECLARE num INT;
	DECLARE fin INT;
	DECLARE lista CURSOR FOR SELECT IDTransaccion FROM jardineria.pagos ORDER BY IDTransaccion;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;

	OPEN lista;
	SET num = 1;
	bucle:
	LOOP
		FETCH lista INTO p_ID;

		UPDATE jardineria.pagos SET IDTransaccion = CONCAT('Pago-', num) WHERE IDTransaccion = p_ID;

		IF fin = 1 THEN
			LEAVE bucle;
		END IF;

		SET num = num + 1;
	END LOOP;
END;