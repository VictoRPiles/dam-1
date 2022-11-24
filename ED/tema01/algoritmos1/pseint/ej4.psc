Algoritmo mayorMenor
	Escribir 'Introduce el 1º numero'
	Leer num1
	Escribir 'Introduce el 2º numero'
	Leer num2
	Escribir 'Introduce el 3º numero'
	Leer num3
	Si num1>num2 Y num1>num3 Entonces
		Escribir num1,' es mayor'
	SiNo
		Si num2>num1 Y num2>num3 Entonces
			Escribir num2,' es mayor'
		SiNo
			Escribir num3,' es mayor'
		FinSi
	FinSi
	Si num1<num2 Y num1<num3 Entonces
		Escribir num1,' es menor'
	SiNo
		Si num2<num1 Y num2<num3 Entonces
			Escribir num2,' es menor'
		SiNo
			Escribir num3,' es menor'
		FinSi
	FinSi
FinAlgoritmo
