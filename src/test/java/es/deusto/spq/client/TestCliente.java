package es.deusto.spq.client;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.client.Cliente;

public class TestCliente {
	Cliente a = new Cliente("1111A", "Pedro", "Garcia", 20, "PedroGarcia@gmail.com", "123Garcia",false);
	Cliente b= new Cliente();
	@Test
	public void testGetDNI() {
		assertEquals("1111A", a.getDNI());
	}
	public void testSetDNI() {
		b.setDNI("1111B");
		assertEquals("1111B", b.getDNI());
	}
	@Test
	public void testGetNombre() {
		assertEquals("Pedro", a.getNombre());
	}
	public void testSetNombre() {
		b.setNombre("Naia");
		assertEquals("Naia", b.getNombre());
	}
	@Test
	public void testGetApellido(){
		assertEquals("Garcia", a.getApellido());
		
	}
	public void testSetApellido(){
		b.setApellido("Nuñez");
		assertEquals("Nuñez", b.getApellido());
		
	}
	@Test
	public void testGetEmail() {
		assertEquals("PedroGarcia@gmail.com", a.getEmail());
		
	}
	public void testSetEmail() {
		b.setEmail("NaiaN@gmail.com");
		assertEquals("NaiaN@gmail.com", b.getEmail());
		
	}
	@Test
	public void testGetContrsenya() {
		assertEquals("123Garcia", a.getContrasenya());
		
		
	}
	public void testSetContrsenya() {
		b.setContrasenya("123Naia");
		assertEquals("123Naia", b.getContrasenya());
	}
	@Test
	public void testGetAdmin() {
		assertEquals(false, a.isAdmin());
		
	}
	public void testSetAdmin() {
		b.setAdmin(true);
		assertEquals(true, b.isAdmin());
		
	}

		
	}
	
	
	
	
	
	
	


