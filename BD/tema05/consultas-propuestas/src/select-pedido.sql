/*
Select que muestre el código pedido, el nombre cliente, precio unidad y cantidad, hechos en 2008 y con un precio de
unidad superior a 20 y una cantidad superior a 50.
 */
SELECT DP.CodigoPedido, NombreCliente, PrecioUnidad, Cantidad
FROM jardineria.detallepedidos DP,
	 jardineria.clientes C,
	 jardineria.pedidos P
WHERE DP.CodigoPedido = P.CodigoPedido
  AND C.CodigoCliente = P.CodigoCliente
  AND YEAR(P.FechaPedido) = 2008
  AND PrecioUnidad > 20
  AND Cantidad > 50;