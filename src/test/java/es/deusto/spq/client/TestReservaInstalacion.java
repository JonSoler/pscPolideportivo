package es.deusto.spq.client;

import static org.junit.Assert.*;

import org.junit.Test;

import es.deusto.spq.client.ReservaInstalaciones;

public class TestReservaInstalacion {
	ReservaInstalaciones a = new ReservaInstalaciones("3b", "2A", "PedroGarcia@gmail.com", 2022, 3, 2, 10);
	ReservaInstalaciones b= new ReservaInstalaciones();
	@Test
	
	public void GetIDReserva() {
		assertEquals("3b", a.getIDReserva());
	}
	public void GetIDInstalacion() {
		assertEquals("2A", a.getIDInstalacion());
	}
	public void GetEmailUsuario() {
		assertEquals("PedroGarcia@gmail.com", a.getEmailUsuario());
	}
	public void Getanyo() {
		assertEquals(2022, a.getAnyo());
	}
	public void GetMes() {
		assertEquals(3, a.getMes());
	}
	public void GetDia() {
		assertEquals(2, a.getDia());
	}
	public void GetHora() {
		assertEquals(10, a.getHora());
		
	}
	public void SetIdInstalacion() {
		b.setIDInstalacion("2B");
		assertEquals("2B", b.getIDInstalacion());
	}
	public void SetIdReserva() {
		b.setIDReserva("3c");
		assertEquals("3c", b.getIDReserva());
	}
	public void SetEmailUsuario() {
		b.setEmailUsuario("NaiaN@gmail.com");
		assertEquals("NaiaN@gmail.com", b.getEmailUsuario());
	}
	public void Setanyo() {
		b.setAnyo(2022);
		assertEquals(2022, b.getAnyo());
	}
	public void SetMes() {
		
		b.setMes(6);
		assertEquals(6, b.getMes());
	}
	public void SetDia() {
		b.setDia(7);
		assertEquals(7, b.getDia());
	}
	public void SetHora() {
		b.setDia(11);
		assertEquals(11, b.getHora());
	
	
	
	
	}
}
