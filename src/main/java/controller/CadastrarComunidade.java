package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pessoa;
import model.Usuario;
import util.Constantes;
import util.Facade;

public class CadastrarComunidade extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		nome = nome.toUpperCase();
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
				Pessoa pessoa = new Pessoa();
				Usuario usuario = new Usuario();
				
				pessoa.setNome(nome);
				pessoa.setCpf(cpf);
				pessoa.setEmail(email);
				pessoa.setDataNascimento(dataNasci);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				pessoa.setUsuario(usuario);
				usuario.setPessoa(pessoa);

				Facade.cadastrarPessoa(pessoa, usuario);
				session.setAttribute(Constantes.getSessionMsg(), "Sucesso ao Cadadastrar Comunidade "+pessoa.getNome());
				session.setAttribute("nomeA", null);
				session.setAttribute("nomeS", null);
				
				pagina = "/login.jsp";
			}else{
				pagina = "cadastrarUsuario.jsp?erroSenha=1";
			}

		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}