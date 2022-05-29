package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaEliminarReserva extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	
	private JList listaInstalaciones = new JList();
	private JButton botonReservar = new JButton();
	private JButton botonAtras = new JButton();
	

	public VentanaEliminarReserva(final es.deusto.spq.client.Controller controller) {
		
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		listaInstalaciones.setBounds(303, 103, 447, 386);
		contentpane.add(listaInstalaciones);

		JLabel lTitulo = new JLabel("Eliminar reservas");
		lTitulo.setFont(new Font("Forte", Font.BOLD, 40));
		lTitulo.setBounds(369, 37, 358, 42);
		contentpane.add(lTitulo);
				
		botonReservar.setForeground(SystemColor.text);
		botonReservar.setBackground(Color.RED);
		botonReservar.setBounds(816, 438, 190, 51);
		botonReservar.setText("Eliminar reservas");
		botonReservar.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		contentpane.add(botonReservar);
		
		botonAtras.setForeground(Color.BLACK);
		botonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		botonAtras.setBounds(22, 492, 90, 42);
		botonAtras.setText("Atrás");
		botonAtras.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		contentpane.add(botonAtras);

		
		botonReservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
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