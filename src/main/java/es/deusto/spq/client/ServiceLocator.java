package es.deusto.spq.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

public class ServiceLocator {
	
	private Client cliente;
	private WebTarget webTarget;
	private static Logger logger = Logger.getLogger(ServiceLocator.class.getName());

	public ServiceLocator() {
		cliente = ClientBuilder.newClient();
		webTarget = cliente.target(cogerUrl());
	}
	
	public static String cogerUrl() {
		GetProperties properties = new GetProperties();
		String url = "";

		try {
			url = properties.getURL();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return url;

	}
	/**M�todo para agregar un cliente al polideportivo
	 * LLama al metodo al RemoteFacade del servidor con la URL establecida
	 * @param DNI  del cliente que se registra 
	 * @param nombre del cliente que se registra
	 * @param apellido del cliente que se registra
	 * @return Devuelve true si todo ha salido correctamente
	 */
	public boolean agregarClientePolideportivo(String DNI, String nombre, String apellido, int edad, String email, String contrasenya, boolean Admin) {
		WebTarget registerUserWebTarget = webTarget.path("server/registroPolideportivo");
		Cliente c = new Cliente();
		c.setDNI(DNI);
		c.setNombre(nombre);
		c.setApellido(apellido);
		c.setEdad(edad);
		c.setEmail(email);
		c.setContrasenya(contrasenya);
		c.setAdmin(false);
		
		Entity<Cliente> entity = Entity.entity(c, MediaType.APPLICATION_JSON);
		Response response = registerUserWebTarget.request().post(entity);
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error conectando con el servidor. Codigo: " + response.getStatus());
			return false;
		} else {
			logger.info("Usuario registrado correctamente");
			return true;
		}
	}
	/**M�todo logearse en el polideportivo
	 * LLama al metodo al RemoteFacade del servidor con la URL establecida
	 * @param email  de la cuenta del cliente 
	 * @param contrasenya de la cuenta del cliente
	 * @return Devuelve true si todo ha salido correctamente
	 */
	public int loginPolideportivo(String email, String contrasenya) {
		WebTarget webTarget1 = webTarget.path("server/loginPolideportivo");
		Invocation.Builder invocationBuilder = webTarget1.request(MediaType.APPLICATION_JSON);

		Cliente c = new Cliente();
		c.setEmail(email);
		c.setContrasenya(contrasenya);

		Response response = invocationBuilder.post(Entity.entity(c, MediaType.APPLICATION_JSON));
		if (response.getStatus() == Status.OK.getStatusCode()) {
			return 2;

		} else if (response.getStatus() == Status.ACCEPTED.getStatusCode()) {
			return 1;
		}
		return 0;
	}
	
	/**M�todo para que el cliente realice una reserva
	 * LLama al metodo al RemoteFacade del servidor con la URL establecida
	 * @param IDReserva  identificativo de la reserva del cliente 
	 * @param IDInstalacion identificativo de la instalacion que quiere reservar el cliente
	 * @param emailUsuario del cliente que reserva
	 * @param anyo de la reserva
	 * @param mes de la reserva
	 * @param dia de la reserva
	 * @param hora de la reserva
	 * @return Devuelve true si todo ha salido correctamente
	 */
	
	public boolean agregarReservaInstalacion(String IDReserva, String IDInstalacion, String emailUsuario, int anyo, int mes, int dia, int hora) {
		WebTarget registerUserWebTarget = webTarget.path("server/agregarReservaInstalacion");
		ReservaInstalaciones r = new ReservaInstalaciones();
		r.setIDReserva(IDReserva);
		r.setIDInstalacion(IDInstalacion);
		r.setEmailUsuario(emailUsuario);
		r.setAnyo(anyo);
		r.setMes(mes);
		r.setDia(dia);
		r.setHora(hora);
		
		Entity<ReservaInstalaciones> entity = Entity.entity(r, MediaType.APPLICATION_JSON);
		Response response = registerUserWebTarget.request().post(entity);
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error conectando con el servidor. Codigo: " + response.getStatus());
			return false;
		} else {
			logger.info("Reserva realizada correctamente");
			return true;
		}
	}
	
	/**M�todo buscar una reserva en concreto
	 * LLama al metodo al RemoteFacade del servidor con la URL establecida
	 * @param IDReserva  identificativo de la reserva del cliente 
	 * @return Devuelve la reserva en concreto
	 */
	public ReservaInstalaciones buscarReservaInstalacion(String IDReserva) {
        WebTarget webTarget4 = webTarget.path("server/getReservaInstalaciones").queryParam("IDReserva", IDReserva);
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		ReservaInstalaciones r = new ReservaInstalaciones();
		r.setIDReserva(IDReserva);

		GenericType<ReservaInstalaciones> genericType = new GenericType<ReservaInstalaciones>() {};
		r = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);

		return r;
    }
	
	/**M�todo obtener todas las instalaciones de la bd
	 * LLama al metodo al RemoteFacade del servidor con la URL establecida
	 * @return instalaciones de la bd
	 */
	
	public List<Instalacion> obtenerInstalaciones() {
        WebTarget webTarget4 = webTarget.path("server/getInstalaciones");
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		List<Instalacion> instalaciones = new ArrayList<Instalacion>();

		GenericType<List<Instalacion>> genericType = new GenericType<List<Instalacion>>() {};
		instalaciones = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);

		return instalaciones;
    }
	/**M�todo para borrar una reserva
	 * LLama al metodo al RemoteFacade del servidor con la URL establecida
	 * @param reserva  que se quiere borrar 
	 * @return response con borrado de la reserva
	 */
	public Response borrarReserva(ReservaInstalaciones reserva) {
		WebTarget webTarget1 = webTarget.path("server/borrarReservaInstalacion");	
		Entity<ReservaInstalaciones> entity = Entity.entity(reserva, MediaType.APPLICATION_JSON);
		Response response = webTarget1.request().post(entity);
		return response;
	}
	/**M�todo para obtener todas las reservas de la bd
	 * LLama al metodo al RemoteFacade del servidor con la URL establecida
	 * @return Devuelve todas las reservas de la bd
	 */
	public List<ReservaInstalaciones> obtenerReservas() {
        WebTarget webTarget4 = webTarget.path("server/getReservasInstalaciones");
		Invocation.Builder invocationBuilder = webTarget4.request(MediaType.APPLICATION_JSON);

		List<ReservaInstalaciones> reservas = new ArrayList<ReservaInstalaciones>();

		GenericType<List<ReservaInstalaciones>> genericType = new GenericType<List<ReservaInstalaciones>>() {};
		reservas = webTarget4.request(MediaType.APPLICATION_JSON).get(genericType);

		return reservas;
    }
	





}