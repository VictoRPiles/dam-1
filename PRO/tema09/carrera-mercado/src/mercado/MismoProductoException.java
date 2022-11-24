package mercado;

public class MismoProductoException extends Exception {
	public MismoProductoException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}