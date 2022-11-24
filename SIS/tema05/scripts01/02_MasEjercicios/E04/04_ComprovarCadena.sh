#!bin/bash
# Victor Piles
# 08/02/2022 12:52

# EJERCICIO 4. Realiza un script que pida una cadena. Se deberá comprobar si
# dicha cadena:
# - corresponde al nombre de un fichero en el directorio actual (en este
#   caso la salida será “La cadena corresponde a un fichero”),
# - si corresponde a un directorio en el directorio actual (salida “La
#   cadena corresponde a un directorio”)
# - o no es ninguno de los dos (salida “No es ni un fichero ni un
#   directorio").
# Se deberán pedir cadenas hasta que el usuario decida que no quiere
# continuar.

read -p "Introdueix una cadena: " cadena
# Si no es deixa en blanc
while [ $cadena ]; do
	status=0

	# ls -p afig '/' al final dels directoris i grep -v inverteix les coincidencies
	# OJO: soles trovara coincidencies amb fitxers, NO DIRECTORIS
	if (ls -p | grep -v / | grep $cadena) &>/dev/null; then
		echo "Coincideix amb els fitxers"
		ls -p | grep -v / | grep $cadena
	else
		status=1
	fi

	# OJO: soles trovara coincidencies amb directoris, NO FITXERS
	if (ls -p | grep / | grep $cadena) &>/dev/null; then
		echo "Coincideix amb els directoris"
		ls -p | grep / | grep $cadena
	else
		if [ $status -eq 1 ]; then
			status=3
		else
			status=2
		fi
	fi

	case $status in
	1) echo "No coincideix amb ningun fitxer" ;;
	2) echo "No coincideix amb ningun directori" ;;
	3) echo "No coincideix amb ningun fitxer ni directori" ;;
	esac

	read -p "Introduce una cadena: " cadena
done
