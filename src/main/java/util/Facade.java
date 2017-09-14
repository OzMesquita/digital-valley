package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


import org.apache.commons.mail.EmailException;

import dao.AlunoDAO;
import dao.ModuloDAO;
import dao.PerfilDAO;
import dao.PessoaDAO;
import dao.PreCadastroAlunoDAO;
import dao.PreCadastroServidorDAO;
import dao.ServidorDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Email;
import model.Pessoa;
import model.Servidor;
import model.Usuario;
import model.Modulo;
import model.Perfil;

public class Facade {

	public static void cadastrarPessoa(Pessoa pessoa, Usuario usuario) {
		
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		pessoaDAO.cadastrar(pessoa);
		pessoaDAO = util.DAOFactory.criarPessoaDAO();
		Pessoa p1 = pessoaDAO.buscarPorCpf(pessoa.getCpf());
		usuario.setPessoa(p1);
		usuarioDAO.cadastrar(usuario);

		
	}

	public static void cadastrarAluno(Usuario usuario, Aluno aluno) {
		Facade.cadastrarPessoa(aluno, usuario);
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		Pessoa p1 = pDAO.buscarPorCpf(aluno.getCpf());

		aluno.setId(p1.getId());

		AlunoDAO alunoDAO = DAOFactory.criarAlunoDAO();
		alunoDAO.cadastrar(aluno);
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		preA.excluirAlunoPreCadastro(aluno.getMatricula(), aluno.getNome());
		
		
	}

	public static void cadastrarServidor(Usuario usuario, Servidor servidor) {
		Facade.cadastrarPessoa(usuario.getPessoa(), usuario);
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		Pessoa p1 = pDAO.buscarPorCpf(servidor.getCpf());
		servidor.setId(p1.getId());
		ServidorDAO servidorDAO = DAOFactory.criarServidorDAO();
		servidorDAO.cadastrar(servidor);
		PreCadastroServidorDAO preDAO = DAOFactory.criarPreCadastroServidor();
		preDAO.excluirPreCadastro(servidor.getSiape(), servidor.getNome());
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
	
	public static Usuario buscarPorMatriculaAndCPF(String matricula, String cpf) {
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		return pDAO.buscarPorMatriculaAndCPF(matricula, cpf).getUsuario();
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
        
	public static List<Modulo> buscarModulosPorPerfil(Perfil perfil) {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscar(perfil);
	}
	
	public static List<Modulo> buscarTodosModulos() {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.listar();
	}
        
	public static Modulo buscarModulosPorId(int id) {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscar(id);
	}

	public static boolean verificacaoAluno(String matricula, String nome) {
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		return preA.buscarPreCadastro(matricula, nome);
	}
	
	public static boolean verificacaoServidor(String siape, String nome){
		PreCadastroServidorDAO preServDAO = DAOFactory.criarPreCadastroServidor();
		return preServDAO.buscarPreCadastro(siape, nome);
	}
	
	public static void preCadastrarAluno(String nome, String matricula, int curso){
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		preA.preCadastrar(nome, matricula, curso);
		
	}
	
	public static void preCadastrarAluno(String nome, String matricula, int curso, String semestreDeIngresso){
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		preA.preCadastrar(nome, matricula, curso, semestreDeIngresso);
		
	}
	
	public static void preCadastroServidor(String nome, String siape){
		PreCadastroServidorDAO pDAO = DAOFactory.criarPreCadastroServidor();
		pDAO.preCadastrarServidor(siape, nome);
		
		
	}
	
	public static int buscarCursoPreCadastrado(String matricula, String nome){
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		return preA.buscarCursoPreCadastrado(matricula, nome);
	}
	
	public static boolean compararNomes(String nome1, String nome2){
		return nome1.toUpperCase().equals(nome2.toUpperCase());
	}
	
	public static List<Aluno> buscarAlunos(){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		return aDAO.listar();
	}
	
	public static List<Servidor> buscarServidor(){
		ServidorDAO sDAO = DAOFactory.criarServidorDAO();
		return sDAO.listar();
	}
	
	public static Aluno buscarAlunoPorID(int id){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		return aDAO.buscar(id);
	}
	
	
	public static List<Aluno> buscarAlunoPorNome(String nome){
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		return aDAO.buscarPorNome(nome);
	}
        
	public static Pessoa buscarPessoaPorId(int id){
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		return pDAO.buscarPorId(id);
	}
        

        
	
	public static List<Pessoa> buscarPessoaPorNome(String nome){
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		return pDAO.buscarPorNome(nome);
	}
     
	
	
	public static Perfil buscaPerfilPorId(int id){
		PerfilDAO pDAO = DAOFactory.criarPerfilDAO();
		return pDAO.buscarPorId(id);	
	}
	
	
	public static List<Perfil> ListarPeril(){
		PerfilDAO pDAO = DAOFactory.criarPerfilDAO();
		return pDAO.Listar();
	}

    public static void adicionarModulosParaUsuario(int idUsuario, int idModulo) {
    	ModuloDAO mDAO = DAOFactory.criarModuloDAO();
    	mDAO.associarUsuarioModulo(idUsuario, idModulo);

    }

    public static void adicionarModulosParaPerfil(int idPerfil, int idModulo) {
    	ModuloDAO mDAO = DAOFactory.criarModuloDAO();
    	mDAO.associarPerfilModulo(idPerfil, idModulo);
    	
    }
    
    public static Modulo buscarPorNome(String nome){
    	ModuloDAO mDAO = DAOFactory.criarModuloDAO();
    	return mDAO.buscarPorNome(nome);
    	
    }
	
 
    public static void EnviarEmailRecuperacaoDeSenha(String emailCadastrado){
        if(emailCadastrado != null){
	        Email e = new Email("Recuperação de Senha!", 
	                    "Foi constatado que você solicitou a recuperação de senha!\nClique no link para cadastrar uma nova senha "
	                            + "http://localhost:8080/Controle_De_Acesso/confirmaRecuperacao.jsp"
	                    + "\n(Obs.: Link válido até 12 horas após o envio deste e-mail)"
                                    +"\n Caso não tenha solicitado, ignore este e-mail.", emailCadastrado, "Usuário Controle de Acesso");
            try {
				e.sendEmail();
			} catch (EmailException e1) {
				throw new IllegalArgumentException("Não foi possível enviar o email!");
			}
        }else{
        	throw new IllegalArgumentException("Email não pode ser nulo");
        }
    }
    public static Pessoa BuscarEmailVinculado(String email){
        PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
        return pDAO.buscarPorEmail(email);
    }

    public static List<Pessoa> buscarPessoas() {
        PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
        return pDAO.listar();
    }
    public static List<Servidor> buscarServidorPorNome(String nome) {
        ServidorDAO sDAO = DAOFactory.criarServidorDAO();
        return sDAO.buscarPorNome(nome);
    }
      
	
	
}
