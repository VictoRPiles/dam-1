Algoritmo billeteBus
	
	// 0,30 ?/ Km
	// Km > 80 -> Descuento 15%
	// Dia = Laborable (L) -> Descuento 5%
	
	Escribir "Introduce los Km"
	Leer km
	Escribir "Introduce el tipo de dia (L, F)"
	Leer dia
	
	Si km > 80 Y dia == 'L' Entonces			// mas de 80 y laboral
		precio = ((km * 0.3) * 0.85) * 0.95
	SiNo
		Si km > 80 Y dia <> 'L' Entonces		// mas de 80 y festivo
			precio = (km * 0.3) * 0.85
		SiNo
			Si km <= 80 Y dia == 'L' Entonces	// menos de 80 y laboral
				precio = (km * 0.3) * 0.95
			SiNo								// menos de 80 y festivo
				precio = km * 0.3
			Fin Si
		Fin Si
	Fin Si
	
	Escribir "Precio del billete ", precio
	
FinAlgoritmo
