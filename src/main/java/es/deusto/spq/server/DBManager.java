package es.deusto.spq.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Instalacion;
import es.deusto.spq.client.ReservaInstalaciones;

import es.deusto.spq.client.gui.VentanaLogin;


public class DBManager {
	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	private static boolean inicializado = false;
	private static Connection conn;
	
	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	/**
	 * Obtencion de la instancia del DBManager, si no existe la crea y si existe la devuelve
	 * @return instancia de DBManager
	 */
	
	public static DBManager getInstance() {
//		if (instance == null) {
		instance = new DBManager();
//			System.out.println("Nuevo DBManager");
//		}
		if(!inicializado) {
			inicializado = true;
			instance.borrarDatos();
			instance.inicializarDatos();
			
	}

		return instance;
	}
	
	public void borrarDatos() {
		borrarClientes();
		borrarInstalaciones();
		borrarReservasInstalaciones();
		
		
	}
	

	
	public void storeObjectInDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		

		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error storing an object: " + ex.getMessage());
			System.out.println("Object:" + object);
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
		
	public void deleteObjectFromDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			
			pm.deletePersistent(object);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		}
	
	public void store(Cliente client) {
		DBManager.getInstance().storeObjectInDB(client);
	}

	public void delete(Cliente client) {
		DBManager.getInstance().deleteObjectFromDB(client);
	}
	
	public void store(ReservaInstalaciones r) {
		DBManager.getInstance().storeObjectInDB(r);
	}

	public void delete(ReservaInstalaciones r) {
		DBManager.getInstance().deleteObjectFromDB(r);
	}
	
	public void store(Instalacion i) {
		DBManager.getInstance().storeObjectInDB(i);
	}
	
	public void delete(Instalacion i) {
		DBManager.getInstance().deleteObjectFromDB(i);
	}
	
	
	public Cliente getUsuario(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Cliente user = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Cliente.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			user = (Cliente) query.execute();

			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el usuario de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return user;	
		}
	
	public void borrarClientes() {
		List<Cliente> usuarios = new ArrayList<Cliente>();
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			Extent<Cliente> extent = pm.getExtent(Cliente.class, true);

			for (Cliente usuario : extent) {
				pm.deletePersistent(usuario);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}
	
	
	public void agregarClientePolideportivo(List<Cliente> clientes) {
		PreparedStatement preparedStatement = null;

	        try {
	            
	        	for (Cliente c : clientes) {
	        		String query = " INSERT INTO CLIENTE (DNI, NOMBRE, APELLIDO, EDAD, EMAIL, CONTRASENYA, ADMIN)"
		                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";

		            preparedStatement = conn.prepareStatement(query);

		            preparedStatement.setString(1, c.getDNI());
		            preparedStatement.setString(2, c.getNombre());
		            preparedStatement.setString(3, c.getApellido());
		            preparedStatement.setInt(4, c.getEdad());
		            preparedStatement.setString(5, c.getEmail());
		            preparedStatement.setString(6, c.getContrasenya());
		            preparedStatement.setBoolean(7, c.isAdmin());
		            preparedStatement.execute();

		            System.out.println("Clientes agregados correctamente");
				}
	        	

	        } catch (Exception e) {
	            System.out.println("Error agregando los clientes");
	            System.out.println(e);
	        }
	}
	//Metodo para borrar las instalaciones al iniciar
	public void borrarInstalaciones() {
		List<Instalacion> Instalaciones = new ArrayList<Instalacion>();
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			Extent<Instalacion> extent = pm.getExtent(Instalacion.class, true);

			for (Instalacion instalacion : extent) {
				pm.deletePersistent(instalacion);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	//Metodo para borrar las reservas al iniciar
	public void borrarReservasInstalaciones() {
		List<ReservaInstalaciones> reservaInstalaciones = new ArrayList<ReservaInstalaciones>();
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			Extent<ReservaInstalaciones> extent = pm.getExtent(ReservaInstalaciones.class, true);

			for (ReservaInstalaciones reservaInstalacion : extent) {
				pm.deletePersistent(reservaInstalacion);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}
	//Metodo para sacar todas las instalaciones
	public List<Instalacion> getInstalaciones() {
		List<Instalacion> instalaciones = new ArrayList<Instalacion>();
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			Extent<Instalacion> extent = pm.getExtent(Instalacion.class, true);

			for (Instalacion instalacion : extent) {
				instalaciones.add(instalacion);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return instalaciones;
	}
	 //Metodo para sacar todas las reservas
	public List<ReservaInstalaciones> getReservasInstalaciones() {
		List<ReservaInstalaciones> reservasInstalaciones = new ArrayList<ReservaInstalaciones>();
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			Extent<ReservaInstalaciones> extent = pm.getExtent(ReservaInstalaciones.class, true);

			for (ReservaInstalaciones reservaInstalacion : extent) {
				reservasInstalaciones.add(reservaInstalacion);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return reservasInstalaciones;
	}
	//borrar reserva en concreto
	public void borrarReservaInstalacion(ReservaInstalaciones reserva) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + ReservaInstalaciones.class.getName() + " WHERE IDReserva == '" + reserva.getIDReserva() + "'");
			System.out.println(" * '" + query.deletePersistentAll() + "' reserva borrada de la DB.");
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error querying a Reserva: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}
	
	public ReservaInstalaciones  getReservaInstalaciones(String IDInstalacion) {
        PersistenceManager pm = pmf.getPersistenceManager();
        pm.getFetchPlan().setMaxFetchDepth(4);
        Transaction tx = pm.currentTransaction();
        ReservaInstalaciones reservas = null;

        try {
            tx.begin();

            Query<?> query = pm.newQuery("SELECT FROM " + ReservaInstalaciones.class.getName() + " WHERE IDReserva == '" + IDInstalacion + "'");
            query.setUnique(true);
            reservas = (ReservaInstalaciones) query.execute();

            tx.commit();
        } catch (Exception ex) {
            System.out.println(" $ Error cogiendo el reserva de la BD: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return reservas;
    }
	
	public void inicializarDatos() {
		System.out.println(" * Inicializando base de datos");
		
		Cliente c1 = new Cliente("43527594", "Manolito", "Manolito", 18, "manolito@gmail.com", "manolito123", false);
		Cliente c2 = new Cliente("admin", "admin", "admin", 20, "admin@admin.com", "admin", true);
		Cliente c3 = new Cliente("43124342", "Copito", "Copito", 24, "copito@gmail.com", "copito123", false);
		Cliente c4 = new Cliente("36485496", "Juanito", "Juanito", 24, "juanito@gmail.com", "juanito123", false);
		
		Instalacion i1 = new Instalacion("001", "Piscina", 20, false);
		Instalacion i2 = new Instalacion("002", "CampoFutbol", 100, false);
		Instalacion i3 = new Instalacion("003", "CanchaBalocento", 80, false);
		Instalacion i4 = new Instalacion("004", "PistaTenis", 90, false);
		
		ReservaInstalaciones r1 = new ReservaInstalaciones("R01", "001", "manolito@gmail.com", 2023, 5, 6, 11);
		ReservaInstalaciones r2 = new ReservaInstalaciones("R02", "002", "manolito@gmail.com", 2022, 3, 7, 14);
		ReservaInstalaciones r3 = new ReservaInstalaciones("R03", "001", "copito@gmail.com", 2022, 7, 9, 17);
		ReservaInstalaciones r4 = new ReservaInstalaciones("R04", "004", "copito@gmail.com", 2023, 5, 6, 17);
		ReservaInstalaciones r5 = new ReservaInstalaciones("R05", "003", "juanito@gmail.com", 2022, 6, 4, 15);
		ReservaInstalaciones r6 = new ReservaInstalaciones("R06", "001", "juanito@gmail.com", 2022, 6, 5, 19);
		try {
			 store(c1);
			 store(c2);
			 store(c3);
			 store(c4);
			 store(i1);
			 store(i2);
			 store(i3);
			 store(i4);
			 store(r1);
			 store(r2);
			 store(r3);
			 store(r4);
			 store(r5);
			 store(r6);
			 
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(" $ Error inicializando los datos: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	
}