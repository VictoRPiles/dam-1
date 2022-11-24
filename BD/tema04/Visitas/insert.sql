-- ==============================
-- DEPARTAMENTOS
-- ==============================
INSERT INTO visitas.departamentos (nombre)
VALUES ('Administración'),
       ('Compras'),
       ('Extrusión'),
       ('Logística'),
       ('Almacén');

-- ==============================
-- EMPLEADOS
-- ==============================
INSERT INTO visitas.empleados (nombre, id_departamento)
VALUES ('Andrés Fernández', 3),
       ('Jorge Gómez', 1), -- UN POCO RARO LO DE TENER DOS PERSONAS "IGUALES"
       ('Marisa Jiménez', 2),
       ('Felipe García', 3),
       ('Isabel Ortíz', 1),
       ('Jorge Gómez', 1), -- UN POCO RARO LO DE TENER DOS PERSONAS "IGUALES"
       ('Antonio López', 2),
       ('Patricia Vera', 4);
-- EMPLEADO SIN DEPARTAMENTO
INSERT INTO visitas.empleados (nombre)
VALUES ('Empleado Pruebas');

-- ==============================
-- EMPRESAS
-- ==============================
INSERT INTO visitas.empresas (nombre)
VALUES ('Plásticos Pérez'),
       ('Pinturas López'),
       ('Mecanizados Sánchez'),
       ('Extrusiones reunidas');

-- ==============================
-- VISITANTES
-- ==============================
INSERT INTO visitas.visitantes (dni, nombre, id_empresa)
VALUES ('11111111A', 'José Pérez', 1),
       ('22222222B', 'Juana López', 2),
       ('33333333C', 'Luís Sánchez', 3),
       ('44444444D', 'Marcos Andrés', 2),
       ('55555555D', 'Eva Uve', 1);

-- ==============================
-- REGISTRO
-- ==============================
INSERT INTO visitas.registro (id_visitante, id_empleado, fecha)
VALUES (1, 1, '2021-06-01'),
       (2, 2, '2021-06-01'),
       (3, 3, '2021-06-01'),
       (1, 4, '2021-06-02'),
       (3, 5, '2021-06-02'),
       (4, 6, '2021-06-03'); -- INTERPRETO QUE ES EL OTRO JORGE (id_empleado = 6)
