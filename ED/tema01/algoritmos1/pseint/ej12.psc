Algoritmo suma_pares
	Para i <- 1 Hasta 30 Con Paso paso Hacer
		Si ((i % 2) == 0) Entonces
			suma = suma + i
		Fin Si
		i = i + 1
	Fin Para
	
	Escribir "La suma es ", suma
FinAlgoritmo
