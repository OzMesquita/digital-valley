package model;

import org.junit.Ignore;
import org.junit.Test;

public class UsuarioTest {

	private Usuario usuario = new Usuario();
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void loginInvalido(){
		this.usuario.setLogin("a");
	}
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void senhaInvalido(){
		this.usuario.setSenha("12345");
	}
	
	@Ignore
	@Test
	public void valido(){
		this.usuario.setLogin("admin");
		this.usuario.setSenha("123456");
	}
	
}
