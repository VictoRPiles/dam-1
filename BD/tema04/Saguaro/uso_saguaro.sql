-- ====================
-- 1.- MOSTRAR LA DESCRIPCIÓN DE LA CONSTELACIÓN EN LA TABLA OBJETOS
-- ====================
SELECT O.ID,
       O.catalogo,
       O.numero,
       O.tipo,
       O.con,
       C.descrip,
       O.ra,
       O.decl,
       O.mag,
       O.size_max,
       O.size_min
FROM saguaro.objects O,
     saguaro.constelaciones C
WHERE O.con = C.nombre;

-- ====================
-- 2.- AÑADIR LA DESCRIPCIÓN DE TIPO DE OBJETO
-- ====================
SELECT DATOS.ID,
       DATOS.catalogo,
       DATOS.numero,
       DATOS.tipo,
       T.descrip,
       DATOS.con,
       DATOS.descrip,
       DATOS.ra,
       DATOS.decl,
       DATOS.mag,
       DATOS.size_max,
       DATOS.size_min
FROM (SELECT O.ID,
             O.catalogo,
             O.numero,
             O.tipo,
             O.con,
             C.descrip,
             O.ra,
             O.decl,
             O.mag,
             O.size_max,
             O.size_min
      FROM saguaro.objects O,
           saguaro.constelaciones C
      WHERE O.con = C.nombre) DATOS
         LEFT JOIN saguaro.types T ON DATOS.tipo = T.ID;

-- ====================
-- 3.- OBJETOS EN LA CONSTELACION DE ORION
-- ====================
SELECT O.ID,
       O.con,
       C.descrip
FROM saguaro.objects O,
     saguaro.constelaciones C
WHERE O.con = C.nombre
  AND C.descrip = 'ORION';

-- ====================
-- 4.- ¿Cuantos objetos son?
-- ====================
SELECT COUNT(*)
FROM (SELECT O.ID,
             O.con,
             C.descrip,
             O.mag
      FROM saguaro.objects O,
           saguaro.constelaciones C
      WHERE O.con = C.nombre
        AND C.descrip = 'ORION') DATOS;

-- ====================
-- 5.- OBJETOS EN ORION CON MAGNITUD INFERIOR A 8
-- ====================
SELECT COUNT(*)
FROM (SELECT O.ID,
             O.con,
             C.descrip,
             O.mag
      FROM saguaro.objects O,
           saguaro.constelaciones C
      WHERE O.con = C.nombre
        AND C.descrip = 'ORION') DATOS
WHERE DATOS.mag < 8;

-- ====================
-- 6.- QUÉ DESCRIPCION/NOTAS TIENEN ESOS OBJETOS
-- ====================
SELECT DATOS.ID,
       DATOS.con,
       DATOS.descrip,
       DATOS.mag,
       T.ngc_descr,
       T.notes
FROM (SELECT O.ID,
             O.catalogo,
             O.numero,
             O.tipo,
             O.con,
             C.descrip,
             O.ra,
             O.decl,
             O.mag,
             O.size_max,
             O.size_min
      FROM saguaro.objects O,
           saguaro.constelaciones C
      WHERE O.con = C.nombre
        AND C.descrip = 'ORION') DATOS,
     saguaro.tmp T
WHERE DATOS.mag < 8
  AND DATOS.ID = T.ID;

-- ====================
-- 7.- OBJETOS EN ORION Y MAGNITUD < 8 CON DESCRIPCION 'vL'
-- ====================
SELECT DATOS.ID, DATOS.con, DATOS.descrip, DATOS.mag, OD.descrip
FROM (SELECT O.ID,
             O.con,
             C.descrip,
             O.mag
      FROM saguaro.objects O,
           saguaro.constelaciones C
      WHERE O.con = C.nombre
        AND C.descrip = 'ORION') DATOS,
     saguaro.objetos_descrip OD
WHERE DATOS.mag < 8
  AND DATOS.ID = OD.ID_OBJETO
  AND OD.descrip = 'vL';

-- ====================
-- 8.- ORDENAR POR MAGNITUD Y TAMAÑO
-- ====================
-- POR MAG
SELECT O.ID, O.mag
FROM saguaro.objects O
ORDER BY O.mag DESC;
-- POR TAM
SELECT O.ID, O.size_max
FROM saguaro.objects O
ORDER BY O.size_max DESC;

-- ====================
-- 9.- LOS OBJETOS MAS GRANDES (size_max) POR CONSTELACION
-- ====================
SELECT O.ID, O.con, O.size_max
FROM (SELECT con, MAX(size_max) MAXIMO FROM saguaro.objects GROUP BY con) LISTA,
     saguaro.objects O
WHERE O.con = LISTA.con
  AND O.size_max = LISTA.MAXIMO;

-- ====================
-- 10.- SUMA TODOS LAS LONGITUDES DE TODOS LOS OBJETOS POR TIPO
-- ====================
SELECT SUM(size_max), tipo
FROM saguaro.objects
GROUP BY tipo;

-- ====================
-- 11.- CUENTA CUANTOS OBEJTOS HAY DE MAGNITUD < 8
-- ====================
SELECT COUNT(*)
FROM (SELECT mag
      FROM saguaro.objects) MAGS
WHERE MAGS.mag < 8;