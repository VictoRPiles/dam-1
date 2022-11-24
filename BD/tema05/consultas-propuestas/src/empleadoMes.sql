/*
 En la BDD Jardineria:
 Crear una función a la que se le pase un mes (1-12) y un año, y a partir de ellos encuentre el empleado del mes.

 Este empleado será el que más ventas haya realizado en el mes y año pasados como parámetros .

 Una vez encontrado, la función tiene que devolver una cadena de texto con el formato:
 	"Empleado del mes mm/aaaa: Nombre Apellido1 Apellido2 (total vendido: xxx €)"
 Si en ese mes y año no se hubiera producido ninguna venta, la cadena de texto a devolver sería:
 	"No hubo ventas en el mes mm/aaaa"
 */
CREATE FUNCTION jardineria.empleadoMes(p_mes INT, p_anyo YEAR) RETURNS VARCHAR(100)
	DETERMINISTIC
BEGIN
	/* Si no hay ventas ese mes */
	IF ((SELECT COUNT(*) FROM pedidos WHERE YEAR(FechaPedido) = p_anyo AND MONTH(FechaPedido) = p_mes) <= 0) THEN
		RETURN CONCAT('No hubo ventas en el mes ', p_mes, '/', p_anyo);
	END IF;

	/* "Empleado del mes mm/aaaa: Nombre Apellido1 Apellido2 (total vendido: xxx €)" */
	RETURN (
		SELECT CONCAT('Empleado del mes ', p_mes, '/', p_anyo, ' -> ',
					  E.Nombre, ' ', E.Apellido1, ' ', E.Apellido2, ' ',
					  '(total vendido: ', SUM(PrecioUnidad * Cantidad), '€)')
		FROM empleados E,
			 clientes C,
			 pedidos P,
			 detallepedidos D
		WHERE (YEAR(FechaPedido) = p_anyo AND MONTH(FechaPedido) = p_mes)
		  AND P.CodigoCliente = C.CodigoCliente
		  AND P.CodigoPedido = D.CodigoPedido
		  AND C.CodigoEmpleadoRepVentas = E.CodigoEmpleado
		GROUP BY E.CodigoEmpleado
		ORDER BY COUNT(*) DESC
		LIMIT 1
	);
END;