/*
 Realiza una consulta al registro de visitas para saber las visitas que ha recibido el departamento de administración.
 Muestra NIF, Nombre, Empresa, Fecha, Persona Visitada y Departamento
 */
SELECT VISITANTES.dni,
       VISITANTES.nombre,
       EMPRESAS.nombre,
       REGISTRO.fecha,
       EMPLEADOS.nombre,
       DEPART.nombre
FROM visitas.visitantes VISITANTES,
     visitas.empresas EMPRESAS,
     visitas.registro REGISTRO,
     visitas.empleados EMPLEADOS,
     visitas.departamentos DEPART
WHERE VISITANTES.ID = REGISTRO.ID_visitante
  AND VISITANTES.ID_empresa = EMPRESAS.ID
  AND EMPLEADOS.ID = REGISTRO.ID_empleado
  AND EMPLEADOS.ID_departamento = DEPART.ID;

/*
 Realiza un consulta para obtener un informe (listado) donde aparezcan todos los departamentos y los nombres de sus
 empleados, Si un departamento no tiene empleados también debe aparecer, pero con los campos de empleado en blanco.
 */
SELECT DEPT.nombre, EMPLEADOS.nombre
FROM visitas.departamentos DEPT
         LEFT JOIN visitas.empleados EMPLEADOS
                   ON DEPT.ID = EMPLEADOS.ID_departamento;
