#!bin/bash
# Victor Piles
# 22/02/2022 12:40

menu() {
	PS3="Elige una opción (1-6): "
	select i in "Visualizar los grupos existentes" "Mostrar lso grupos que sean grupos secundarios de algún usuario" "Crear un nuevo grupo" "Borrar un grupo" "Incluir a un usuario en un grupo" "Salir"; do
		case $i in
		"Visualizar los grupos existentes") gruposExistentes ;;
		"Mostrar lso grupos que sean grupos secundarios de algún usuario") gruposSecundarios ;;
		"Crear un nuevo grupo") grupoNuevo ;;
		"Borrar un grupo") grupoBorrar ;;
		"Incluir a un usuario en un grupo") grupoInsertar ;;
		*)
			echo "CERRANDO PROGRAMA..."
			return 1
			;;
		esac
	done
}

gruposExistentes() {
	IFS=":"
	while read grupo otro id otro; do
		echo "GRUPO -> $grupo | ID -> $id"
	done </etc/group
}

gruposSecundarios() {
	IFS=":"
	while read grupo otro id usuarios; do
		if [ $usuarios ]; then
			echo "GRUPO -> $grupo | ID -> $id | USUARIOS -> $usuarios"
		fi

	done </etc/group
}

grupoNuevo() {
	echo "WARNING: SE NECESITAN PERMISOS DE ADMINISTRADOR"
	read -p "Nombre para el grupo nuevo: " nombre
	read -p "GID para el grupo nuevo: " gid

	echo "Creando grupo $nombre con GID $gid"
	sudo groupadd -g $gid $nombre
}

grupoBorrar() {
	echo "WARNING: SE NECESITAN PERMISOS DE ADMINISTRADOR"
	read -p "Nombre para el grupo a borrar: " nombre

	echo "Borrando grupo $nombre"
	sudo groupdel $nombre
}

grupoInsertar() {
	echo "WARNING: SE NECESITAN PERMISOS DE ADMINISTRADOR"
	read -p "Nombre del usuario: " usuario
	read -p "Nombre del grupo: " grupo

	echo "Añadiendo al grupo $grupo el usuario $usuario"
	sudo usermod -aG $grupo $usuario
}

menu
