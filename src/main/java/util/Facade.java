package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import dao.AlunoDAO;
import dao.DAOFactory;
import dao.ModuloDAO;
import dao.PerfilDAO;
import dao.PessoaDAO;
import dao.PreCadastroAlunoDAO;
import dao.PreCadastroServidorDAO;
import dao.ProfessorDAO;
import dao.ServidorDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Email;
import model.EnumCargo;
import model.Pessoa;
import model.Professor;
import model.Servidor;
import model.Usuario;
import model.Modulo;
import model.Perfil;

public class Facade {

	private Facade() {
		//
	}
	
	public static int executeHTTPRequestToModule(String url, String jsonUser) throws ClientProtocolException, IOException {
		StringEntity input = new StringEntity(jsonUser);
		System.out.println(url);
		System.out.println(jsonUser);
		input.setContentType("application/json");
		HttpPost postRequest = new HttpPost(url);
		HttpClient httpClient = HttpClientBuilder.create().build();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		nameValuePairs.add(new BasicNameValuePair("json", jsonUser));
		postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		HttpResponse response = httpClient.execute(postRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
            return response.getStatusLine().getStatusCode();
        }
		return 200;
	}

	public static String buildToken() {
		int qtdeCaracteres = 60;
		String[] caracteres = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };
		StringBuilder token = new StringBuilder();
		for (int i = 0; i < qtdeCaracteres; i++) {
			int posicao = (int) (Math.random() * caracteres.length);
			token.append(caracteres[posicao]);
		}
		return token.toString();
	}

	public static String getDiretorioPerfilUsuario(int id) {
		Pessoa pessoa = DAOFactory.criarPessoaDAO().buscarPorId(id);
		String imagem = pessoa.getImagem();
		if (imagem != null && !imagem.trim().isEmpty()) {
			return Constantes.getUSER_PROFILE_IMAGES_DIR()+File.separator+imagem;	
		}else {
			return Constantes.getUSER_PROFILE_NONE_IMAGE_DIR();
		}
	} 
	
	public static void cadastrarPessoa(Pessoa pessoa, Usuario usuario) {

		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		pessoaDAO.cadastrar(pessoa);
		pessoaDAO = dao.DAOFactory.criarPessoaDAO();
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
		if(servidor.getCargo().equals(EnumCargo.PROFESSOR)) {
			ProfessorDAO proDAO = DAOFactory.criarProfessorDAO();
			Professor p = new Professor(servidor.getNome(),servidor.getCpf(),servidor.getEmail(),servidor.getUsuario(),servidor.getDataNascimento(),servidor.getSiape(),false);
			p.setId(servidor.getId());
			proDAO.cadastrar(p);
			
		}
		PreCadastroServidorDAO preDAO = DAOFactory.criarPreCadastroServidor();
		preDAO.excluirPreCadastro(servidor.getSiape(), servidor.getNome());
	}

	public static void cadastrarModulo(Modulo modulo) {
		ModuloDAO moduloDAO = DAOFactory.criarModuloDAO();
		moduloDAO.cadastrar(modulo);
	}

	public static void editarPessoa(Pessoa pessoa, Usuario usuario) {
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		pessoaDAO.editar(pessoa);		
		usuarioDAO.editar(usuario);
	}
	
	public static void editarUsuarioESenha(Pessoa pessoa, Usuario usuario) {
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		UsuarioDAO usuarioDAO = DAOFactory.criarUsuarioDAO();
		pessoaDAO.editar(pessoa);		
		usuarioDAO.editarUsuarioESenha(usuario);
	}

	public static Usuario buscarPorLogin(String login) {
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		Pessoa p = pDAO.buscarPorLogin(login);
		Aluno aluno = DAOFactory.criarAlunoDAO().buscar(p.getId());
		Servidor servidor = DAOFactory.criarServidorDAO().buscar(p.getId());
		
		
		if(aluno != null){
			return aluno.getUsuario();
		}else if (servidor != null){
			return servidor.getUsuario();
		}
			
		return p.getUsuario();
	}
	
	public static Usuario buscarPorEmail(String email) {
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		Pessoa p = pDAO.buscarPorEmail(email);
		Aluno aluno = DAOFactory.criarAlunoDAO().buscar(p.getId());
		Servidor servidor = DAOFactory.criarServidorDAO().buscar(p.getId());
		
		
		if(aluno != null){
			return aluno.getUsuario();
		}else if (servidor != null){
			return servidor.getUsuario();
		}
			
		return p.getUsuario();
	}
	public static boolean verificarCPF(String CPF) {
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		Pessoa p = pDAO.buscarPorCpf(CPF);
		if (p==null) {
			return false;
		}else {
			return true;
		}
	}
	
	public static Usuario buscarPorMatriculaAndCPF(String matricula, String cpf) {
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		return pDAO.buscarPorMatriculaAndCPF(matricula, cpf).getUsuario();
	}
	public static Usuario buscarPorSiapeAndCPF(String siape, String cpf){
		PessoaDAO pDao = DAOFactory.criarPessoaDAO();
		return pDao.buscarPorSiapeAndCPF(siape, cpf);
	}

	public static String[] lerArquivoBancoDeDados() {
		String[] bd = new String[3];
		try {			
			FileReader arquivo = new FileReader(Constantes.getDatabaseConfDir());
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

	public static String[] lerArquivoEmail() {
		String[] email = new String[2];
		try {
			FileReader arquivo = new FileReader(Constantes.getEmailConfDir());
			BufferedReader reader = new BufferedReader(arquivo);
			try {
				email[0] = reader.readLine();
				email[1] = reader.readLine();
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

		return email;

	}

	public static List<Modulo> buscarModulosPorPessoas(Pessoa pessoa) {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscar(pessoa);
	}

	public static List<Modulo> buscarModulosPorPerfil(int perfil) {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscarPorPerfil(perfil);
	}
	
	public static List<Modulo> buscarTodosModulosPorPerfil(Pessoa pessoa){
		List<Modulo> modulos = Facade.buscarModulosPorPessoas(pessoa);
		List<Modulo> modulosPerfil = Facade.buscarModulosPorPerfil(pessoa.getUsuario().getPerfil().getValorPerfil());
		boolean has = false;
		for(Modulo m:modulosPerfil){
			has = false;
			for(Modulo m2: modulos){
				if(m2.getId() == m.getId()){
					has = true;
				}
			}
			if(!has){
				modulos.add(m);
			}
		}
		return modulos;
		
	}

	public static List<Modulo> buscarTodosModulos() {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.listar();
	}

	public static Modulo buscarModulosPorId(int id) {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscar(id);
	}

	public static boolean verificacaoAluno(String matricula) {
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		return preA.buscarPreCadastro(matricula);
	}
	
	public static boolean verificacaoAluno(String matricula, String nome) {
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		return preA.buscarPreCadastro(matricula, nome);
	}

	public static boolean verificacaoServidor(String siape, String nome) {
		PreCadastroServidorDAO preServDAO = DAOFactory.criarPreCadastroServidor();
		return preServDAO.buscarPreCadastro(siape, nome);
	}
	
	public static boolean verificacaoServidor(String siape) {
		PreCadastroServidorDAO preServDAO = DAOFactory.criarPreCadastroServidor();
		return preServDAO.buscarPreCadastro(siape);
	}

	public static void preCadastrarAluno(String nome, String matricula, int curso) throws Exception {
		Aluno aluno = DAOFactory.criarAlunoDAO().buscarPorMatricula(matricula);
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		if(!matricula.matches("^[0-9]+$")) {
			throw new Exception("Matrícula " + matricula+ " inválida");
		}else if(aluno != null || (preA.buscarPreCadastro(matricula))){
				throw new IllegalArgumentException("Aluno(a) " + nome + " já possui cadastro");
			}else {
				preA.preCadastrar(nome, matricula, curso);
		}

	}
	//Este método está em desuso
	public static void preCadastrarAluno(String nome, String matricula, int curso, String semestreDeIngresso) {
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		preA.preCadastrar(nome, matricula, curso, semestreDeIngresso);

	}

	public static void preCadastroServidor(String nome, String siape) {
		
		if(!nome.matches("^[aA-zZ]+(( [aA-zZ]+)+)?$")) {
			throw new IllegalArgumentException("Erro: O nome não poder ser nulo e deve possuir pelo menos 1 caracterese não ter números, valor informado: " + nome+"!");
		}
		if(siape.length() != 7 && !siape.matches("^[0-9]+$")) {
			throw new IllegalArgumentException("Erro: O SIAPE deve ter exatamente 7 números, valor informado: " + siape+"!");
		}
		
		ServidorDAO sDAO = DAOFactory.criarServidorDAO();
		Servidor s = sDAO.buscarPorSiape(siape);
		PreCadastroServidorDAO pDAO = DAOFactory.criarPreCadastroServidor();
		if( pDAO.buscarPreCadastro(siape, nome) ){
			throw new IllegalArgumentException("Servidor já possui pré-cadastro no sistema!");
		}else if(s == null){		
			pDAO.preCadastrarServidor(siape, nome);
		}else{
			throw new IllegalArgumentException("Servidor já possui cadastro no sistema!");
		}										
		
	}

	public static int buscarCursoPreCadastrado(String matricula, String nome) {
		PreCadastroAlunoDAO preA = DAOFactory.criarPreCadastroAluno();
		return preA.buscarCursoPreCadastrado(matricula, nome);
	}

	public static boolean compararNomes(String nome1, String nome2) {
		return nome1.toUpperCase().equals(nome2.toUpperCase());
	}

	public static List<Aluno> buscarAlunos() {
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		return aDAO.listar();
	}
	
	public static List<Pessoa> buscarPessoasPorNome(String nome, int inicio, int fim) {
		return DAOFactory.criarPessoaDAO().buscarPorNome(nome, inicio, fim);
	}
	
	public static Integer getQuantidadePessoasPorNome(String nome) {
		return DAOFactory.criarPessoaDAO().getQuantidadePorNome(nome);
	}
	
	public static List<Aluno> buscarAlunosPorNome(String nome, int inicio, int fim) {
		return DAOFactory.criarAlunoDAO().buscarPorNome(nome, inicio, fim);
	}
	
	public static Integer getQuantidadeAlunosPorNome(String nome) {
		return DAOFactory.criarAlunoDAO().getQuantidadePorNome(nome);
	}

	public static List<Servidor> buscarServidor() {
		ServidorDAO sDAO = DAOFactory.criarServidorDAO();
		return sDAO.listar();
	}

	public static Aluno buscarAlunoPorID(int id) {
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		return aDAO.buscar(id);
	}

	public static List<Aluno> buscarAlunoPorNome(String nome) {
		AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
		return aDAO.buscarPorNome(nome);
	}

	public static Pessoa buscarPessoaPorId(int id) {
		
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		Pessoa p = pDAO.buscarPorId(id);
		Aluno aluno = DAOFactory.criarAlunoDAO().buscar(p.getId());
		Servidor servidor = DAOFactory.criarServidorDAO().buscar(p.getId());
		
		
		if(aluno != null){
			return aluno;
		}else if (servidor != null){
			return servidor;
		}
		return p;
	}

	public static List<Pessoa> buscarPessoaPorNome(String nome) {
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		return pDAO.buscarPorNome(nome);
	}

	public static Perfil buscaPerfilPorId(int id) {
		PerfilDAO pDAO = DAOFactory.criarPerfilDAO();
		return pDAO.buscarPorId(id);
	}

	public static List<Perfil> ListarPeril() {
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

	public static Modulo buscarPorNome(String nome) {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscarPorNome(nome);

	}
	public static List<Modulo> buscarPorNome(String nome, int inicio, int fim) {
		ModuloDAO mDAO = DAOFactory.criarModuloDAO();
		return mDAO.buscarPorNome(nome, inicio, fim);
	}

	public static void EnviarEmailRecuperacaoDeSenha(Pessoa pessoa) {
		if (pessoa != null) {
			Email e = new Email();
			e.sendEmail("Recuperação de Senha!",
					"Foi constatado que você solicitou a recuperação de senha!\nClique no link para cadastrar uma nova senha "
							+ Constantes.getPreUrl()+Constantes.getAppUrl()+"/ConfirmaRecuperacao?token="+DAOFactory.criarPessoaDAO().buscarTokenRecuperacao(pessoa)
							+ "\n(Obs.: Link válido até o dia de envio deste e-mail)"
							+ "\n Caso não tenha solicitado, ignore este e-mail.",
					pessoa.getEmail(), "Usuário Controle de Acesso");
		} else {
			throw new IllegalArgumentException("Email não pode ser nulo");
		}
	}
	
	public static void inserirToken(Pessoa pessoa){
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		pDAO.inserirTokenRecuperacao(pessoa);
		
	}

	public static Pessoa BuscarEmailVinculado(String email) {
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
	
	public static Pessoa verificarTokenRecuperacao(String token){
		Aluno aluno = DAOFactory.criarAlunoDAO().buscarTokenRecuperacao(token);
		Servidor servidor = DAOFactory.criarServidorDAO().buscarPorToken(token);
		if(aluno != null){
			return aluno;
		}else if(servidor != null){
			return servidor;
		}else{
			return null;
		}
	}

	public static String getDiretorioImagemModulo(int id) {		
		return DAOFactory.criarModuloDAO().buscar(id).getImagem();
	}

	public static Integer getQuantidadeServidoresPorNome(String nome) {
		return DAOFactory.criarServidorDAO().getQuantidadePorNome(nome);
	}

	public static List<Servidor> buscarServidoresPorNome(String nome, Integer inicio, Integer fim) {
		ServidorDAO sDAO = DAOFactory.criarServidorDAO();
		return sDAO.buscarPorNome(nome, inicio, fim);
	}

	public static String converterLocalDateParaString(LocalDate localDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		return localDate.format(formatter);
	}
	public static LocalDate converterStringParaLocalDate(String data) {

		String[] newDate = data.split("/");
		String[] dataSql = data.split("-");
		if (newDate.length == 3) {
			return LocalDate.of(Integer.valueOf(newDate[2]), Integer.valueOf(newDate[1]), Integer.valueOf(newDate[0]));
		}
		if (dataSql.length == 3) {
			return LocalDate.of(Integer.valueOf(dataSql[0]), Integer.valueOf(dataSql[1]), Integer.valueOf(dataSql[2]));
		} else {
			throw new RuntimeException(
					"Erro: A data de nascimento não está no formato correto, valor informado " + data);
		}

	}
	public static List<Modulo> buscarModulosAssociados(Pessoa pessoa, int perfil){
		ModuloDAO mDao = DAOFactory.criarModuloDAO();
		List<Modulo> modulosPerfil = mDao.buscarPorPerfil(perfil);
		List<Modulo> modulosAssociados = mDao.buscar(pessoa);
		List<Modulo> modulosDesassociados = mDao.listarDisponiveisParaPessoa(pessoa);
		List<Modulo> modulosFinais = mDao.buscar(pessoa);
		List<Modulo> modulosARemover = new ArrayList<Modulo>();
		boolean has;
		for(Modulo m:modulosPerfil){
			has = false;
			for(Modulo m2: modulosAssociados){
				if(m2.getId() == m.getId()){
					has = true;
				}
			}
			if(!has){
				modulosFinais.add(m);
			}
		}
		
		for(Modulo m:modulosDesassociados){
			for(Modulo m2: modulosFinais){
				if(m2.getId() == m.getId()){
					modulosARemover.add(m2);
				}
			}
		}
		for(Modulo m:modulosARemover) {
			modulosFinais.remove(m);
		}
		
		return modulosFinais;
	}
	
	public static int getQuantidadeModulo() {
		return buscarTodosModulos().size();		
	}
	public static int getQuantidadeModulo(String nomeModulo, int inicio, int fim) {
		ModuloDAO mDao = DAOFactory.criarModuloDAO();
		mDao.buscarPorNome(nomeModulo, inicio, fim);
		return buscarTodosModulos().size();		
	}
	public static void editarModulo(Modulo m) {
		ModuloDAO mDao = DAOFactory.criarModuloDAO();
		mDao.editar(m);
	}
	
	public static boolean validarPreCadastroAluno(String dados) {
		boolean estado = true;
		String aux, matricula, nome;
	       while(!dados.equals("")){
	    	   aux = dados.substring(0,dados.indexOf("\n"));
	    	   if (aux.length() <= 6) {
	    		   estado = false;
	    		   break;}
	                matricula = dados.substring(0,6);
	               if (matricula.matches("[0-9]+")){
	                   nome = dados.substring(6,dados.indexOf("\n")).toUpperCase().trim();
	                   if( util.TesteRegex.testar(nome)){
	                	aux += "\n";   
	                	dados = dados.replace(aux, "");
	                   }else {
	                	   estado = false;
	                	   break;
	                   }
	               }else{
	                   estado = false;
	                   break;
	               }
				}
	     return estado;
	}	
}
