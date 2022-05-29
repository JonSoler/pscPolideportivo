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
import javax.ws.rs.core.Response;

import es.deusto.spq.client.Instalacion;
import es.deusto.spq.client.ReservaInstalaciones;
import es.deusto.spq.client.ServiceLocator;

public class VentanaEliminarReserva extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	
	private JList listaReservas = new JList();
	private JButton botonEliminarReserva = new JButton();
	private JButton botonAtras = new JButton();
	private DefaultListModel contenidoReservas = new DefaultListModel();
	String emailUsuario = "";
	

	public VentanaEliminarReserva(final es.deusto.spq.client.Controller controller) {
		
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel lTitulo = new JLabel("Eliminar reservas");
		lTitulo.setFont(new Font("Forte", Font.BOLD, 40));
		lTitulo.setBounds(369, 37, 358, 42);
		contentpane.add(lTitulo);
				
		botonEliminarReserva.setForeground(SystemColor.text);
		botonEliminarReserva.setBackground(Color.RED);
		botonEliminarReserva.setBounds(834, 464, 190, 51);
		botonEliminarReserva.setText("Eliminar reservas");
		botonEliminarReserva.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		contentpane.add(botonEliminarReserva);
		
		botonAtras.setForeground(Color.BLACK);
		botonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		botonAtras.setBounds(22, 492, 90, 42);
		botonAtras.setText("Atrás");
		botonAtras.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		contentpane.add(botonAtras);
		
		Properties objetoP = new Properties();
		try {
			objetoP.load(new FileInputStream("prop.properties"));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		if (objetoP.getProperty("email") != null) {
			emailUsuario = objetoP.getProperty("email");
		}
		
		contenidoReservas = new DefaultListModel();
		ServiceLocator serviceLocator = new ServiceLocator();
		ArrayList<ReservaInstalaciones> reservas = (ArrayList<ReservaInstalaciones>) controller.obtenerReservas();
		
		for (ReservaInstalaciones reservaInstalaciones : reservas) {
			
			
			if (reservaInstalaciones.getEmailUsuario().equals(emailUsuario)) {
				contenidoReservas.addElement(reservaInstalaciones);
			}
			
		}
		
		listaReservas.setModel(contenidoReservas);
		listaReservas.setBounds(153, 100, 763, 346);
		contentpane.add(listaReservas);
		
		
		botonEliminarReserva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String IDReserva = "";
				
				for (int i = 32; i < 35; i++) {
				IDReserva = IDReserva + listaReservas.getSelectedValue().toString().charAt(i);
				String IDReserva2 = "R01";
				}
				
				for (ReservaInstalaciones reservaInstalaciones : reservas) {
					
					
					if (reservaInstalaciones.getIDReserva().equals(IDReserva)) {
						Response ban = controller.borrarReserva(reservaInstalaciones);
						JOptionPane.showMessageDialog(null, "Reserva eliminada correctamente.");
						VentanaCliente cliente = new VentanaCliente(controller);
						cliente.setVisible(true);
						VentanaEliminarReserva.this.dispose();			
					} 
					
					
					
				}
			}
		});
				
		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCliente cliente = new VentanaCliente(controller);
				cliente.setVisible(true);
				VentanaEliminarReserva.this.dispose();				
			}
		});

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1060, 600);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setTitle("Reservas");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminarReserva window = new VentanaEliminarReserva(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}