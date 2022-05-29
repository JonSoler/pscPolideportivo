package es.deusto.spq.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Instalacion;
import es.deusto.spq.client.ReservaInstalaciones;

@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class RemoteFacade implements IRemoteFacade{
	
	private DBManager dbmanager = null;
	private Logger logger = Logger.getLogger(RemoteFacade.class.getName());

	public RemoteFacade() {
		this.dbmanager = DBManager.getInstance();
	}

	private static final long serialVersionUID = 1L;
	private static RemoteFacade instance;
	
	@POST
	@Path("/loginPolideportivo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginPolideportivo(Cliente cliente) {
		Cliente user = dbmanager.getUsuario(cliente.getEmail());
		if(user!= null && user.getContrasenya().equals(cliente.getContrasenya())) {
			if(user.isAdmin()) {
				return Response.status(Response.Status.OK).build();
			}else {
				return Response.status(Response.Status.ACCEPTED).build();
			}	
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}
	 
	@POST
	@Path("/registroPolideportivo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarClientePolideportivo(Cliente cliente) {
		Cliente c = dbmanager.getUsuario(cliente.getEmail());
		if(c== null) {
			dbmanager.store(cliente);
			return Response.status(Response.Status.OK).build();
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	@POST
	@Path("/agregarReservaInstalacion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarReservaInstalacion(ReservaInstalaciones r) {
		dbmanager.store(r);
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
    @Path("/getReservaInstalaciones")
    @Consumes(MediaType.APPLICATION_JSON)
    public ReservaInstalaciones buscarReservaInstalacion(@QueryParam("IDReserva") String IDReserva) {
        ReservaInstalaciones r = dbmanager.getReservaInstalaciones(IDReserva);

        return r;
    }
	
	@GET
	@Path("/getInstalaciones")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Instalacion> obtenerInstalaciones() {
		List<Instalacion> h = dbmanager.getInstalaciones();
	
		return h;
	}
	
	@POST
	@Path("/borrarReservaInstalacion")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response borrarReserva(ReservaInstalaciones reserva) {
		ReservaInstalaciones r = dbmanager.getReservaInstalaciones(reserva.getIDReserva());
		if(r!= null) {
			dbmanager.borrarReservaInstalacion(reserva);
			return Response.status(Response.Status.OK).build();
		}return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	@GET
	@Path("/getReservasInstalaciones")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ReservaInstalaciones> obtenerReservas() {
		List<ReservaInstalaciones> r = dbmanager.getReservasInstalaciones();
		
		return r;
	}
	
	
}