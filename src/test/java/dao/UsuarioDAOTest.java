package dao;

import org.junit.Test;

import model.Usuario;


public class UsuarioDAOTest {
	
	Usuario usuario = new Usuario();
	
	@Test
	public void salvar(){
		usuario.setLogin("testUser");
		
	}

}
