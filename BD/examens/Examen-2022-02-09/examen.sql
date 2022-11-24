-- ====================
-- @author Victor Piles
-- @since 09/02/2022 9:57
-- ====================

-- ====================
-- 1.- Carga la BDD que encontrarás en el archivo jardineria.sql (ya crea su propio esquema) (0,5 Puntos)
-- ==================== 

-- ====================
-- 2.- Muestra los datos de contacto del cliente "Sotogrande" (0,5 Puntos).
-- ====================
SELECT NombreContacto,
       ApellidoContacto,
       Telefono,
       Fax,
       LineaDireccion1,
       LineaDireccion2,
       Ciudad,
       Region,
       Pais,
       CodigoPostal
FROM jardineria.clientes
WHERE NombreCliente = 'Sotogrande';

-- ====================
-- 3.- Muestra CodigoProducto, Nombre, Gama, Descripcion, CantidadEnStock y PrecioVenta de los productos del proveedor "Murcia Seasons" (0,5 Puntos).
--   3.1.- ¿Cuantos productos son? (0,5 Puntos)
-- ====================
SELECT CodigoProducto, Nombre, Gama, Descripcion, CantidadEnStock, PrecioVenta
FROM jardineria.productos
WHERE Proveedor = 'Murcia Seasons';

SELECT COUNT(*)
FROM (SELECT CodigoProducto, Nombre, Gama, Descripcion, CantidadEnStock, PrecioVenta
      FROM jardineria.productos
      WHERE Proveedor = 'Murcia Seasons') AS murcia;

-- ====================
-- 4.- Indica cuantos productos proporciona cada proveedor a la tienda. (0,5 Puntos)
-- ====================
SELECT Proveedor, COUNT(*)
FROM jardineria.productos
GROUP BY Proveedor;

-- ====================
-- 5. - ¿Cual es el margen comercial de cada producto vendido? (0,5 Puntos)
-- NOTA: Margen comercial = (Precio Venta - Precio Proveedor)/(Precio Venta)*100
-- ====================
SELECT Nombre, ((PrecioVenta - PrecioProveedor) / (PrecioVenta) * 100)
FROM jardineria.productos;

-- ====================
-- 6.- Lista los pedidos realizados en 2008 y muestra el Nombre de los Clientes ordenado por Fecha de Pedido (1 Puntos)
--  6.1- ¿Cual fue el cliente que más pedidos realizó? (1 Puntos)
--      6.1.1.- Lista todos los productos que compró ese cliente (Introduciendo el Código del Cliente) en 2008
--      (Fecha del Pedido, Nombre del Producto, Cantidad, Precio Unitario, Subtotal por producto) ordenado por Fecha de Pedido. (1 Puntos)
--          6.1.1.1- ¿Cuanto se ha gastado en total en cada uno de los pedidos en 2008? (1 Puntos)
--          6.1.1.2.- ¿Y en total en 2008? (0,5Puntos)
-- ====================
SELECT FechaPedido, NombreCliente
FROM jardineria.pedidos p,
     jardineria.clientes c
WHERE p.CodigoCliente = c.CodigoCliente
  AND SUBSTRING(FechaPedido, 1, 4) = '2008'
ORDER BY FechaPedido;

SELECT NombreCliente, MAX(num_pedidos)
FROM (SELECT NombreCliente, COUNT(*) num_pedidos
      FROM jardineria.pedidos p,
           jardineria.clientes c
      WHERE p.CodigoCliente = c.CodigoCliente
	    AND SUBSTRING(FechaPedido, 1, 4) = '2008'
      GROUP BY c.CodigoCliente) AS numero;

-- 6.1.1
SELECT ped.FechaPedido, pro.Nombre, d.Cantidad, d.PrecioUnidad, (d.PrecioUnidad * d.Cantidad)
FROM jardineria.pedidos ped,
     jardineria.detallepedidos d,
     jardineria.productos pro,
     (SELECT NombreCliente, MAX(num_pedidos), CodigoCliente
      FROM (SELECT NombreCliente, COUNT(*) num_pedidos, c.CodigoCliente
            FROM jardineria.pedidos p,
                 jardineria.clientes c
            WHERE p.CodigoCliente = c.CodigoCliente
	          AND SUBSTRING(FechaPedido, 1, 4) = '2008'
            GROUP BY NombreCliente) AS numero) AS max_cliente
