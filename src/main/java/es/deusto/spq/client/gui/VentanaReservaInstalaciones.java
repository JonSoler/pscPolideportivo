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
	

	public VentanaReservaInstalaciones(final es.deusto.spq.client.Controller controller) {
		
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(10, 10, 5, 5));
		this.setContentPane(contentpane);
		contentpane.setLayout(null);
		
		listaInstalaciones.setBounds(81, 95, 447, 386);
		contentpane.add(listaInstalaciones);

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
				VentanaReservaInstalaciones.this.dispose();				
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
					VentanaReservaInstalaciones window = new VentanaReservaInstalaciones(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}