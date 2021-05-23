package model;

import org.junit.Ignore;
import org.junit.Test;

public class ServidorTest {

	/*
	 * Foram feitos testes para diversos valores inválidos e válidos
	 */
	
	Servidor servidor = new Servidor();
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void siapeInvalido(){
		servidor.setSiape("1234f67");
		
	}
	
}
