CREATE SCHEMA saguaro;

-- ====================
-- TABLA TEMPORAL PARA IMPORTAR LOS DATOS
-- ====================
CREATE TABLE saguaro.tmp
(
    ID        INT NOT NULL AUTO_INCREMENT,
    object    VARCHAR(17),
    type      VARCHAR(5),
    con       VARCHAR(3),
    ra        VARCHAR(7),
    decl      VARCHAR(6),
    mag       VARCHAR(4),
    size_max  VARCHAR(8),
    size_min  VARCHAR(8),
    ngc_descr VARCHAR(55),
    notes     VARCHAR(86),
    PRIMARY KEY (ID)
);

-- ====================
-- TIPOS DE OBJETOS
-- ====================
CREATE TABLE saguaro.types
(
    ID      VARCHAR(5) NOT NULL,
    descrip VARCHAR(100),
    PRIMARY KEY (ID)
);

-- ====================
-- OBJETOS
-- ====================
CREATE TABLE saguaro.objects
(
    ID       INT NOT NULL,
    catalogo VARCHAR(10),
    numero   VARCHAR(13),
    PRIMARY KEY (ID)
);

ALTER TABLE saguaro.objects
    ADD COLUMN tipo     VARCHAR(5),
    ADD COLUMN con      VARCHAR(3),
    ADD COLUMN ra       VARCHAR(7),
    ADD COLUMN decl     VARCHAR(6),
    ADD COLUMN mag      VARCHAR(4),
    ADD COLUMN size_max FLOAT,
    ADD COLUMN size_min FLOAT
;

-- ====================
-- CATALOGOS
-- ====================
CREATE TABLE saguaro.catalogo
(
    ID      INT NOT NULL AUTO_INCREMENT,
    nombre  VARCHAR(10),
    descrip VARCHAR(55),
    PRIMARY KEY (ID)
);

-- ====================
-- CONSTELACIONES
-- ====================
CREATE TABLE saguaro.constelaciones
(
    ID      INT NOT NULL AUTO_INCREMENT,
    nombre  VARCHAR(3),
    descrip VARCHAR(18),
    PRIMARY KEY (ID)
);

-- ====================
-- DESCRIPCION CATALOGO
-- ====================
CREATE TABLE saguaro.catal_descrip
(
    ID          INT NOT NULL AUTO_INCREMENT,
    abreviatura VARCHAR(6),
    descrip     VARCHAR(23),
    PRIMARY KEY (ID)
);

-- ====================
-- DESCRIPCION OBJETOS
-- ====================
CREATE TABLE saguaro.objetos_descrip
(
    ID        INT NOT NULL AUTO_INCREMENT,
    ID_OBJETO INT NOT NULL,
    descrip   VARCHAR(55),
    PRIMARY KEY (ID, ID_OBJETO)
);