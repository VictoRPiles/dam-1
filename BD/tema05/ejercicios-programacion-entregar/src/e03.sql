-- ====================
-- Desarrolla una función que dado el Código del Cliente de jardinería te muestra la deuda que tiene.
-- (Suma Cantidad*PrecioUnidad menos Suma Pagos)
-- ====================
CREATE FUNCTION jardineria.DEUDA(p_CodigoCliente INT) RETURNS FLOAT
	DETERMINISTIC
BEGIN
	DECLARE deuda FLOAT;

	SELECT SUM(PrecioUnidad * Cantidad)
	FROM pedidos,
		 detallepedidos
	WHERE CodigoCliente = p_CodigoCliente
	  AND pedidos.CodigoPedido = detallepedidos.CodigoPedido
	INTO deuda;

	SET deuda = deuda - (SELECT SUM(Cantidad) FROM jardineria.pagos WHERE CodigoCliente = p_CodigoCliente);

	RETURN deuda;
END;