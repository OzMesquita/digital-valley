package dao;

import org.junit.Test;

import dao.UsuarioDAO;
import model.Pessoa;
import model.Usuario;
import util.DAOFactory;


public class UsuarioDAOTest {
	
	private Usuario usuario = new Usuario();
	
	@Test
	public void salvar(){
		usuario.setLogin("deyvison");
		usuario.setSenha("deyvison123");
		Pessoa p = new Pessoa();
		p.setId(1);
		usuario.setPessoa(p);
		UsuarioDAO uDAO = DAOFactory.criarUsuarioDAO();
		uDAO.cadastrar(usuario);
		
		
	}

}