WHERE d.CodigoPedido = ped.CodigoPedido
  AND pro.CodigoProducto = d.CodigoProducto
  AND ped.CodigoCliente = max_cliente.CodigoCliente
  AND SUBSTRING(FechaPedido, 1, 4) = '2008'
ORDER BY ped.FechaPedido;

-- 6.1.1.1
SELECT CodigoPedido, SUM(subtotal)
FROM (SELECT ped.CodigoPedido,
             (d.PrecioUnidad * d.Cantidad) subtotal
      FROM jardineria.pedidos ped,
           jardineria.detallepedidos d,
           jardineria.productos pro,
           (SELECT NombreCliente, MAX(num_pedidos), CodigoCliente
            FROM (SELECT NombreCliente, COUNT(*) num_pedidos, c.CodigoCliente
                  FROM jardineria.pedidos p,
                       jardineria.clientes c
                  WHERE p.CodigoCliente = c.CodigoCliente
	                AND SUBSTRING(FechaPedido, 1, 4) = '2008'
                  GROUP BY NombreCliente) AS numero) AS max_cliente
      WHERE d.CodigoPedido = ped.CodigoPedido
	    AND pro.CodigoProducto = d.CodigoProducto
	    AND ped.CodigoCliente = max_cliente.CodigoCliente
	    AND SUBSTRING(FechaPedido, 1, 4) = '2008'
      ORDER BY ped.FechaPedido) AS pd
GROUP BY CodigoPedido;

-- 6.1.1.2
SELECT SUM(subtotal)
FROM (SELECT (d.PrecioUnidad * d.Cantidad) subtotal
      FROM jardineria.pedidos ped,
           jardineria.detallepedidos d,
           jardineria.productos pro,
           (SELECT NombreCliente, MAX(num_pedidos), CodigoCliente
            FROM (SELECT NombreCliente, COUNT(*) num_pedidos, c.CodigoCliente
                  FROM jardineria.pedidos p,
                       jardineria.clientes c
                  WHERE p.CodigoCliente = c.CodigoCliente
	                AND SUBSTRING(FechaPedido, 1, 4) = '2008'
                  GROUP BY NombreCliente) AS numero) AS max_cliente
      WHERE d.CodigoPedido = ped.CodigoPedido
	    AND pro.CodigoProducto = d.CodigoProducto
	    AND ped.CodigoCliente = max_cliente.CodigoCliente
	    AND SUBSTRING(FechaPedido, 1, 4) = '2008'
      ORDER BY ped.FechaPedido) AS pd;

-- ====================
-- 7.- Muestra el producto más caro de la tienda  (1 Puntos)
-- ====================
SELECT Nombre, PrecioVenta -- creo que esta forma de sacar el nombre es chapuza, pero no se me ocurre otra
FROM jardineria.productos,
     (SELECT MAX(PrecioVenta) precio
      FROM jardineria.productos) AS max_precio
WHERE PrecioVenta = max_precio.precio;

-- ====================
-- 8.- Crea una nueva tabla "Incidencias" que guarde un campo que identifique al pedido, un campo "Descripcion" de la
-- incidencia de longitud 100 y la fecha. Recuerda definir las Foreign Keys que creas necesarias y la Clave Primaria. (0,5 Puntos)
--  8.1 Inserta una incidencia al pedido 1 con la descripción "No me ha llegado" (0,5 Puntos)
-- ====================
CREATE TABLE jardineria.Incidencias
(
	CodigoIncidencia INT NOT NULL AUTO_INCREMENT,
	CodigoPedido     INT NOT NULL,
	Descripcion      VARCHAR(100),
	FechaIncidencia  DATE,
	PRIMARY KEY (CodigoIncidencia),
	CONSTRAINT FOREIGN KEY cod (CodigoPedido)
		REFERENCES jardineria.pedidos (CodigoPedido)
);

INSERT INTO jardineria.Incidencias (CodigoPedido, Descripcion)
VALUES (1, 'No me ha llegado');

-- ====================
-- 9. Cambiale el NombreCliente al cliente 1 y llámalo "ElPrimero" (0,5 Puntos)
-- ====================
UPDATE jardineria.clientes
SET NombreCliente = 'ElPrimero'
WHERE CodigoCliente = 1;