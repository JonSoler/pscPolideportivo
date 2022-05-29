package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.client.Controller;

public class VentanaCliente extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton botonReservarInstalaciones = new JButton();
	private JButton botonEliminarReservas = new JButton();
	private JButton botonSalir = new JButton();
	
	public VentanaCliente(final es.deusto.spq.client.Controller controller){
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lTitulo = new JLabel("PSC Polideportivo");
		lTitulo.setFont(new Font("Forte", Font.BOLD, 40));
		lTitulo.setBounds(365, 62, 341, 50);
		contentpane.add(lTitulo);
		        
		botonReservarInstalaciones.setForeground(SystemColor.text);
		botonReservarInstalaciones.setBackground(new Color(0, 51, 255));
		botonReservarInstalaciones.setBounds(410, 204, 238, 50);
		botonReservarInstalaciones.setText("Reservar instalaciones");
		botonReservarInstalaciones.setFont(new Font("Goudy Old Style", Font.BOLD, 23));
		contentpane.add(botonReservarInstalaciones);
		
		botonEliminarReservas.setForeground(SystemColor.text);
		botonEliminarReservas.setBackground(new Color(0, 51, 255));
		botonEliminarReservas.setBounds(410, 307, 238, 50);
		botonEliminarReservas.setText("Eliminar reservas");
		botonEliminarReservas.setFont(new Font("Goudy Old Style", Font.BOLD, 23));
		contentpane.add(botonEliminarReservas);
				
		botonSalir.setForeground(SystemColor.black);
		botonSalir.setBackground(SystemColor.inactiveCaptionBorder);
		botonSalir.setBounds(22, 492, 90, 42);
		botonSalir.setText("Salir");
		botonSalir.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		contentpane.add(botonSalir);
			
		botonEliminarReservas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaEliminarReserva(controller);
				VentanaCliente.this.dispose();	
			}
		});
		
		botonReservarInstalaciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaReservaInstalaciones(controller);
				VentanaCliente.this.dispose();			
			}
		});
						
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaLogin inicio = new VentanaLogin(controller);
				inicio.setVisible(true);
				VentanaCliente.this.dispose();
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1060, 600);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setTitle("PSC Polideportivo\r\n");

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente window = new VentanaCliente(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}