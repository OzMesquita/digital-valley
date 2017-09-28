package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Perfil;

public class PerfilDAOTest {
	
	private Perfil perfil = new Perfil();
	private PerfilDAO pDAO = DAOFactory.criarPerfilDAO();
	@Ignore
	@Test
	public void testCadastrar(){
		//passou no teste
		perfil.setNome("test");
		pDAO.cadastrar(perfil);
		
	}
	@Ignore
	@Test
	public void testBuscarPorID(){
		//passou no teste
		Assert.assertTrue(pDAO.buscarPorId(1) != null);	
	}
	
	@Ignore
	@Test
	public void testEditar(){
		//passou no teste
		perfil = pDAO.buscarPorId(6);
		perfil.setNome("teste");
		pDAO = DAOFactory.criarPerfilDAO();
		pDAO.editar(perfil);
		
	}
	
	@Ignore
	@Test
	public void testExcluir(){
		pDAO.excluir(6);
	}
	
	@Ignore
	@Test
	public void testListar(){
		//passou no teste
		List<Perfil> perfis = pDAO.Listar();
		for(Perfil p : perfis){
			System.out.println(p.getNome());
		}
		org.junit.Assert.assertTrue(perfis != null);
		
	}
	
	@Test
	public void testBucarPorNome(){
		PerfilDAO pDAO = DAOFactory.criarPerfilDAO();
		Perfil p = pDAO.buscarPorNome("aluno");
		System.out.println(p.getNome());
		Assert.assertTrue(p != null);
		
		
	}
	
	

}
