#!bin/bash
# Victor Piles
# 08/02/2022 11:37

# EJERCICIO 2. Realiza un script al que se le debe pasar un parámetro. En función del parámetro,
# la salida será distinta según la siguiente tabla (es similar al funcionamiento de un semáforo):
#
#	Entrada	Salida
#	verde	Pasa
#	ambar	Ve parando
#	Rojo	Para
#	Otra 	Para
#

read -p "Entrada: " entrada
echo -n "Salida: "
case $entrada in
verde) echo "Pasa" ;;
ambar) echo "Ve parando" ;;
rojo) echo "Para" ;;
*) echo "Para" ;;
esac
