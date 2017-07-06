package util;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Aluno;
import model.Curso;
import model.EnumNivel;
import model.Pessoa;
import model.Usuario;

public class FacadeTest {
	
	Pessoa pessoa = new Pessoa();
	Usuario usuario = new Usuario();
	@Ignore
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
	@Ignore
	@Test
	public void testVerificacao(){
		Assert.assertTrue(util.Facade.verificacao("123457", "beto"));
	}

	@Ignore
	@Test
	public void cadastrarAlunoTest(){
				
		pessoa.setNome("testando aluno");
		pessoa.setCpf("99941179949");
		pessoa.setEmail("alun5555555o@teste.com");
		pessoa.setDataNascimento("22/08/1998");
		usuario.setLogin("reprovamei");
		usuario.setSenha("hbbbbbbbbbbbb");
		usuario.setNivel(EnumNivel.COMUM);
		pessoa.setUsuario(usuario);
		usuario.setPessoa(pessoa);
		
		Aluno aluno = new Aluno();
		aluno.setMatricula("333321");
		aluno.setSemestreIngresso("2016.1");
		
		Curso curso = new Curso();
		curso.setId(1);
		aluno.setCurso(curso);

		util.Facade.cadastrarAluno(pessoa, aluno);
		
	}
	
}
