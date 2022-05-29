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

public class VentanaAdmin extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentpane;
	private JButton botonClientes = new JButton();
	private JButton botonReservas = new JButton();
	private JButton botonSalir = new JButton();
	
	public VentanaAdmin(final Controller controller){
		contentpane = new JPanel();

		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);

		JLabel lTitulo = new JLabel("PSC Polideportivo - Admin");
		lTitulo.setFont(new Font("Forte", Font.BOLD, 40));
		lTitulo.setBounds(275, 42, 499, 50);
		contentpane.add(lTitulo);
		        
		botonClientes.setForeground(SystemColor.text);
		botonClientes.setBackground(new Color(0, 51, 255));
		botonClientes.setBounds(423, 204, 200, 50);
		botonClientes.setText("Clientes");
		botonClientes.setFont(new Font("Goudy Old Style", Font.BOLD, 23));
		contentpane.add(botonClientes);
		
		botonReservas.setForeground(SystemColor.text);
		botonReservas.setBackground(new Color(0, 51, 255));
		botonReservas.setBounds(423, 307, 200, 50);
		botonReservas.setText("Reservas");
		botonReservas.setFont(new Font("Goudy Old Style", Font.BOLD, 23));
		contentpane.add(botonReservas);
				
		botonSalir.setForeground(SystemColor.black);
		botonSalir.setBackground(SystemColor.inactiveCaptionBorder);
		botonSalir.setBounds(22, 492, 90, 42);
		botonSalir.setText("Salir");
		botonSalir.setFont(new Font("Goudy Old Style", Font.BOLD, 20));
		contentpane.add(botonSalir);
			
		botonReservas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaReservasAdmin(controller);
				VentanaAdmin.this.dispose();			
			}
		});
		
		botonClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new VentanaGestionCliente(controller);
				VentanaAdmin.this.dispose();			
			}
		});
						
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaLogin inicio = new VentanaLogin(controller);
				inicio.setVisible(true);
				VentanaAdmin.this.dispose();
				
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1060, 600);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setTitle("PSC Polideportivo Admin\r\n");

	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin window = new VentanaAdmin(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

