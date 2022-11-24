/* ===== INSERTANDO ARTÍCULOS ===== */
INSERT INTO articulos.fabricas (Nombre, Telefono)
VALUES ('fabrica_vlc', '622675544'),
       ('fabrica_bcn', '612121212'),
       ('fabrica_mad', '612345678');

INSERT INTO articulos.articulos (descripcion)
VALUES ('tornillo'),
       ('tuerca'),
       ('arandela'),
       ('clavo'),
       ('bisagra');

/* ===== EXISTENCIAS EN FÁBRICAS ===== */
INSERT INTO articulos.fabrica_articulo (idFabrica, idArticulo, Existencias)
VALUES (2, 1, 100),
       (2, 2, 150),
       (4, 2, 200),
       (4, 3, 100),
       (3, 3, 400),
       (3, 4, 100);

/* ===== INFORMACIÓN DE UN PEDIDO ===== */
INSERT INTO articulos.direccion (calle, numero, puerta, cp, poblacion)
VALUES ('de al Lado', 99, 5, 46001, 'Valencia');

INSERT INTO articulos.direccion (calle, numero, puerta, cp, poblacion)
VALUES ('Santos Patronos', 20, 1, 46600, 'Alzira');

INSERT INTO articulos.clientes (NIF, Nombre, idDireccion)
VALUES ('46112345X', 'Fulanito de Tal', 1);

INSERT INTO articulos.clientes (NIF, Nombre, idDireccion)
VALUES ('46100101X', 'Alberto Autoescuelas', 2);

INSERT INTO articulos.pedidos (Fecha, idDireccion, idCliente)
VALUES ('2021-12-14', 1, 1);

INSERT INTO articulos.pedido_articulo(idPedido, idArticulo, Cantidad)
VALUES (1, 2, 100),
       (1, 3, 200),
       (1, 1, 300);

UPDATE articulos.direccion
SET Calle = 'Gran Via'
WHERE idDireccion = 1;