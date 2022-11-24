#!bin/bash
# Victor Piles
# 04/02/2022 12:46

demanar() {
	read -p "Primer numero: " num1
	read -p "Segon numero: " num2
}

menu() {
	PS3='Selecciona una opcio: '
	options=("Suma" "Resta" "Multiplicacion" "Division" "Salir")
	select opt in "${options[@]}"; do

		case $opt in
		Suma)
			demanar
			echo $((num1 + num2))
			;;
		Resta)
			demanar
			echo $((num1 - num2))
			;;
		Multiplicacion)
			demanar
			echo $((num1 * num2))
			;;
		Division)
			demanar
			echo $((num1 / num2))
			;;
		Salir) break ;;
		*) echo "ERROR: Operacio incorrecta $REPLY" ;;
		esac
	done
}

menu
echo "INFO: Exit status $?"
