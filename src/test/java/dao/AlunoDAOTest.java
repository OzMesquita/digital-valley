package dao;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Aluno;
import util.DAOFactory;


public class AlunoDAOTest {
	
	private Aluno aluno = new Aluno();
	
	@Ignore
	@Test
	public void salvar() {
			
		aluno.setMatricula("113456");
		aluno.setSemestreIngresso("2017.1");
		aluno.setId(1);
		
		AlunoDAO adao = DAOFactory.criarAlunoDAO();
	
		adao.cadastrar(aluno);
	}
	@Ignore
	@Test
	public void buscar() {
		AlunoDAO adao = DAOFactory.criarAlunoDAO();
		aluno.setId(2);

		Assert.assertTrue(adao.buscar(aluno.getId()) != null);
	

	}
}
