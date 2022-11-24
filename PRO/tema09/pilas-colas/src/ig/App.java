package ig;

import control.GestionListas;
import control.Pila;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
	private JButton insertar;
	private JTextField textField1;
	private JButton sacarPila;
	private JButton sacarCola;
	private JTextArea resultadoPila;
	private JTextArea resultadoCola;
	private JPanel main;
	private JLabel colaTamanyo;
	private JLabel pilaTamanyo;

	private String texto;

	public App() {
		setTitle("Pilas y Colas");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(main);

		insertar.addActionListener(new ActionListener() {

			/**
			 * Inserta el texto escrito en {@link App#textField1} en {@link GestionListas#cola} y {@link GestionListas#pila}.
			 *
			 * @see control.Pila#meter(Object)
			 * @see control.Cola#meter(Object)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				texto = textField1.getText();
				GestionListas.pila.meter(texto);
				GestionListas.cola.meter(texto);

				actualizarDatos();
			}
		});
		sacarPila.addActionListener(new ActionListener() {
			/**
			 * Saca un elemento de {@link GestionListas#pila}
			 *
			 * @see Pila#sacar()
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionListas.pila.sacar();

				actualizarDatos();
			}
		});
		sacarCola.addActionListener(new ActionListener() {
			/**
			 * Saca un elemento de {@link GestionListas#cola}
			 *
			 * @see control.Cola#sacar()
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionListas.cola.sacar();

				actualizarDatos();
			}
		});
	}

	/**
	 * Actualiza los datos de {@link App#resultadoPila} y {@link App#resultadoCola}.
	 */
	public void actualizarDatos() {
		resultadoPila.setText(GestionListas.pila.toString());
		resultadoCola.setText(GestionListas.cola.toString());

		pilaTamanyo.setText(String.valueOf(GestionListas.pila.tamanyo()));
		colaTamanyo.setText(String.valueOf(GestionListas.cola.tamanyo()));
	}

	public static void main(String[] args) {
		App app = new App();
	}
}