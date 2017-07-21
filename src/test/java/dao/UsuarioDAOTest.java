package dao;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import dao.UsuarioDAO;
import model.EnumNivel;
import model.Pessoa;
import model.Usuario;
import util.DAOFactory;


public class UsuarioDAOTest {
	
	private Usuario usuario = new Usuario();
	
	//Passou no teste
	@Ignore
	@Test
	public void salvar(){
		usuario.setLogin("deyvert");
		usuario.setSenha("deyvison123");
		usuario.setNivel(EnumNivel.ADMINISTRADOR);
		Pessoa p = new Pessoa();
		p.setId(14);
		usuario.setPessoa(p);
		UsuarioDAO uDAO = DAOFactory.criarUsuarioDAO();
		uDAO.cadastrar(usuario);
		
		
	}
	
	//Passou no teste
	@Ignore
	@Test
	public void editar(){
		usuario.setLogin("Joao");
		usuario.setSenha("987123");
		Pessoa p = new Pessoa();
		
		usuario.setPessoa(p);
		
		UsuarioDAO uDAO = DAOFactory.criarUsuarioDAO();
		uDAO.editar(usuario);
		
		
	}	

	//Passou no teste
	
	@Test
	public void autenticar(){
		UsuarioDAO uDAO= DAOFactory.criarUsuarioDAO();
		Assert.assertTrue(uDAO.autenticar("deyvison", "deyvison123"));		
		
	}

	
}
