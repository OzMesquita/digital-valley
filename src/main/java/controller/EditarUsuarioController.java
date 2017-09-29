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

public class EditarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String dataNasc = request.getParameter("nascimento");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String cSenha = request.getParameter("cSenha");
		String pagina = "editarUsuario.jsp?erroEditar=1";
		HttpSession session = request.getSession();

		if (senha.equals(cSenha)) {
			try {
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				Pessoa pessoa = usuario.getPessoa();
				pessoa.setCpf(cpf);
				pessoa.setDataNascimento(dataNasc);
				pessoa.setEmail(email);
				usuario.setLogin(login);
				usuario.setSenha(senha);
				util.Facade.editarPessoa(pessoa, usuario);
				pagina = "telaInicial.jsp?sucessoEditar=1";
			} catch (Exception e) {
				System.out.println(e.getMessage());
				session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
			}

		}else{
			pagina+= "&erroSenha=1";
		}
		response.sendRedirect(pagina);
		

	}

}
