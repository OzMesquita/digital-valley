package util;

import DAO.AlunoDAO;
import DAO.PessoaDAO;
import DAO.UsuarioDAO;
import model.Aluno;
import model.Pessoa;
import model.Usuario;

public class Facade {
	
	public static void cadastrarPessoa(Pessoa pessoa, Usuario usuario, Aluno aluno){
		
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		pessoaDAO.cadastrar(pessoa);
		
		usuario.setPessoa(pessoa);
		
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
		aluno.setPessoa(pessoa);
		
		AlunoDAO alunoDAO = DAOFactory.criarAlunoDAO();
		alunoDAO.cadastrar(aluno);
		
	}

	public void editarPessoa(Pessoa pessoa, Usuario usuario, Aluno aluno){
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		pessoaDAO.editar(pessoa);
		
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		usuarioDAO.editar(usuario);
		
		AlunoDAO alunoDAO = DAOFactory.criarAlunoDAO();
		alunoDAO.cadastrar(aluno);
	}
	
}
