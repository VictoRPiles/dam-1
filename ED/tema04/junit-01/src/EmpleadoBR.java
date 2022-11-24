public class EmpleadoBR {
	private static final float SALARIO_BASE = 1000f;

	float calculaSalarioBruto(TipoEmpleado tipo, float ventasMes, float horasExtra) throws BRException {
		float salarioBruto;

		if (tipo == null || ventasMes < 0 || horasExtra < 0) throw new BRException();

		if (tipo.equals(TipoEmpleado.ENCARGADO)) salarioBruto = SALARIO_BASE + 500f;
		else salarioBruto = SALARIO_BASE;

		if (ventasMes >= 1500) salarioBruto += 200f;
		else if (ventasMes >= 1000) salarioBruto += 100f;

		salarioBruto += 20f * horasExtra;

		return salarioBruto;
	}

	float calculaSalarioNeto(float salarioBruto) throws BRException {
		if (salarioBruto < 0) throw new BRException("Salario bruto menor que 0");

		if (salarioBruto < 1000) return salarioBruto;
		else if (salarioBruto < 1500) return salarioBruto * (1 - 0.16f);
		else return salarioBruto * (1 - 0.18f);
	}
}