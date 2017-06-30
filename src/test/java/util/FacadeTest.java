package util;

import org.junit.Ignore;
import org.junit.Test;

import model.EnumNivel;
import model.Pessoa;
import model.Usuario;

public class FacadeTest {
	
	Pessoa pessoa = new Pessoa();
	Usuario usuario = new Usuario();

	@Test
	public void cadatrarPessoaTest(){
		pessoa.setNome("Fachada Test");
		pessoa.setCpf("12345378145");
		pessoa.setEmail("fachada31@email.com");
		pessoa.setDataNascimento("01/02/1990");
		usuario.setLogin("Login1s");
		usuario.setSenha("Senha123");
		usuario.setNivel(EnumNivel.ADMINISTRADOR);
		pessoa.setUsuario(usuario);
		usuario.setPessoa(pessoa);
	
		util.Facade.cadastrarPessoa(pessoa, usuario);
		
		
	}
	@Ignore
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
