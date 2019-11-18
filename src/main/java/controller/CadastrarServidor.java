package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EnumCargo;
import model.EnumPerfil;
import model.Servidor;
import model.Usuario;
import util.Constantes;
import util.Crypter;
import util.Facade;

public class CadastrarServidor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		nome = nome.toUpperCase();
		String cpf = request.getParameter("cpf");
		String aux = cpf.replaceAll("-", "");
		cpf = aux.replaceAll("[.]", "");
		String email = request.getParameter("email");
		String codigo = request.getParameter("codigo");
		String dataNasci = request.getParameter("nascimento");
		String login = "    "; /*request.getParameter("login");*/
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		HttpSession session = request.getSession();
		String cargo = request.getParameter("cargo");
		
		String pagina = "cadastrarUsuario.jsp?erroCadastro=1";
		try {
			if (Facade.verificarCPF(cpf)) {
				pagina = "cadastrarUsuario.jsp?erroSenha=1";
				session.setAttribute(Constantes.getSessionMsgError(), "CPF já cadastrado.");
			}
			if (senha.equals(senha2) && !Facade.verificarCPF(cpf)) {// mudei coloquei !Facade.verificarCPF(cpf)
				Servidor servidor = new Servidor();
				Usuario usuario = new Usuario();
				
				servidor.setNome(nome);
				servidor.setCpf(cpf);
				servidor.setSiape(codigo);
				servidor.setEmail(email);
				servidor.setDataNascimento(dataNasci);
				servidor.setCargo(EnumCargo.getByString(cargo));
				usuario.setLogin(login);
				usuario.setSenha(Crypter.crypt(senha));
				servidor.setUsuario(usuario);
				usuario.setPessoa(servidor);
				usuario.setPerfil(EnumPerfil.SERVIDOR);

				Facade.cadastrarServidor(usuario, servidor);
				session.setAttribute(Constantes.getSessionMsg(), "Sucesso ao Cadadastrar Servidor(a) "+servidor.getNome());
				session.setAttribute("nomeA", null);
				session.setAttribute("nomeS", null);
				session.setAttribute("matricula", null);
				session.setAttribute("siape", null);
				pagina = "../login.jsp";
			}else if(!senha.equals(senha2)){
				session.setAttribute(Constantes.getSessionMsgError(), "Erro: senhas não conferem.");
				pagina = "cadastrarUsuario.jsp?erroSenha=1";
			}

		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsgError(), e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}