package model;


import org.junit.Test;

public class ModuloTest {
	
	Modulo modulo = new Modulo();

	@Test(expected=IllegalArgumentException.class)
	public void tituloInvalido(){
		modulo.setTitulo("");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void urlInvalido(){
		modulo.setUrl("");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void imagemInvalido(){
		modulo.setImagem(null);
		
		
	}
	
	@Test
	public void ModuloValido(){
		modulo.setTitulo("Titulo");
		modulo.setUrl("url");
		modulo.setImagem("imagem");
	}
	
}
