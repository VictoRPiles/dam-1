Algoritmo alternativa4
	Leer nota
	
	Si (nota <= 10 Y nota >= 0)
		Si (nota >= 9)
			Escribir "SOB"
		SiNo
			Si (nota >= 7)
				Escribir "NOT"
			SiNo
				Si( nota >= 5)
					Escribir "BIEN"
				SiNo
					Si (nota >= 3)
						Escribir "INS"
					SiNo
						Si (nota >= 0)
							Escribir "MD"
						FinSi
					FinSi
				FinSi
			FinSi
		FinSi
	SiNo
		Escribir "ERROR: Nota no valida"
	FinSi
FinAlgoritmo
