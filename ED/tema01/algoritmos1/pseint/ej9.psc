Algoritmo lea_n
	Escribir "Introduzca numero N"
	Leer n
	
	i = 0
	suma = 0
	Mientras i < n Hacer
		Escribir "Introduzca un numero"
		Leer num
		suma = suma + num
		i = i + 1
	Fin Mientras
	promedio = suma / n
	
	Escribir "La suma total es ", suma
	Escribir "El promedio es ", promedio
FinAlgoritmo
