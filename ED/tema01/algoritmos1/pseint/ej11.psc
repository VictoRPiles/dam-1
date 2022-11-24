Algoritmo lea_10
	Para i <- 0 Hasta 9 Con Paso paso Hacer
		
		Escribir "Introduce un numero"
		Leer num
		
		Si i == 0 Entonces
			numMaxAnterior = num
			numMinAnterior = num
		Fin Si
		
		Si num > numMaxAnterior Entonces
			numMaxAnterior = num
		SiNo
			Si num < numMinAnterior Entonces
				numMinAnterior = num
			Fin Si
		Fin Si
		
		i = i + 1
		
	Fin Para
	Escribir "El maximo es ", numMaxAnterior
	Escribir "El minimo es ", numMinAnterior
FinAlgoritmo
