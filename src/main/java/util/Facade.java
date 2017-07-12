package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import dao.AlunoDAO;
import dao.ModuloDAO;
import dao.PessoaDAO;
import dao.ServidorDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Pessoa;
import model.Servidor;
import model.Usuario;
import model.Modulo;
import util.DAOFactory;

public class Facade {

	public static void cadastrarPessoa(Pessoa pessoa, Usuario usuario) {

		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		pessoaDAO.cadastrar(pessoa);
		Pessoa p1 = pessoaDAO.buscarPorCpf(pessoa.getCpf());
		usuario.setPessoa(p1);
		usuarioDAO.cadastrar(usuario);
	}

	public static void cadastrarAluno(Pessoa pessoa, Aluno aluno) {
		Facade.cadastrarPessoa(pessoa, pessoa.getUsuario());
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		Pessoa p1 = pDAO.buscarPorCpf(pessoa.getCpf());

		aluno.setId(p1.getId());

		AlunoDAO alunoDAO = DAOFactory.criarAlunoDAO();
		alunoDAO.cadastrar(aluno);
	}

	public static void cadastrarServidor(Pessoa pessoa, Usuario usuario, Servidor servidor) {
		Facade.cadastrarPessoa(pessoa, usuario);

		ServidorDAO servidorDAO = DAOFactory.criarServidorDAO();
		servidorDAO.cadastrar(servidor);
	}

	public static void cadastrarModulo(Modulo modulo) {
		ModuloDAO moduloDAO = DAOFactory.criarModuloDAO();
		moduloDAO.cadastrar(modulo);
	}

	public static void editarPessoa(Pessoa pessoa, Usuario usuario) {
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		pessoaDAO.editar(pessoa);

		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		usuarioDAO.editar(usuario);
	}

	public static Usuario buscarPorLogin(String login) {
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		return pDAO.buscarPorLogin(login).getUsuario();
	}

	public static String[] lerArquivoBancoDeDados() {
		String[] bd = new String[3];
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

	public static List<Modulo> buscarModulosPorPessoas(Pessoa pessoa) {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscar(pessoa);
	}

	public static boolean verificacao(String matricula, String nome) {
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		Aluno aluno = aDAO.buscarPorMatricula(matricula);
		if (aluno != null) {
			System.out.println("Nome: "+aluno.getNome());
			if (aluno.getNome().toUpperCase().equals(nome.toUpperCase())) {
				System.out.println("Login: "+aluno.getUsuario().getLogin());
				if(aluno.getUsuario().getLogin() != null){
					return false;
				}
				return true;
			}
		}
		return false;
	}

}