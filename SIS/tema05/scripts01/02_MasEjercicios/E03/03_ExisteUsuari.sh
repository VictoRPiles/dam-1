#!bin/bash
# Victor Piles
# 08/02/2022 11:49

# EJERCICIO 3. Realiza un script que pida el nombre de un usuario. Se deberá
# comprobar si el usuario está dado de alta en el sistema (es decir, si existe su
# cuenta) y devolver el mensaje oportuno (si está o no está dado de alta).

# Busca el id del nombre de usuario pasado por parámetro
# '&> /dev/null' permite silenciar la salida del comando
if id $1 &>/dev/null; then
	echo "El usuario existe"
else
	echo "El usuario NO existe"
fi
