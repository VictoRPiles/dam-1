-- ====================
-- DATOS DE LOS OBJETOS DESDE LA TABLA TEMPORAL
-- ====================
INSERT INTO saguaro.objects (ID, catalogo, numero)
SELECT ID,
       TRIM(SUBSTRING(object, 1, LOCATE(' ', object))),
       TRIM(SUBSTRING(object, LOCATE(' ', object)))
FROM saguaro.tmp;

UPDATE saguaro.objects O, saguaro.tmp T
SET O.con  = TRIM(T.con),
    O.ra   = TRIM(T.ra),
    O.decl = TRIM(T.decl),
    O.mag  = TRIM(T.mag),
    O.tipo = TRIM(T.type)
WHERE O.ID = T.ID;

-- ====================
-- SIZE_MAX Y SIZE_MIN
-- ====================
-- MAX
UPDATE saguaro.objects O, (SELECT ID I, RIGHT(TRIM(size_max), 1) S, LEFT(TRIM(size_max), length(TRIM(size_max)) - 1) D
                           FROM saguaro.tmp) T
SET O.size_max = ROUND(IF(T.S = 'm', T.D * 60, T.D))
WHERE O.ID = T.I;

-- MIN
UPDATE saguaro.objects O, (SELECT ID I, RIGHT(TRIM(size_min), 1) S, LEFT(TRIM(size_min), length(TRIM(size_min)) - 1) D
                           FROM saguaro.tmp) T
SET O.size_min = ROUND(IF(T.S = 'm', T.D * 60, T.D))
WHERE O.ID = T.I;


-- ====================
-- DESCRIPCION DEL OBJETO DESDE LA TABLA TEMPORAL, ORDENADOS Y SEPARADOS
-- ====================
INSERT INTO saguaro.objetos_descrip (ID_OBJETO, descrip) (
    SELECT ID, Descripcion
    from (
             SELECT 1 Orden, ID, NGC_DESCR, trim(substring_index(NGC_DESCR, ';', 1)) DESCRIPCION
             from saguaro.tmp
             UNION
             SELECT 2                      Orden,
                    ID,
                    NGC_DESCR,
                    trim(replace(replace(substring_index(NGC_DESCR, ';', 2), SUBSTRING_INDEX(NGC_DESCR, ';', 1), ''),
                                 ';', '')) DESCRIPCION
             from saguaro.tmp
             UNION
             SELECT 3                      Orden,
                    ID,
                    NGC_DESCR,
                    trim(replace(replace(substring_index(NGC_DESCR, ';', 3), SUBSTRING_INDEX(NGC_DESCR, ';', 2), ''),
                                 ';', '')) DESCRIPCION
             from saguaro.tmp
             UNION
             SELECT 4                      Orden,
                    ID,
                    NGC_DESCR,
                    trim(replace(replace(substring_index(NGC_DESCR, ';', 4), SUBSTRING_INDEX(NGC_DESCR, ';', 3), ''),
                                 ';', '')) DESCRIPCION
             from saguaro.tmp
             UNION
             SELECT 5                      Orden,
                    ID,
                    NGC_DESCR,
                    trim(replace(replace(substring_index(NGC_DESCR, ';', 5), SUBSTRING_INDEX(NGC_DESCR, ';', 4), ''),
                                 ';', '')) DESCRIPCION
             from saguaro.tmp
             UNION
             SELECT 6                      Orden,
                    ID,
                    NGC_DESCR,
                    trim(replace(replace(substring_index(NGC_DESCR, ';', 6), SUBSTRING_INDEX(NGC_DESCR, ';', 5), ''),
                                 ';', '')) DESCRIPCION
             from saguaro.tmp
             UNION
             SELECT 7                      Orden,
                    ID,
                    NGC_DESCR,
                    trim(replace(replace(substring_index(NGC_DESCR, ';', 7), SUBSTRING_INDEX(NGC_DESCR, ';', 6), ''),
                                 ';', '')) DESCRIPCION
             from saguaro.tmp
         ) as desordenado
    where DESCRIPCION <> NULL
       or DESCRIPCION <> ''
    order by ID, Orden);