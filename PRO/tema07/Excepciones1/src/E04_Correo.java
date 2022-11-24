/**
 * @author Victor Piles
 * @since 11/02/2022 8:56
 */
public class E04_Correo {

	private static class DirCorreoIncorrectaException extends Exception {

		public DirCorreoIncorrectaException(String message) {
			super(message);
		}

		@Override
		public String getMessage() {
			return super.getMessage();
		}
	}

	static void enviarMensaje(String correo) throws DirCorreoIncorrectaException {

		if (correo.indexOf('@') == -1) throw new DirCorreoIncorrectaException("Falta la arroba");
		else if (correo.indexOf('@', correo.indexOf('@') + 1) != -1)
			throw new DirCorreoIncorrectaException("Contiene más de una arroba");

		if (correo.indexOf('.', correo.indexOf('@')) == -1)
			throw new DirCorreoIncorrectaException("Falta el punto después de la arroba");
		else {
			if (correo.charAt(correo.length() - 1) == '.')
				throw new DirCorreoIncorrectaException("El correo acaba en punto");
			if (correo.charAt(correo.indexOf('@') + 1) == '.')
				throw new DirCorreoIncorrectaException("El punto está junto con la arroba");
		}
	}

	public static void main(String[] args) {

		String[] correos = {"niidea@gmail.com", "niideagmail.com", "niidea@gmail.com.", "niidea@gm@il.com", "niidea@gmailcom"};

		for (String correo : correos) {
			try {
				System.out.println("Analizando correo: " + correo);
				enviarMensaje(correo);
				System.out.println("CORREO CORRECTO");
			}
			catch (DirCorreoIncorrectaException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
