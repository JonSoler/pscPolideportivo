package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaModificarClientesAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JLabel labelDNI = new JLabel();
	private JLabel labelNombre = new JLabel();
	private JLabel labelApellido = new JLabel();
	private JLabel labelEdad = new JLabel();
	private JLabel labelEmail = new JLabel();
	private JLabel labelContrasenya = new JLabel();
	private JTextField textoDNI = new JTextField();
	private JTextField textoNombre = new JTextField();
	private JTextField textoApellido = new JTextField();
	private JTextField textoEdad = new JTextField();
	private JTextField textoEmail = new JTextField();
	private JPasswordField textoContrasenya = new JPasswordField();
	private JButton botonModificar = new JButton();
	private JButton botonAtras = new JButton();

	public class JNumberTextField extends JTextField {
		private static final long serialVersionUID = 1L;
	}

	public VentanaModificarClientesAdmin(final es.deusto.spq.client.Controller controller) {

		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		

		JLabel labelTitle = new JLabel("Editar Cliente");
		labelTitle.setFont(new Font("Forte", Font.BOLD, 40));
		labelTitle.setBounds(86, 36, 277, 50);
		contentpane.add(labelTitle);

		labelDNI.setText("DNI:");
		labelDNI.setOpaque(true);
		labelDNI.setBounds(108, 124, 44, 20);
		labelDNI.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(labelDNI, BorderLayout.SOUTH);
		
		labelNombre.setText(" Nombre:");
		labelNombre.setBounds(99, 175, 71, 20);
		labelNombre.setOpaque(true);
		labelNombre.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(labelNombre);
		
		labelApellido.setText("Apellido:");
		labelApellido.setBounds(98, 225, 61, 20);
		labelApellido.setOpaque(true);
		labelApellido.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(labelApellido);
				
		labelEdad.setText("Edad:");
		labelEdad.setBounds(107, 275, 99, 20);
		labelEdad.setOpaque(true);
		labelEdad.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(labelEdad);
		
		labelEmail.setText("Email:");
		labelEmail.setBounds(104, 325, 71, 20);
		labelEmail.setOpaque(true);
		labelEmail.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(labelEmail);
		
		labelContrasenya.setText(" Contraseña:");
		labelContrasenya.setBounds(86, 375, 120, 20);
		labelContrasenya.setOpaque(true);
		labelContrasenya.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(labelContrasenya);
		
		botonModificar.setForeground(SystemColor.text);
		botonModificar.setBackground(new Color(0, 51, 255));
		botonModificar.setBounds(139, 470, 143, 32);
		botonModificar.setText("Guardar");
		botonModificar.setFont(new Font("Goudy Old Style", Font.BOLD, 17));
		contentpane.add(botonModificar);
		
		botonAtras.setForeground(Color.BLACK);
		botonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		botonAtras.setBounds(10, 521, 71, 29);
		botonAtras.setText("Atrás");
		botonAtras.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(botonAtras);

		textoDNI.setBounds(214, 125, 143, 20);
		contentpane.add(textoDNI);

		textoNombre.setBounds(214, 175, 143, 20);
		contentpane.add(textoNombre);

		textoApellido.setBounds(216, 225, 143, 20);
		contentpane.add(textoApellido);
		
		textoEdad.setBounds(214, 275, 143, 20);
		contentpane.add(textoEdad);

		textoEmail.setBounds(214, 325, 143, 20);
		contentpane.add(textoEmail);

		textoContrasenya.setBounds(214, 375, 143, 20);
		contentpane.add(textoContrasenya);

		botonModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dni = textoDNI.getText().toString();
				String nombre = textoNombre.getText().toString();
				String apellido = textoApellido.getText().toString();
				String edad = textoEdad.getText().toString();
				String email = textoEmail.getText().toString();
				String contrasenya = textoContrasenya.getText().toString();
				boolean ModificacionCorrecta = false;
				boolean error = false;

				if (textoDNI.getText().equals("") || textoNombre.getText().equals("") || textoApellido.getText().equals("")
						|| textoEdad.getText().equals("")|| textoEmail.getText().equals("") || textoContrasenya.toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "Error",JOptionPane.INFORMATION_MESSAGE);
					VentanaModificarClientesAdmin.this.repaint();
					error = true;
				} else if (!error) {
					
					ModificacionCorrecta= true;
				}
				if (ModificacionCorrecta) {
					JOptionPane.showMessageDialog(null, "Cliente modificado correctamente.", "Cliente modificado",JOptionPane.INFORMATION_MESSAGE);
					VentanaLogin inicio = new VentanaLogin(controller);
					inicio.setVisible(true);
					VentanaModificarClientesAdmin.this.dispose();
				}
				}
			});
		
		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaGestionCliente(controller);
				VentanaModificarClientesAdmin.this.dispose();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(440, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("PSC Polideportivo - Admin");
	}
}