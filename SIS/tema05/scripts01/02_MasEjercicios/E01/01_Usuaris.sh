#!bin/bash
# Victor Piles
# 08/02/2022 11:25

# EJERCICIO 1. En este ejercicio realizaremos la creación de usuarios a partir de los datos contenidos en un fichero.

IFS=","
while read firstname lastname userid; do
	PS=$(openssl passwd ${firstname})
	useradd -c "${firstname} ${lastname}" -p $PS -m -d /home/"${userid}" -s /bin/bash "${userid}"
	chage -d 0 ${userid}
	echo "Usuario: ${userid} – Contraseña cifrada: $PS ....." >>resultado.txt
done <01_users.csv
