package dao;

import java.util.List;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Professor;

public class ProfessorDAOTest {

	private Professor professor = new Professor();
	
	@Ignore
	@Test
	public void salvar() {
		
		professor.setCoordenador(false);
		professor.setId(82);
		ProfessorDAO pdao = DAOFactory.criarProfessorDAO();

		pdao.cadastrar(professor);
	}
	@Ignore
	@Test
	public void buscar() {
		ProfessorDAO pdao = DAOFactory.criarProfessorDAO();
		professor.setId(6);
		Assert.assertTrue(pdao.buscar(professor.getId()) != null);
		
		professor = pdao.buscar(6);
		System.out.println("Nome: " + professor.getNome());
		System.out.println("CPF: " + professor.getCpf());
		System.out.println("Siape: " + professor.getSiape());
		

	}
@Ignore
	@Test
	public void listar() {
		ProfessorDAO pdao = DAOFactory.criarProfessorDAO();
		List<Professor> professores = pdao.listar();
		
		System.out.println("Listar professores: "+ professores.size());
		for(Professor p: professores){
			System.out.println("Nome: "+ p.getNome());
			System.out.println("CPF "+ p.getCpf());
			System.out.println("Siape "+ p.getSiape());

		}	
		Assert.assertTrue(professores != null);
		
	}
	
	@Test
	public void buscarPorSiape() {
		ProfessorDAO pdao = DAOFactory.criarProfessorDAO();
		Professor p = pdao.buscarPorSiape("4785698");
		System.out.println("Nome: " + p.getNome());
		System.out.println("CPF: " + p.getCpf());
		System.out.println("Siape: " + p.getSiape());
		
	}

}
