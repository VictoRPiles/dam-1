Algoritmo calculadora
	Escribir "Introduce el 1º numero"
	Leer num1
	Escribir "Introduce el 2º numero"
	Leer num2
	Escribir "Introduce la operacion"
	Leer operacion
	Segun operacion Hacer
		"+":
			resultado = num1 + num2
		"-":
			resultado = num1 - num2
		"*":
			resultado = num1 * num2
		"/":
			resultado = num1 / num2
		De Otro Modo:
			Escribir "Operacion incorrecta"
	Fin Segun
	Escribir num1, " ", operacion, " ", num2, " = ", resultado
FinAlgoritmo