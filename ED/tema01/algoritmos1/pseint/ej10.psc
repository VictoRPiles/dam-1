Algoritmo lea_hasta_cero
	i = 0
	suma = 0
	Repetir
		suma = suma + num
		Escribir "Introduce un numero"
		Leer num
		i = i + 1
	Hasta Que num == 0
	// no tomaremos en cuenta el ultimo numero, solo es para salir
	promedio = suma / (i - 1) 
	
	Escribir "La suma total es ", suma
	Escribir "El promedio es ", promedio
FinAlgoritmo
