package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Usuario;
import util.Facade;

public class CadastrarAluno extends HttpServlet {

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

		String pagina = "cadastraAluno.jsp?erroCadastro=1";
		try {
			if (senha.equals(senha2)) {
				Aluno aluno = new Aluno();
				Usuario usuario = new Usuario();
				aluno.setNome(nome);
	
				aluno.setCpf(cpf);
				aluno.setEmail(email);
				aluno.setDataNascimento(dataNasci);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				aluno.setUsuario(usuario);
				usuario.setPessoa(aluno);
				

				Facade.cadastrarPessoa(aluno, usuario);

				pagina = "login.jsp";
			}

			
		} catch (Exception e) {
			session.setAttribute("exececao", e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}