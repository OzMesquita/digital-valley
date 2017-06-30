package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Professor;
import util.DAOFactory;

public class ProfessorDAOTest {

	private Professor professor = new Professor();
	
	@Ignore
	@Test
	public void salvar() {
		
		professor.setCoordenador(true);
		professor.setId(1);
		ProfessorDAO pdao = DAOFactory.criarProfessorDAO();

		pdao.cadastrar(professor);
	}

	@Test
	public void buscar() {
		ProfessorDAO pdao = DAOFactory.criarProfessorDAO();
		professor.setId(1);
		Assert.assertTrue(pdao.buscar(professor.getId()) != null);
		
		System.out.println(professor.getNome());
	}

	@Ignore
	@Test
	public void listar() {
		ProfessorDAO pdao = DAOFactory.criarProfessorDAO();
		List<Professor> professores = pdao.listar();
		Assert.assertTrue(professores != null);
		
	}
	@Ignore
	@Test
	public void editar() {
		professor.setCoordenador(false);
		professor.setId(1);
		ProfessorDAO pdao = DAOFactory.criarProfessorDAO();

		pdao.editar(professor);

	}
}
