package model;

import org.junit.Test;

public class ServidorTest {

	/*
	 * Foram feitos testes para diversos valores inválidos e válidos
	 */
	
	Servidor servidor = new Servidor();
	@Test(expected=IllegalArgumentException.class)
	public void siapeInvalido(){
		servidor.setSiape("1234f67");
		
	}
	
}
