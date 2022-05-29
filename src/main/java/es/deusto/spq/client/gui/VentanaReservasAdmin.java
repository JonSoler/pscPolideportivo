package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Instalacion;
import es.deusto.spq.client.ReservaInstalaciones;
import es.deusto.spq.client.ServiceLocator;

public class VentanaReservasAdmin extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	
	private JList listaReservas = new JList();
	private JButton botonAtras = new JButton();
	private DefaultListModel contenidoReservas = new DefaultListModel();
	

	public VentanaReservasAdmin(final es.deusto.spq.client.Controller controller) {
		
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel lTitulo = new JLabel("Reservas realizadas");
		lTitulo.setFont(new Font("Forte", Font.BOLD, 40));
		lTitulo.setBounds(346, 39, 404, 42);
		contentpane.add(lTitulo);
		
		botonAtras.setForeground(Color.BLACK);
		botonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		botonAtras.setBounds(22, 492, 90, 42);
		botonAtras.setText("Atrás");
		botonAtras.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		contentpane.add(botonAtras);
		
		contenidoReservas = new DefaultListModel();
		ServiceLocator serviceLocator = new ServiceLocator();
		ArrayList<ReservaInstalaciones> reservas = (ArrayList<ReservaInstalaciones>) controller.obtenerReservas();
		
		for (ReservaInstalaciones reserva : reservas) {
			contenidoReservas.addElement(reserva);

		}
		listaReservas.setModel(contenidoReservas);
		listaReservas.setBounds(153, 101, 753, 386);
		contentpane.add(listaReservas);
				
		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin cliente = new VentanaAdmin(controller);
				cliente.setVisible(true);
				VentanaReservasAdmin.this.dispose();				
			}
		});

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1060, 600);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setTitle("PSC Polideportivo Admin - Reservas");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReservasAdmin window = new VentanaReservasAdmin(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}