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

public class VentanaGestionCliente extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentpane;
	
	private JList listaInstalaciones = new JList();
	private JButton botonEliminarCliente = new JButton();
	private JButton botonAtras = new JButton();
	

	public VentanaGestionCliente(final es.deusto.spq.client.Controller controller) {
		
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		listaInstalaciones.setBounds(303, 103, 447, 386);
		contentpane.add(listaInstalaciones);

		JLabel lTitulo = new JLabel("Gestion de clientes");
		lTitulo.setFont(new Font("Forte", Font.BOLD, 40));
		lTitulo.setBounds(369, 37, 358, 42);
		contentpane.add(lTitulo);
				
		botonEliminarCliente.setForeground(SystemColor.text);
		botonEliminarCliente.setBackground(Color.RED);
		botonEliminarCliente.setBounds(857, 458, 149, 31);
		botonEliminarCliente.setText("Eliminar cliente");
		botonEliminarCliente.setFont(new Font("Goudy Old Style", Font.BOLD, 18));
		contentpane.add(botonEliminarCliente);
		
		botonAtras.setForeground(Color.BLACK);
		botonAtras.setBackground(SystemColor.inactiveCaptionBorder);
		botonAtras.setBounds(22, 492, 90, 42);
		botonAtras.setText("Atrás");
		botonAtras.setFont(new Font("Goudy Old Style", Font.BOLD, 19));
		contentpane.add(botonAtras);
		
		JButton btnModificarCliente = new JButton();
		btnModificarCliente.setText("Modificar cliente");
		btnModificarCliente.setForeground(Color.WHITE);
		btnModificarCliente.setFont(new Font("Goudy Old Style", Font.BOLD, 22));
		btnModificarCliente.setBackground(Color.BLUE);
		btnModificarCliente.setBounds(816, 373, 190, 51);
		contentpane.add(btnModificarCliente);

		
		botonEliminarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnModificarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaModificarClientesAdmin cliente = new VentanaModificarClientesAdmin(controller);
				cliente.setVisible(true);
				VentanaGestionCliente.this.dispose();
			}
		});
				
		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin cliente = new VentanaAdmin(controller);
				cliente.setVisible(true);
				VentanaGestionCliente.this.dispose();				
			}
		});

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1060, 600);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setTitle("PSC Polideportivo Admin - Gestion de clientes");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGestionCliente window = new VentanaGestionCliente(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}