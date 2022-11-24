CREATE VIEW jardineria.pedidosCliente AS
SELECT P.CodigoPedido Pedido, P.FechaPedido Fecha, C.NombreCliente Cliente
FROM jardineria.pedidos P,
     jardineria.clientes C
WHERE P.CodigoCliente = C.CodigoCliente;