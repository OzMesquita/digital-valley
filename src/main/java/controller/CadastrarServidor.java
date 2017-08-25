package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Servidor;
import model.Usuario;
import util.Facade;

public class CadastrarServidor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String aux = cpf.replaceAll("-", "");
		cpf = aux.replaceAll("[.]", "");
		String email = request.getParameter("email");
		String dataNasci = request.getParameter("nascimento");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		HttpSession session = request.getSession();

		String pagina = "cadastrarUsuario.jsp?erroCadastro=1";
		try {
			if (senha.equals(senha2)) {
				Servidor servidor = new Servidor();
				Usuario usuario = new Usuario();
				servidor.setNome(nome);
				servidor.setCpf(cpf);
				servidor.setEmail(email);
				servidor.setDataNascimento(dataNasci);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				servidor.setUsuario(usuario);
				usuario.setPessoa(servidor);

				Facade.cadastrarServidor(usuario, servidor);

				pagina = "login.jsp";
			}else{
				pagina = "cadastrarUsuario.jsp?erroSenha=1";
			}

		} catch (Exception e) {
			session.setAttribute("excecao", e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}