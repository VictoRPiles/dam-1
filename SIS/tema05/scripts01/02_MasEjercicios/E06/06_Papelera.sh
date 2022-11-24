#!bin/bash
# Victor Piles
# 15/02/2022 11:32

# Realiza un script utilizando el shell Bash de GNU/Linux que implemente una papelera.
# Deberá funcionar para cumplir con lo que se especifica a continuación
# - Se solicitará al usuario el nombre de un fichero a borrar. Sólo se podrán borrar ficheros regulares.
# - Si el usuario introduce el nombre de un directorio, se deberá avisar al usuario.
# - Si el fichero no existe en el directorio actual, se avisará al usuario.
# - Si el fichero existe se deberá eliminar del directorio actual y moverlo a la carpeta que funcione como papelera.
#   Antes de eliminar el fichero, se deberá pedir confirmación al usuario.
# - Se volverá a preguntar por el nombre de un fichero hasta que el usuario decida que no quiere continuar.
# - Si es la primera vez que se va a utilizar el script, se deberá crear la carpeta que funcionará como papelera en el
#   directorio home del usuario que ejecuta el script (podría ejecutarlo cualquier usuario, así que la carpeta puede
#   variar en función del usuario). Si no es la primera vez, simplemente se informará al usuario de dónde se encuentra
#   la papelera.

continuar=true

encontrar() {
	if [ $1 ]; then
		encontrados=$(find -name $1 | wc -l)
		if [ $encontrados -eq 0 ]; then
			echo "ERROR: No se ha encontrado el fichero"
			return 2
		elif (ls -p | grep / | grep $1) &>/dev/null; then
			echo "WARNING: El nombre introducido corresponde con un directorio"
		fi
	else
		echo "ERROR: Nombre del fichero en blanco"
		return 2
	fi
}

borrar() {
	if [ $? -ne 2 ]; then
		read -p "Seguro que quieres borrar $fichero? (s/N): " confirm

		if [ "$confirm" = "s" ] || [ "$confirm" = "S" ]; then
			if [ "$(ls $HOME | grep -wc papelera)" -eq 0 ]; then
				echo "Creando directorio $HOME/papelera"
				mkdir "$HOME/papelera"
			fi
			echo "Moviendo a $HOME/papelera"
			mv $fichero $HOME/papelera/$fichero
		else
			echo "Operación abortada"
		fi
	fi
}

while [ $continuar = true ]; do
	read -p "Introduce el nombre del fichero: " fichero

	encontrar $fichero
	borrar

	read -p "Borrar otro fichero? (s/N): " continuar
	if [ "$continuar" = "s" ] || [ "$continuar" = "S" ]; then
		continuar=true
	else
		continuar=false
	fi
done
