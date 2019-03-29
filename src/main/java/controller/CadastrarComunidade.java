package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EnumNivel;
import model.EnumPerfil;
import model.Pessoa;
import model.Usuario;
import util.Constantes;
import util.Crypter;
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
		String login = " "; /*request.getParameter("login");*/
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		HttpSession session = request.getSession();
		
		String pagina = "cadastrarVisitante.jsp?erroCadastro=1";
		try {
			if (Facade.verificarCPF(cpf)) {
				pagina = "cadastrarUsuario.jsp?erroSenha=1";
				session.setAttribute(Constantes.getSessionMsgError(), "Usuário já cadastrado.");
			}
			if (senha.equals(senha2)) {
				Pessoa pessoa = new Pessoa();
				Usuario usuario = new Usuario();
				
				pessoa.setNome(nome);
				pessoa.setCpf(cpf);
				pessoa.setEmail(email);
				pessoa.setDataNascimento(dataNasci);
				usuario.setLogin(login);
				usuario.setSenha(Crypter.crypt(senha));
				pessoa.setUsuario(usuario);
				usuario.setPessoa(pessoa);
				usuario.setNivel(EnumNivel.COMUM);
				usuario.setPerfil(EnumPerfil.VISITANTE);

				Facade.cadastrarPessoa(pessoa, usuario);
				session.setAttribute(Constantes.getSessionMsg(), "Sucesso ao Cadadastrar Comunidade "+pessoa.getNome());

				
				pagina = "login.jsp";
			}else{
				pagina = "cadastrarVisitante.jsp?erroSenha=1";
			}

		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsgError(), e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}