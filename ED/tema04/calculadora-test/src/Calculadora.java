public class Calculadora {
	private float num1, num2;

	public Calculadora(float num1, float num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public float suma() {
		return num1 + num2;
	}

	public float resta() {
		return num1 - num2;
	}

	public float multiplica() {
		return num1 * num2;
	}

	public float divide() {
		try {
			if (num2 == 0) throw new ArithmeticException("División entre 0");

			return num1 / num2;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());

			return 0;
		}
	}
}
