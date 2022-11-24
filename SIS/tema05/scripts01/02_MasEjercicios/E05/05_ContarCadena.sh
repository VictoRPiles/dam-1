#!bin/bash
# Victor Piles
# 15/02/2022 11:27

# Realiza un script que cuente el número de caracteres de una cadena que se
# le solicita al usuario.

read -p "Introdueix una cadena: " cadena

if [ $cadena ]; then
	echo "Longitud de la cadena: ${#cadena}"
else
	echo "ERROR: La cadena esta en blanc"
fi
