package es.deusto.spq.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.ReservaInstalaciones;
import es.deusto.spq.server.DBManager;
import es.deusto.spq.server.IRemoteFacade;
import es.deusto.spq.server.RemoteFacade;

public class TestRemoteFacade {
	
	RemoteFacade rf = new RemoteFacade();
	
	Cliente c = new Cliente("43527594", "Manolito", "Manolito", 18, "manolito@gmail.com", "manolito123", false);
	
	ReservaInstalaciones r = new ReservaInstalaciones("R01", "001", "manolito@gmail.com", 2023, 5, 6, 11);
	
	@Rule 
	public ContiPerfRule i = new ContiPerfRule();
	
	@Mock
	DBManager db;
	
	@Test
	@PerfTest(invocations = 10, threads =2)
	@Required(max = 1200, average = 250)
	public void testObtenerInstalaciones() {
		assertNotNull(rf.obtenerInstalaciones());
	}
	
	@Test
	@PerfTest(invocations = 10, threads =2)
	@Required(max = 1200, average = 250)
	public void testObtenerReservas() {
		assertNotNull(rf.obtenerReservas());
	}
	
	@Test
	public void testLoginPolideportivo() {
		assertNotNull(rf.loginPolideportivo(c));
	}
	
	@Test
	@PerfTest(invocations = 10, threads =2)
	@Required(max = 1200, average = 250)
	public void testAgregarClientePolideportivo() {
		assertNotNull(rf.agregarClientePolideportivo(c));
	}
	
	@Test
	@PerfTest(invocations = 10, threads =2)
	@Required(max = 2000, average = 1000)
	public void testAgregarReservaInstalacion() {
		assertNotNull(rf.agregarReservaInstalacion(r));
	}
	
	@Test
	@PerfTest(invocations = 10, threads =2)
	@Required(max = 1200, average = 250)
	public void testBorrarReserva() {
		assertNotNull(rf.borrarReserva(r));
	}
	
	
	
	
	
	

}
