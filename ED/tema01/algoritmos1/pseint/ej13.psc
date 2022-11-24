Algoritmo pasosTelefonicos
	Escribir "Introduce los pasos"
	Leer pasos
	
	Si pasos > 0 Entonces
		Si pasos <= 1000 Entonces
			factura = pasos * 0.1
		SiNo
			factura = (pasos * 0.1) * 0.82 // 100% - 18% = 82%
		Fin Si
		Escribir "El precio de la factura es ", factura, " euros"
	SiNo
		Escribir "No puedes introduir menos de 1 paso"
	Fin Si
	
FinAlgoritmo
