package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import es.deusto.spq.client.Instalacion;
import es.deusto.spq.client.ReservaInstalaciones;
import es.deusto.spq.client.ServiceLocator;

public class VentanaReservaInstalaciones extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	private JList listaInstalaciones = new JList();
	private JComboBox comboBoxAnyo = new JComboBox();
	private JComboBox comboBoxMes = new JComboBox();
	private JComboBox comboBoxDia = new JComboBox();
	private JComboBox comboBoxHora = new JComboBox();
	private JButton botonReservar = new JButton();
	private JButton botonAtras = new JButton();
	private DefaultListModel contenidoInstalaciones = new DefaultListModel();
	

	public VentanaReservaInstalaciones(final es.deusto.spq.client.Controller controller) {
		
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		

		JLabel lTitulo = new JLabel("Realizar una reserva");
		lTitulo.setFont(new Font("Forte", Font.BOLD, 40));
		lTitulo.setBounds(345, 35, 401, 42);
		contentpane.add(lTitulo);
		
		JLabel lFiltrarPorFecha = new JLabel();
		lFiltrarPorFecha.setText("Introducir datos");
		lFiltrarPorFecha.setFont(new Font("Goudy Old Style", Font.BOLD, 23));
		lFiltrarPorFecha.setBounds(556, 95, 300, 48);
		contentpane.add(lFiltrarPorFecha);
		
		JLabel lAnyo = new JLabel();
		lAnyo.setText("Año");
		lAnyo.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		lAnyo.setBounds(556, 137, 61, 48);
		contentpane.add(lAnyo);
		
		JLabel lMes = new JLabel();
		lMes.setText("Mes");
		lMes.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		lMes.setBounds(556, 211, 61, 48);
		contentpane.add(lMes);
		
		JLabel lDia = new JLabel();
		lDia.setText("Día");
		lDia.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		lDia.setBounds(556, 287, 61, 48);
		contentpane.add(lDia);
		
		JLabel lHora = new JLabel();
		lHora.setText("Hora");
		lHora.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		lHora.setBounds(556, 360, 61, 48);
		contentpane.add(lHora);
		
		
		comboBoxAnyo.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		comboBoxAnyo.setBounds(556, 183, 190, 30);
		comboBoxAnyo.addItem("Seleccione el año");
		for (int i = 2022; i <= 2024; i++) {
			comboBoxAnyo.addItem(Integer.toString(i));
		}
		contentpane.add(comboBoxAnyo);
		
		comboBoxMes.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		comboBoxMes.setBounds(556, 257, 190, 30);
		comboBoxMes.addItem("Seleccione el mes");
		for (int i = 1; i <= 12; i++) {
			comboBoxMes.addItem(Integer.toString(i));
		}
		contentpane.add(comboBoxMes);
		
		comboBoxDia.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		comboBoxDia.setBounds(556, 331, 190, 30);
		comboBoxDia.addItem("Seleccione el día");
		for (int i = 1; i <= 31; i++) {
			comboBoxDia.addItem(Integer.toString(i));
		}
		contentpane.add(comboBoxDia);
		
		comboBoxHora.setFont(new Font("Goudy Old Style", Font.PLAIN, 19));
		comboBoxHora.setBounds(556, 404, 190, 30);
		comboBoxHora.addItem("Seleccione la hora");
		for (int i = 8; i <= 23; i++) {
			comboBoxHora.addItem(Integer.toString(i));
		}
		contentpane.add(comboBoxHora);
		
		botonReservar.setForeground(SystemColor.text);
		botonReservar.setBackground(new Color(0, 51, 255));
		botonReservar.setBounds(804, 257, 190, 61);
		botonReservar.setText("Reservar");
		botonReservar.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
		contentpane.add(botonReservar);
		
		botonAtras.setForeground(Color.BLACK);
		botonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		botonAtras.setBounds(22, 492, 90, 42);
		botonAtras.setText("Atrás");
		botonAtras.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		contentpane.add(botonAtras);
		
		contenidoInstalaciones = new DefaultListModel();
		ServiceLocator serviceLocator = new ServiceLocator();
		ArrayList<Instalacion> instalaciones = (ArrayList<Instalacion>) controller.obtenerInstalaciones();
		
		for (Instalacion instalacion : instalaciones) {
			contenidoInstalaciones.addElement(instalacion);

		}
		listaInstalaciones.setModel(contenidoInstalaciones);
		listaInstalaciones.setBounds(81, 95, 447, 386);
		contentpane.add(listaInstalaciones);
		
		
		botonReservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<ReservaInstalaciones> reservas = (ArrayList<ReservaInstalaciones>) controller.obtenerReservas();

				String IDReserva = "";
    			String IDInstalacion = "";				
				String emailUsuario = "";
				int dia = 0;
				int mes = 0;
				int anyo = 0;
				int hora = 0;
			
				int nReserva = reservas.size() + 1;
				if (nReserva < 10) {
					IDReserva = "R0" + Integer.toString(nReserva);
				} else {
					IDReserva = "R" + Integer.toString(nReserva);
				}

				
				for (int i = 11; i < 14; i++) {
					IDInstalacion = IDInstalacion + listaInstalaciones.getSelectedValue().toString().charAt(i);
				}
				
				Properties objetoP = new Properties();
				try {
					objetoP.load(new FileInputStream("prop.properties"));
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (objetoP.getProperty("email") != null) {
					emailUsuario = objetoP.getProperty("email");
				}
				if (comboBoxDia.getSelectedItem().toString() != "Seleccione el dia") {
					dia = Integer.parseInt(comboBoxDia.getSelectedItem().toString());
				}
				if (comboBoxMes.getSelectedItem().toString() != "Seleccione el mes") {
					mes = Integer.parseInt(comboBoxMes.getSelectedItem().toString());
				}
				if (comboBoxAnyo.getSelectedItem().toString() != "Seleccione el a�o") {
					anyo = Integer.parseInt(comboBoxAnyo.getSelectedItem().toString());
				}
				
				if (comboBoxHora.getSelectedItem().toString() != "Seleccione la hora") {
					hora = Integer.parseInt(comboBoxHora.getSelectedItem().toString());
				}
				
				boolean condicion = false;
				if (listaInstalaciones.isSelectionEmpty() != true && dia != 0 && mes != 0 && anyo != 0) {
					condicion = existeReserva(reservas, IDInstalacion, dia, mes, anyo, hora);
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido registrar la reserva.");
				}
				if (condicion == true) {
					condicion = controller.agregarReservaInstalacion(IDReserva, IDInstalacion, emailUsuario, dia, mes, anyo, hora);
					JOptionPane.showMessageDialog(null, "Reserva registrada correctamente.");
				}
				
				
			}
		});
				
		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCliente cliente = new VentanaCliente(controller);
				cliente.setVisible(true);
				VentanaReservaInstalaciones.this.dispose();				
			}
		});

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1060, 600);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setTitle("Reservas");
	}
	
	public static boolean existeReserva(ArrayList<ReservaInstalaciones> reservas, String IDInstalacion, int dia, int mes, int anyo, int hora) {
		for (ReservaInstalaciones reserva : reservas) {
			if (IDInstalacion.equals(reserva.getIDInstalacion()) && dia == reserva.getDia() && mes == reserva.getMes() && anyo == reserva.getAnyo()&& hora == reserva.getHora()) {
				JOptionPane.showMessageDialog(null, "Instalacion ocupada.");
				return false;				
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReservaInstalaciones window = new VentanaReservaInstalaciones(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}