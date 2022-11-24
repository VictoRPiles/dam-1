DROP PROCEDURE IF EXISTS jardineria.getCodigoNivelSuperior;
CREATE PROCEDURE jardineria.getCodigoNivelSuperior(IN p_CodigoEmpleado INT UNSIGNED, IN p_Nivel INT UNSIGNED)
BEGIN
	DECLARE Codigo INT;

	/* Si el nivel introducido es inferior al nivel del empleado */
	IF p_Nivel > (SELECT nivel FROM empleados WHERE CodigoEmpleado = p_CodigoEmpleado) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El nivel introducido es inferior al nivel del empleado';
	END IF;

	/* Si este empleado tiene el nivel, devuelve el CodigoEmpleado */
	IF p_Nivel = (SELECT nivel FROM empleados WHERE CodigoEmpleado = p_CodigoEmpleado) THEN
		SET Codigo = p_CodigoEmpleado;
	END IF;

	/* Si no tiene jefe es porque está arriba en la jerarquía, devuelve 0 */
	IF (SELECT CodigoJefe FROM empleados WHERE CodigoEmpleado = p_CodigoEmpleado) IS NULL THEN
		SET Codigo = 0;
	END IF;

	IF Codigo IS NULL THEN
		SET max_sp_recursion_depth = 50;

		/* Repetir el proceso con el empleado superior */
		CALL getCodigoNivelSuperior((SELECT CodigoJefe FROM empleados WHERE CodigoEmpleado = p_CodigoEmpleado),
									p_Nivel);
	ELSE
		SELECT Codigo;
	END IF;
END;