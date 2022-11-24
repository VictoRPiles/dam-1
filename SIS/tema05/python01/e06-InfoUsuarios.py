import shlex
import subprocess

usuario = input("Dime el nombre de un usuario para ver sus grupos: ")

print("Grupo principal: ")
subprocess.call(shlex.split(("id -ng " + usuario)))

print("Grupos secundarios: ")
subprocess.call(shlex.split(("id -nG " + usuario)))
