package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Aluno;
import model.Curso;

public class AlunoDAOTest {

	private Aluno aluno = new Aluno();

	@Ignore
	@Test
	public void salvar() {
		Curso curso = new Curso();
		curso.setNome("CC");
		curso.setId(4);

		aluno.setMatricula("370178");
		aluno.setSemestreIngresso("2016.1");
		aluno.setId(69);
		aluno.setCurso(curso);
		AlunoDAO adao = DAOFactory.criarAlunoDAO();

		adao.cadastrar(aluno);
	}

	@Ignore
	@Test
	public void buscar() {
		AlunoDAO adao = DAOFactory.criarAlunoDAO();
		aluno.setId(4);
		Assert.assertTrue(adao.buscar(aluno.getId()) != null);
		aluno = adao.buscar(4);
		System.out.println(aluno.getNome());

	}
	

	@Test
	public void testBuscarPorMatricula(){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		aluno = aDAO.buscarPorMatricula("123454");
		Assert.assertTrue(aluno != null);
		System.out.println("Nome: "+aluno.getNome());
		System.out.println("Matricula: "+aluno.getMatricula());
		System.out.println(aluno.getUsuario().getPessoa().getNome());
	}
	
	@Ignore
	@Test
	public void listar() {
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		List<Aluno> alunos = aDAO.listar();
		
		System.out.println("Listar alunos: "+alunos.size());
		for(Aluno a: alunos){
			System.out.println("curso "+a.getCurso().getNome());
			System.out.println("Matricula "+a.getMatricula());
			System.out.println("Nome "+a.getNome());
		}
		Assert.assertTrue(alunos != null);
	}
	@Ignore
	@Test
	public void editar() {
		Curso curso = new Curso();
		curso.setNome("CC");
		curso.setId(1);
		aluno.setId(4);
		aluno.setCurso(curso);
		aluno.setMatricula("777777");
		aluno.setSemestreIngresso("2018.1");

		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		aDAO.editar(aluno);

	}
	
	
	@Ignore
	@Test
	public void testBuscarNome(){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		List<Aluno> alunos = aDAO.buscarPorNome("danmwlkdnawld");
		
		System.out.println("Listar alunos: "+alunos.size());
		for(Aluno a: alunos){
			System.out.println("curso "+a.getCurso().getNome());
			System.out.println("Matricula "+a.getMatricula());
			System.out.println("Nome "+a.getNome());
		}
		Assert.assertTrue(alunos != null);
	}


}
