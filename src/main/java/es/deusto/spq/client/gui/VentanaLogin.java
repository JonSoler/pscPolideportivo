package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String emailDelAnteriorUsuario;
	private static String emailDelUsuario;
	static Properties p;

	private JPanel contentpane;
	private JLabel labelUsuario = new JLabel();
	private JLabel labelContrasenya = new JLabel();
	private JTextField textoUsuario = new JTextField();
	private JPasswordField textoContrasenya = new JPasswordField();
	private JButton botonIniciarSesion = new JButton();
	private JButton botonRegistrarse = new JButton();

	public VentanaLogin(final es.deusto.spq.client.Controller controller) {

		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel labelTitle = new JLabel("PSC Polideportivo");
		labelTitle.setFont(new Font("Forte", Font.BOLD, 40));
		labelTitle.setBounds(49, 33, 334, 50);
		contentpane.add(labelTitle);

		labelUsuario.setText("Email:");
		labelUsuario.setOpaque(true);
		labelUsuario.setBounds(85, 125, 55, 20);
		labelUsuario.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(labelUsuario, BorderLayout.SOUTH);

		textoUsuario.setBounds(179, 125, 169, 20);
		contentpane.add(textoUsuario);

		labelContrasenya.setText("Contraseña:");
		labelContrasenya.setBounds(65, 175, 89, 20);
		labelContrasenya.setOpaque(true);
		labelContrasenya.setFont(new Font("Goudy Old Style", Font.BOLD, 16));
		contentpane.add(labelContrasenya);

		textoContrasenya.setBounds(179, 175, 169, 20);
		contentpane.add(textoContrasenya);

		botonIniciarSesion.setForeground(SystemColor.text);
		botonIniciarSesion.setBackground(new Color(0, 51, 255));
		botonIniciarSesion.setBounds(262, 243, 121, 32);
		botonIniciarSesion.setText("Iniciar sesión");
		botonIniciarSesion.setFont(new Font("Goudy Old Style", Font.BOLD | Font.ITALIC, 16));
		contentpane.add(botonIniciarSesion);

		botonRegistrarse.setBackground(SystemColor.inactiveCaptionBorder);
		botonRegistrarse.setBounds(49, 243, 121, 32);
		botonRegistrarse.setText("Registrarse");
		botonRegistrarse.setFont(new Font("Goudy Old Style", Font.BOLD | Font.ITALIC, 16));
		contentpane.add(botonRegistrarse);

		botonIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int valido = controller.loginPolideportivo(textoUsuario.getText(), new String(textoContrasenya.getPassword()));
				if (valido == 1) {
					VentanaReservaInstalaciones menu;
					try {
						String usuario = textoUsuario.getText();
						emailDelUsuario = usuario;
						//usuarioLogin();
						menu = new VentanaReservaInstalaciones(controller);
						menu.setVisible(true);
						VentanaLogin.this.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				if (valido == 2) {
					// Para iniciar sesión en la cuenta admin
					VentanaAdmin admin;
					try {
						String usuario = textoUsuario.getText();
						emailDelUsuario = usuario;
						//usuarioLogin();
						admin = new VentanaAdmin(controller);
						admin.setVisible(true);
						VentanaLogin.this.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (valido == 0) {
					JOptionPane.showMessageDialog(null, "Usuario incorrecto");
				}
			}
		});

		botonRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaRegistro(controller);
				dispose();

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(440, 355);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("PSC Polideportivo");

	}

	/*public static String emailUsuario() {
		p = new Properties();
		try {
			File f = new File("prop.properties");
			if (!f.exists())
				f.createNewFile();
			InputStream is = new FileInputStream("prop.properties");
			p.load(is);
			emailDelAnteriorUsuario = p.getProperty("email");
			if (emailDelAnteriorUsuario == null)
				emailDelAnteriorUsuario = "";

		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailDelAnteriorUsuario;
	}
	*/
	/*private void usuarioLogin() {
		p.put("email", emailDelUsuario);
		try {
			p.store(new FileWriter("prop.properties"), "" + new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}
		emailDelAnteriorUsuario = emailDelUsuario;
	}
	*/
	public VentanaLogin(boolean b) {
		this(null);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
