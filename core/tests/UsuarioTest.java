import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objetos.Usuario;

public class UsuarioTest {
	
	private Usuario prueba;
	@Before
	public void setUp() {
		prueba = new Usuario("Adei","hola");
	}
	@Test
	public void testGetUsuario() {
		assertEquals(new Usuario("Adei","hola").getNombreUsuario(),prueba.getNombreUsuario());
	}
	@Test
	public void testGetContrasenya() {
		assertEquals(new Usuario("Victor","hola").getContrasenyaUsuario(),prueba.getContrasenyaUsuario());
	}
	
	@Test 
	public void testSetUsuario() {
		prueba.setNombreUsuario("Maria");
		assertEquals(prueba.getNombreUsuario(),"Maria");
	}
	
	@Test 
	public void testSetContrasenya() {
		prueba.setContrasenyaUsuario("Sara");
		assertEquals(prueba.getContrasenyaUsuario(),"Sara");
	}
	
	@Test
	public void testHashCod() {
		assertEquals(prueba.hashCode(),prueba.getNombreUsuario().hashCode());
	}
	@Test
	public void testEquals() {
		assertEquals(prueba,new Usuario("Adei","hola"));
	}
	
}
