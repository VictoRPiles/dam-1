/* ===== INFORMACIÓN DE UN PEDIDO ===== */
SELECT P.Fecha,
       C.Nombre,
       C.NIF,
       D.Calle,
       D.Numero,
       D.Puerta,
       D.CP,
       D.Poblacion,
       PA.Cantidad,
       A.descripcion
FROM articulos.pedidos P,
     articulos.clientes C,
     articulos.direccion D,
     articulos.pedido_articulo PA,
     articulos.articulos A
WHERE A.idArticulo = PA.idPedido
  AND C.idClientes = P.idCliente
  AND D.idDireccion = P.idDireccion;

SELECT P.idPedido, PA.idArticulo, Fecha
FROM articulos.pedidos P
	     LEFT JOIN articulos.pedido_articulo PA
	               ON P.idPedido = PA.idPedido;