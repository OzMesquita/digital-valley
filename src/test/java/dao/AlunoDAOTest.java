package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Aluno;
import model.Curso;
import util.DAOFactory;

public class AlunoDAOTest {

	private Aluno aluno = new Aluno();

	
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
	
	@Ignore
	@Test
	public void testBuscarPorMatricula(){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		aluno = aDAO.buscarPorMatricula("123457");
		Assert.assertTrue(aluno != null);
		System.out.println("Nome: "+aluno.getNome());
		System.out.println("Matricula: "+aluno.getMatricula());
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
	
	@Test
	public void testPreCadastro(){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		Assert.assertTrue(aDAO.buscarPreCadastro("370178", "DEYVISON nogueira"));
	}
	
	@Test
	public void testBuscarNome(){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		List<Aluno> alunos = aDAO.buscarPorNome("tagila");
		
		System.out.println("Listar alunos: "+alunos.size());
		for(Aluno a: alunos){
			System.out.println("curso "+a.getCurso().getNome());
			System.out.println("Matricula "+a.getMatricula());
			System.out.println("Nome "+a.getNome());
		}
		Assert.assertTrue(alunos != null);
	}
	
	@Test
	public void testBuscarCursoPreCadastrado(){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		Assert.assertTrue(aDAO.buscarCursoPreCadastrado("370178", "Deyvisoogueira rodrigues") ==-1 );
	}
	
	@Ignore
	@Test
	public void testExcluirPrecadastro(){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		aDAO.excluirAlunoPreCadastro("370183", "rogerio sena Leitao");
		
		
	}
	

}
