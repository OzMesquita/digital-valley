package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class AlterarSenhaUsuario
 */
public class AlterarSenhaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarSenhaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pagina = "view/editarUsuario.jsp?erroEditar=1";
			String sessionMsg = "";
			try {
				
				String senhaAntiga = request.getParameter("senha_antiga");
				String senhaRepetida = request.getParameter("senha_repetida");
				String senhaNova = request.getParameter("senha");
				Usuario usuarioDaSessao = (Usuario) session.getAttribute("usuario");
				if (senhaAntiga == null || senhaAntiga.isEmpty()) {
					sessionMsg = "Erro: Digite sua senha atual!";
				} else if (senhaNova == null || senhaNova.isEmpty()) {
					sessionMsg = "Erro: Digite sua nova senha!";
				} else if (senhaRepetida == null || senhaRepetida.isEmpty()) {
					sessionMsg = "Erro: Digite sua nova senha novamente!";
				}  else if (!usuarioDaSessao.getSenha().equals((Crypter.crypt(senhaAntiga)))) {
					sessionMsg = "Erro: Senha atual incorreta!";
				}   else if (!senhaNova.equalsIgnoreCase(senhaRepetida)) {
					sessionMsg = "Erro: Campo cofirmar senha não bate com nova senha!";
				} else {
					usuarioDaSessao.setSenha(senhaRepetida);
					Facade.editarUsuarioESenha(usuarioDaSessao.getPessoa(), usuarioDaSessao);
					session.setAttribute("usuario", usuarioDaSessao);
				}

				if(sessionMsg.isEmpty()) {
					pagina = "view/editarUsuario.jsp?sucessoEditar=1";
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
