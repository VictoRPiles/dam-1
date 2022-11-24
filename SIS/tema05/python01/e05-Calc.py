def setDatos():
	a = input("Introduce el primer valor\n> ")
	b = input("Introduce el segundo valor\n> ")

	return [a, b]


def suma(a, b):
	return int(a) + int(b)


def resta(a, b):
	return int(a) - int(b)


def multi(a, b):
	return int(a) * int(b)


def divide(a, b):
	return int(a) / int(b)


def menu():
	salir = False

	while not salir:
		print("1) Suma          2) Resta")
		print("3) Multiplica    4) Divide")
		print("5) Salir")
		op = int(input("> "))

		if op == 1:
			datos = setDatos()
			print("Resultado ->", suma(datos[0], datos[1]))
		elif op == 2:
			datos = setDatos()
			print("Resultado ->", resta(datos[0], datos[1]))
		elif op == 3:
			datos = setDatos()
			print("Resultado ->", multi(datos[0], datos[1]))
		elif op == 4:
			datos = setDatos()
			print("Resultado ->", divide(datos[0], datos[1]))
		else:
			salir = True
			print("Cerrando programa...")


menu()
