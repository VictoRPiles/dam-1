import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Victor
 * @since 16/05/2022 - 13:03
 */
public class Calculadora {
	private JFrame jFrame = new JFrame("Calculadora");
	private JPanel panel;
	private JTextField numero1Field;
	private JTextField numero2Field;
	private JButton sumarButton;
	private JLabel numero1Label;
	private JLabel numero2Label;
	private JLabel resultadoLabel;

	public Calculadora() {
		/* Iniciar el JFrame */
		jFrame.setContentPane(panel);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);

		sumarButton.addActionListener(new ActionListener() {
			/**
			 * Suma los valores de {@link Calculadora#numero1Field} y {@link Calculadora#numero2Field} y los muestra
			 * en {@link Calculadora#resultadoLabel}.
			 *
			 * @param e Invocado al hacer clic en el botón.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// Convertir los textos de los JTextEdit en números.
				double numUno = (Double.parseDouble(numero1Field.getText()));
				double numDos = (Double.parseDouble(numero2Field.getText()));
				// Realizar la suma
				double resultadoSuma = numUno + numDos;
				// Indicar el resultado en la etiqueta
				resultadoLabel.setText("Resultado: " + resultadoSuma);
			}
		});
	}
}