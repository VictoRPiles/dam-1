CREATE SCHEMA visitas;

-- ==============================
-- VISITANTES
-- ==============================
CREATE TABLE visitas.empresas
(
    ID     int         NOT NULL AUTO_INCREMENT,
    nombre varchar(40) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE visitas.visitantes
(
    ID         int         NOT NULL AUTO_INCREMENT,
    dni        varchar(9)  NOT NULL,
    nombre     varchar(40) NOT NULL,
    ID_empresa int         NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FOREIGN KEY visitantes_empresas_fk (ID_empresa)
        REFERENCES visitas.empresas (ID)
);

-- ==============================
-- MI EMPRESA
-- ==============================
CREATE TABLE visitas.departamentos
(
    ID     int         NOT NULL AUTO_INCREMENT,
    nombre varchar(40) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE visitas.empleados
(
    ID              int         NOT NULL AUTO_INCREMENT,
    nombre          varchar(40) NOT NULL,
    ID_departamento int         NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FOREIGN KEY empleados_departamentos_fk (ID_departamento)
        REFERENCES visitas.departamentos (ID)
);
-- ARREGLO PARA PODER TENER EMPLEADOS SIN DEPARTAMENTO
ALTER TABLE visitas.empleados
    MODIFY ID_departamento INT;

-- ==============================
-- REGISTRO
-- ==============================
CREATE TABLE visitas.registro
(
    ID_visitante int  NOT NULL,
    ID_empleado  int  NOT NULL,
    fecha        date NOT NULL,
    PRIMARY KEY (ID_visitante, ID_empleado, fecha),
    CONSTRAINT FOREIGN KEY registro_visitante_fk (ID_visitante)
        REFERENCES visitas.visitantes (ID),
    CONSTRAINT FOREIGN KEY registro_empleado_fk (ID_empleado)
        REFERENCES visitas.empleados (ID)
);