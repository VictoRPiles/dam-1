-- ====================
-- SELECT DESDE EL INICIO HASTA EL PRIMER ESPACIO
-- ====================
SELECT TRIM(SUBSTRING(object, 1, LOCATE(' ', object)))
FROM saguaro.tmp;

-- ====================
-- SELECT DESDE EL PRIMER ESPACIO HASTA EL FINAL
-- ====================
SELECT TRIM(SUBSTRING(object, LOCATE(' ', object)))
FROM saguaro.tmp;

-- ====================
-- SELECT LOS DOS PERO EN SEPARADO
-- ====================
SELECT TRIM(SUBSTRING(object, 1, LOCATE(' ', object))), TRIM(SUBSTRING(object, LOCATE(' ', object)))
FROM saguaro.tmp;

-- ====================
-- LONGITUD MAXIMA DE LA DESCRIPCION DEL CATALOGO
-- ====================
SELECT MAX(LENGTH(ngc_descr))
FROM saguaro.tmp;

-- ====================
-- PASAR LOS DATOS size_min Y size_max de MINUTOS A SEGUNDOS
-- ====================
SELECT I, O, ROUND(IF(RIGHT(T.S, 1) = 'm', D * 60, D))
FROM (SELECT id I, size_max O, TRIM(size_max) S, TRIM(LEFT(size_max, 7)) D FROM saguaro.tmp) T;