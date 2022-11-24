import shlex
import subprocess


def main():
    salir = False
    info_inicial()
    while not salir:
        salir = menu()


def ex_comand(comand):
    subprocess.call(shlex.split(comand))


def info_inicial():
    ex_comand("ip a")
    ex_comand("pwd")


def menu():
    print("1) Búsqueda de software")
    print("2) Instalación de software")
    print("3) Salir")
    op = input("> ")

    if op == "1":
        buscar_software()
    elif op == "2":
        instalar_software()
    elif op == "3":
        return True
    else:
        print("Opción incorrecta")
        menu()


def buscar_software():
    paquete = input("Introduce el nombre del paquete -> ")
    ex_comand("apt search " + paquete)


def instalar_software():
    paquete = input("Introduce el nombre del paquete -> ")
    ex_comand("sudo apt install " + paquete)


main()