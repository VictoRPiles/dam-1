#!bin/bash
# Victor Piles
# 01/02/2022 12:45

salir=false
i=0

while [ $salir = false ]; do

	# Si no es la primera volta de bucle (es a dir rep els arguments) o si els arguments rebuts estan vuits
	if [ $i -ne 0 ] || [[ "$1" = "" && "$2" = "" ]]; then
		read -rp "Introduce el primer numero: " num1
		read -rp "Introduce el segundo numero: " num2
	else
		num1=$1
		num2=$2
		((i++))
	fi

	if [ $num1 -eq $num2 ]; then
		echo "Son iguales"
	elif [ $num1 -gt $num2 ]; then
		echo "El $num1 es mayor que el $num2"
	else
		echo "El $num2 es mayor que el $num1"
	fi

	read -rp "Salir? (S/N) " opcion

	if [ $opcion = "S" ] || [ $opcion = "s" ]; then
		salir=true
	fi
done
