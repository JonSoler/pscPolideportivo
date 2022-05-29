package es.deusto.spq.server;

import java.util.List;

import javax.ws.rs.core.Response;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Instalacion;
import es.deusto.spq.client.ReservaInstalaciones;

public interface IRemoteFacade {
	
	public Response loginPolideportivo(Cliente cliente);
	public Response agregarClientePolideportivo(Cliente cliente);
	public Response agregarReservaInstalacion(ReservaInstalaciones r);
	public ReservaInstalaciones buscarReservaInstalacion(String IDInstalacion);
	public List<Instalacion> obtenerInstalaciones();
	public Response borrarReserva(ReservaInstalaciones reserva);
	public List<ReservaInstalaciones> obtenerReservas();
	

}
