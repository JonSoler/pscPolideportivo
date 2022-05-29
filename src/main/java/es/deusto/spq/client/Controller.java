package es.deusto.spq.client;

import java.util.List;

import javax.ws.rs.core.Response;

public class Controller {
	
public ServiceLocator serviceLocator;
	
	public Controller(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public int loginPolideportivo(String email, String contrasenya){
		return serviceLocator.loginPolideportivo(email, contrasenya);
	}
	
	public boolean agregarClientePolideportivo(String DNI, String nombre, String apellido, int edad, String email, String contrasenya, boolean Admin){
		return serviceLocator.agregarClientePolideportivo(DNI, nombre, apellido, edad, email, contrasenya, Admin);
	}
	
	public boolean agregarReservaInstalacion(String IDReserva, String IDInstalacion, String emailUsuario, int anyo, int mes, int dia, int hora) {
		return serviceLocator.agregarReservaInstalacion(IDReserva, IDInstalacion, emailUsuario, anyo, mes, dia , hora);
	}
	//obtener todas las instalaciones
	public List<Instalacion> obtenerInstalaciones() {
		return serviceLocator.obtenerInstalaciones();
	}
	//obtener todas las reservas
	public List<ReservaInstalaciones> obtenerReservas() {
		return serviceLocator.obtenerReservas();
	}
	//borrar reserva
	public Response borrarReserva(ReservaInstalaciones reserva) {
		return serviceLocator.borrarReserva(reserva);
	//obtener una reserva en concreto
	}
	public ReservaInstalaciones buscarReservaInstalacion(String IDReserva) {
		return serviceLocator.buscarReservaInstalacion(IDReserva);
	}

}
