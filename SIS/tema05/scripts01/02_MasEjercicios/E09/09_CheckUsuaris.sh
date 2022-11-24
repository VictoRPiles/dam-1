#!bin/bash
# Victor Piles
# 08/02/2022 12:01

# EJERCICIO 9. Realiza un script que muestre por pantalla los usuarios con
# identificador mayor o igual que 1000. Se deberá comprobar si tienen asignado
# un shell por defecto y si no lo tiene, se les asignará /bin/bash. Te sugiero que
# utilices como base el ejercicio de la página 28 del presente documento.

IFS=":" # Separador
while read nom dos idUsusari cuatre cinc sis shell; do

	# Si la variable $shell esta buida
	if [ -z "$shell" ]; then
		# Si el usuari que executa el script no es root
		if [[ $EUID -ne 0 ]]; then
			echo "ERROR: No tens permisos per a executar usermod al usuari $nom"
			echo "       Executa com a administrador per a fer-ho"
		else
			usermod $nom -s /bin/bash
			# Solament per a que es mostre correctament al output, NO ES CANVIA LA SHELL ASI
			shell=/bin/bash
		fi
	fi

	# Si el usuari te un ID major que 1000, es a dir que es un usuari amb el que es pot fer login
	if [ $idUsusari -ge 1000 ]; then
		echo "Usuario: $nom Shell: $shell"
	fi

done </etc/passwd
