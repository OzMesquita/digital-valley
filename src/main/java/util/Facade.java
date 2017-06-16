package util;

import dao.AlunoDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Pessoa;
import model.Usuario;

public class Facade {
	
	public static void cadastrarPessoa(Pessoa pessoa, Usuario usuario){
		
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		pessoaDAO.cadastrar(pessoa);
		
		usuario.setPessoa(pessoa);
		
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
	}

	public void editarPessoa(Pessoa pessoa, Usuario usuario){
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		pessoaDAO.editar(pessoa);
		
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		usuarioDAO.editar(usuario);
		
		AlunoDAO alunoDAO = DAOFactory.criarAlunoDAO();
	}
	
}
