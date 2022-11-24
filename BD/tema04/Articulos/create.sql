CREATE SCHEMA articulos;

CREATE TABLE articulos.articulos
(
	idArticulo  int         NOT NULL AUTO_INCREMENT,
	descripcion varchar(45) NOT NULL,
	PRIMARY KEY (idArticulo)
);

CREATE TABLE articulos.direccion
(
	idDireccion int         NOT NULL AUTO_INCREMENT,
	Calle       varchar(45) NOT NULL,
	Numero      varchar(10) DEFAULT NULL,
	Puerta      varchar(10) DEFAULT NULL,
	CP          varchar(10) DEFAULT NULL,
	Poblacion   varchar(10) DEFAULT NULL,
	PRIMARY KEY (idDireccion)
);


CREATE TABLE articulos.fabricas
(
	Nombre     varchar(45) NOT NULL,
	Telefono   varchar(20) NOT NULL,
	idFabricas int         NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (idFabricas)
);

CREATE TABLE articulos.clientes
(
	idClientes  int         NOT NULL AUTO_INCREMENT,
	NIF         varchar(12) NOT NULL,
	Nombre      varchar(45) NOT NULL,
	Saldo       float DEFAULT NULL,
	Credito     float DEFAULT NULL,
	idDireccion int   DEFAULT NULL,
	PRIMARY KEY (idClientes),
	CONSTRAINT clientes_direccion_fk FOREIGN KEY (idDireccion)
		REFERENCES direccion (idDireccion)
);


CREATE TABLE articulos.pedidos
(
	idPedido    int NOT NULL AUTO_INCREMENT,
	Fecha       date DEFAULT NULL,
	idDireccion int  DEFAULT NULL,
	idCliente   int  DEFAULT NULL,
	PRIMARY KEY (idPedido),
	CONSTRAINT pedidos_direccion_fk FOREIGN KEY (idDireccion)
		REFERENCES direccion (idDireccion),
	CONSTRAINT pedidos_cliente_fk FOREIGN KEY (idCliente)
		REFERENCES clientes (idClientes)
);

CREATE TABLE articulos.fabrica_articulo
(
	idFabrica   int NOT NULL,
	idArticulo  int NOT NULL,
	Existencias int NOT NULL,
	PRIMARY KEY (idFabrica, idArticulo),
	CONSTRAINT fabrica_fk FOREIGN KEY (idFabrica)
		REFERENCES fabricas (idFabricas),
	CONSTRAINT articulo_fk FOREIGN KEY (idArticulo)
		REFERENCES articulos (idArticulo)
);

CREATE TABLE articulos.pedido_articulo
(
	idPedido   int NOT NULL,
	idArticulo int NOT NULL,
	Cantidad   int NOT NULL,
	PRIMARY KEY (idPedido, idArticulo),
	CONSTRAINT detallePedido_fk FOREIGN KEY (idPedido)
		REFERENCES pedidos (idPedido),
	CONSTRAINT detalleArticulo_fk FOREIGN KEY (idArticulo)
		REFERENCES articulos (idArticulo)
);

CREATE TABLE articulos.incidencias
(
	idIncidencia int NOT NULL,
	idPedido     int NOT NULL,
	telefono     int,
	NIF          varchar(20),
	descripcion  int NOT NULL
);

ALTER TABLE articulos.incidencias
	DROP COLUMN NIF,
	MODIFY COLUMN telefono VARCHAR(25),
	MODIFY COLUMN descripcion varchar(45),
	ADD COLUMN notas varchar(45),
	ADD PRIMARY KEY (idIncidencia),
	ADD CONSTRAINT incidencias_fk1 FOREIGN KEY (idPedido)
		REFERENCES articulos.pedidos (idPedido),
	AUTO_INCREMENT = 100;

ALTER TABLE articulos.incidencias
	RENAME COLUMN notas TO notasJefe;

ALTER TABLE articulos.incidencias
	MODIFY idIncidencia int NOT NULL AUTO_INCREMENT;

DELETE
FROM articulos.incidencias
WHERE idIncidencia = 1;

TRUNCATE TABLE articulos.incidencias;