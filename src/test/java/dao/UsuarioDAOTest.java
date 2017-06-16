package dao;

import org.junit.Test;

import dao.UsuarioDAO;
import model.Usuario;
import util.DAOFactory;


public class UsuarioDAOTest {
	
	private Usuario usuario = new Usuario();
	
	@Test
	public void salvar(){
		usuario.setLogin("deyvison");
		usuario.setSenha("deyvison123");
		usuario.getPessoa().setId(1);
		UsuarioDAO uDAO = DAOFactory.criarUsuarioDAO();
		uDAO.cadastrar(usuario);
		
		
	}

}
