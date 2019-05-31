package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import util.Constantes;
import util.Crypter;
import util.Facade;

/**
 * Servlet implementation class AlterarSenha
 */
public class AlterarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pagina = "recuperarSenha.jsp?erroEditar=1";
			String sessionMsg = "";
			try {
				String senhaRepetida = request.getParameter("senha_repetida");
				String senhaNova = request.getParameter("senha");
				Usuario usuarioDaSessao = (Usuario) session.getAttribute("usuario");
				if (senhaNova == null || senhaNova.isEmpty()) {
					sessionMsg = "Erro: Digite sua nova senha!";
				} else if (senhaRepetida == null || senhaRepetida.isEmpty()) {
					sessionMsg = "Erro: Digite sua nova senha novamente!";
				}  else if (!senhaNova.equalsIgnoreCase(senhaRepetida)) {
					sessionMsg = "Erro: Campo cofirmar senha não bate com nova senha!";
				} else {
					usuarioDaSessao.setSenha(senhaRepetida);
					Facade.editarUsuarioESenha(usuarioDaSessao.getPessoa(), usuarioDaSessao);
					session.setAttribute("usuario", null);
				}

				if(sessionMsg.isEmpty()) {
					pagina =Constantes.getAppUrl();
					sessionMsg = "Senha alterada com sucesso!";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				sessionMsg += e.getMessage();
			}
			session.setAttribute(Constantes.getSessionMsg(), sessionMsg);
			response.sendRedirect(pagina);
	}	
	

}
