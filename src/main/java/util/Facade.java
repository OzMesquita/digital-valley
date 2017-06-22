package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dao.AlunoDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Pessoa;
import model.Usuario;

public class Facade {

	public static void cadastrarPessoa(Pessoa pessoa, Usuario usuario) {

		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		pessoaDAO.cadastrar(pessoa);

		usuario.setPessoa(pessoa);

		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		usuarioDAO.cadastrar(usuario);

	}

	public static void cadastrarAluno(Pessoa pessoa, Usuario usuario, Aluno aluno) {
		Facade.cadastrarPessoa(pessoa, usuario);

		AlunoDAO alunoDAO = DAOFactory.criarAlunoDAO();
		alunoDAO.cadastrar(aluno);

	}

	public static void editarPessoa(Pessoa pessoa, Usuario usuario) {
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		pessoaDAO.editar(pessoa);

		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		usuarioDAO.editar(usuario);

	}

	public static Usuario buscarPorLogin(String login) {
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		return pDAO.buscar(login).getUsuario();
	}

	public static String[] lerArquivoBancoDeDados() {
		String [] bd = new String[3];
		try {
			FileReader arquivo = new FileReader("C:\\n2s\\bd.txt");
			BufferedReader reader = new BufferedReader(arquivo);
			try {
				bd[0] = reader.readLine();
				bd[1] = reader.readLine();
				bd[2] = reader.readLine();
			} catch (IOException e) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return bd;

	}

}
