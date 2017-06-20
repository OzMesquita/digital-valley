package util;

import org.junit.Ignore;
import org.junit.Test;

import model.Pessoa;
import model.Usuario;

public class FacadeTest {
	
	Pessoa pessoa = new Pessoa();
	Usuario usuario = new Usuario();
	@Ignore
	@Test
	public void cadatrarPessoaTest(){
		pessoa.setNome("Fachada Test");
		pessoa.setCpf("12345678998");
		pessoa.setEmail("fachada@email.com");
		pessoa.setDataNascimento("01/02/1990");
		pessoa.setId(3);
		usuario.setLogin("Login");
		usuario.setSenha("Senha123");
		pessoa.setUsuario(usuario);
		usuario.setPessoa(pessoa);
	
		util.Facade.cadastrarPessoa(pessoa, usuario);
		
		
	}
	
	@Test
	public void editar(){
		pessoa.setNome("Fachada Test 2");
		pessoa.setCpf("12345678999");
		pessoa.setEmail("fachada2@email.com");
		pessoa.setDataNascimento("02/02/1990");
		pessoa.setId(3);
		usuario.setLogin("Login2");
		usuario.setSenha("Senha1234");
		pessoa.setUsuario(usuario);
		usuario.setPessoa(pessoa);
		
		util.Facade.editarPessoa(pessoa, usuario);
		
	}

}
