package es.deusto.spq.client;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import es.deusto.spq.server.DBManager;
import es.deusto.spq.server.IRemoteFacade;
import es.deusto.spq.server.RemoteFacade;

public class TestRemoteFacade {
	
	@InjectMocks
	RemoteFacade rf = new RemoteFacade();
	
	@Mock
	IRemoteFacade irf;
	
	@Mock
	Cliente c;
	
	@Mock
	ReservaInstalaciones r;
	
	@Test
	public void testObtenerInstalaciones() {
		when(rf.obtenerInstalaciones()).thenReturn(irf.obtenerInstalaciones());
	}
	
	@Test
	public void testObtenerReservas() {
		when(rf.obtenerReservas()).thenReturn(irf.obtenerReservas());
	}
	
	@Test
	public void testLoginPolideportivo() {
		when(rf.loginPolideportivo(c)).thenReturn(irf.loginPolideportivo(c));
	}
	
	@Test
	public void testAgregarClientePolideportivo() {
		when(rf.agregarClientePolideportivo(c)).thenReturn(irf.agregarClientePolideportivo(c));
	}
	
	@Test
	public void testAgregarReservaInstalacion() {
		when(rf.agregarReservaInstalacion(r)).thenReturn(irf.agregarReservaInstalacion(r));
	}
	
	@Test
	public void testBuscarReservaInstalacion() {
		when(rf.buscarReservaInstalacion(r.getIDInstalacion())).thenReturn(irf.buscarReservaInstalacion(r.getIDInstalacion()));
	}
	
	@Test
	public void testBorrarReserva() {
		when(rf.borrarReserva(r)).thenReturn(irf.borrarReserva(r));
	}
	
	
	
	
	
	

}
