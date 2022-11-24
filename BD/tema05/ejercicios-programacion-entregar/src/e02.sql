-- ====================
-- Desarrolla un procedimiento COMPRA_RAPIDA en jardineria que dado el Código de Cliente, el Código de Producto y
-- la cantidad realice el pedido automáticamente. La Fecha Pedido será la actual y la Fecha Esperada una semana más
-- tarde. Si no existe el Cliente o el Producto que lance un mensaje de error indicándolo (Cliente inexistente o
-- Producto Inexistente)
-- ====================
CREATE PROCEDURE jardineria.COMPRA_RAPIDA(IN p_CodigoCliente INT, IN p_CodigoProducto VARCHAR(20), IN p_Cantidad INT)
BEGIN
	DECLARE p_CodigoPedido INT;
	DECLARE p_PrecioUnidad DECIMAL(15, 2);
	DECLARE EXIT HANDLER FOR SQLSTATE '45000' SELECT 'Cliente inexistente';
	DECLARE EXIT HANDLER FOR SQLSTATE '45001' SELECT 'Producto Inexistente';

	IF (SELECT CodigoCliente FROM jardineria.clientes WHERE CodigoCliente = p_CodigoCliente) IS NULL
	THEN
		SIGNAL SQLSTATE '45000';
	END IF;

	IF (SELECT CodigoProducto FROM jardineria.productos WHERE CodigoProducto = p_CodigoProducto) IS NULL
	THEN
		SIGNAL SQLSTATE '45001';
	END IF;

	SELECT (MAX(CodigoPedido) + 1) FROM jardineria.pedidos INTO p_CodigoPedido;
	SELECT PrecioVenta FROM jardineria.productos WHERE CodigoProducto = p_CodigoProducto INTO p_PrecioUnidad;

	INSERT INTO jardineria.pedidos(CodigoPedido, FechaPedido, FechaEsperada, Estado, CodigoCliente)
	VALUES (p_CodigoPedido, CURDATE(), CURDATE() + 7, 'Pendiente', p_CodigoCliente);

	INSERT INTO jardineria.detallepedidos(CodigoPedido, CodigoProducto, Cantidad, PrecioUnidad, NumeroLinea)
	VALUES (p_CodigoPedido, p_CodigoProducto, p_Cantidad, p_PrecioUnidad, 1);
END;

