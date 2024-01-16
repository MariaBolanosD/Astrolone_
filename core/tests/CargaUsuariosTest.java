import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import db.CargaUsuarios;

public class CargaUsuariosTest {
	
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void initConnectionTest() {
		CargaUsuarios.initConnection("puntuaciones.bd");
		assertNotNull(CargaUsuarios.getConexionBBDD()); 
	}
}
