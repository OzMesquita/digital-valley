package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import dao.AlunoDAO;
import dao.ModuloDAO;
import dao.PessoaDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Pessoa;
import model.Usuario;
import model.Modulo;

public class Facade {

	public static void cadastrarPessoa(Pessoa pessoa, Usuario usuario) {

		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		System.out.println("Login: " +usuario.getLogin());
		System.out.println("Pessoa Login: " +pessoa.getUsuario().getLogin());
		pessoaDAO.cadastrar(pessoa);
		Pessoa p1 = pessoaDAO.buscar(usuario.getLogin());
		usuario.setPessoa(p1);
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
	public static List<Modulo> buscarModulosPorPessas(Pessoa pessoa){
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscar(pessoa);
	}

}
