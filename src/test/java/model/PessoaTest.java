package model;

import org.junit.Ignore;
import org.junit.Test;

public class PessoaTest {

	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void cpfInvalido(){
		Pessoa p = new Pessoa();
		p.setCpf("123.456.789-110");
	}
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void nomeInvalido(){
		Pessoa p = new Pessoa();
		p.setNome("");
	}
	
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void emailInvalido(){
		Pessoa p = new Pessoa();
		p.setEmail("emailerrado");
	}
	
	@Ignore
	@Test(expected=RuntimeException.class)
	public void dataInvalido(){
		Pessoa p = new Pessoa();
		p.setDataNascimento("01011999");
	}
	
	@Ignore
	@Test
	public void valido(){
		Pessoa p = new Pessoa();
		p.setNome("Deyvison");
		p.setCpf("12345678910");
		p.setEmail("ramo@gmail.com");
		String[] data = "01/12/2000".split("/");
		System.out.println(data.length);
		p.setDataNascimento("01/12/2000");
		System.out.println("teste"+p.getDataNascimento());
		
	}
	
}
