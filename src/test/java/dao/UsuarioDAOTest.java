package dao;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import dao.UsuarioDAO;
import model.Pessoa;
import model.Usuario;
import util.DAOFactory;


public class UsuarioDAOTest {
	
	private Usuario usuario = new Usuario();
	
	//Passou no teste
	@Ignore
	@Test
	public void salvar(){
		usuario.setLogin("deyvison");
		usuario.setSenha("deyvison123");
		Pessoa p = new Pessoa();
		p.setId(681);
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
		p.setId(800);
		
		usuario.setPessoa(p);
		
		UsuarioDAO uDAO = DAOFactory.criarUsuarioDAO();
		uDAO.editar(usuario);
		
		
	}	

	//Passou no teste
	@Ignore
	@Test
	public void autenticar(){
		UsuarioDAO uDAO= DAOFactory.criarUsuarioDAO();
		Assert.assertTrue(uDAO.autenticar("ldharlin", "luan123"));		
		
	}
	
}
