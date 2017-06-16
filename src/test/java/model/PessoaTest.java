package model;

import java.time.LocalDate;

import org.junit.Test;

public class PessoaTest {
	
	private Usuario usuario;
	private LocalDate dataNascimento;
	
	public PessoaTest() {
		super();
		this.usuario = new Usuario("SeuLogin","SuaSenha");
		this.dataNascimento = LocalDate.of(1995, 06, 15);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cpfInvalido(){
		Pessoa p = new Pessoa();
		p.setCpf("1234567891011");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nomeInvalido(){
		Pessoa p = new Pessoa();
		p.setNome("");
	}
	@Test(expected=IllegalArgumentException.class)
	public void emailInvalido(){
		Pessoa p = new Pessoa();
		p.setEmail("emailerrado");
	}
	@Test(expected=RuntimeException.class)
	public void dataInvalido(){
		Pessoa p = new Pessoa();
		p.setDataNascimento("01011999");
	}
	
	@Test
	public void valido(){
		Pessoa p = new Pessoa();
		p.setNome("Deyvison");
		p.setCpf("12345678910");
		p.setEmail("email@.com");
		p.setDataNascimento("01/12/2000");
	}
	
}
