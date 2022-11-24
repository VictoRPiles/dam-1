package calculadora;

public class Calculadora {
	public int resta(int num1, int num2) {
		if (esMayor(num1, num2)) return num1 - num2;
		else return num2 - num1;
	}

	public String divide(int num1, int num2) {
		if (num2 == 0) return null;

		return String.valueOf(num1 / num2);
	}

	public boolean esMayor(double num1, double num2) {
		return num1 > num2;
	}
}