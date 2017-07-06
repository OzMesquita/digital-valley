package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pessoa;
import model.Usuario;
import util.Facade;

public class CadastrarUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String dataNasci = request.getParameter("dataNasci");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		HttpSession session = request.getSession();

		String pagina = "cadastraUsuario.jsp?erroCadastro=1";
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

				pagina = "login.jsp";
			}

			
		} catch (Exception e) {
			session.setAttribute("exececao", e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}
