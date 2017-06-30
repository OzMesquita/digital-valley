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

	@Ignore
	@Test
	public void salvar() {
		Curso curso = new Curso();
		curso.setNome("CC");
		curso.setId(1);

		aluno.setMatricula("343456");
		aluno.setSemestreIngresso("2016.1");
		aluno.setId(4);
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

		System.out.println(aluno.getNome());

	}

	@Ignore
	@Test
	public void listar() {
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		List<Aluno> alunos = aDAO.listar();
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

}
