package model;


import org.junit.Ignore;
import org.junit.Test;

public class ModuloTest {
	
	Modulo modulo = new Modulo();

	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void tituloInvalido(){
		modulo.setTitulo("");
		
	}
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void urlInvalido(){
		modulo.setUrl("");
		
	}
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void imagemInvalido(){
		modulo.setImagem(null);
		
		
	}
	
	@Ignore
	@Test
	public void ModuloValido(){
		modulo.setTitulo("Titulo");
		modulo.setUrl("url");
		modulo.setImagem("imagem");
	}
	
}
