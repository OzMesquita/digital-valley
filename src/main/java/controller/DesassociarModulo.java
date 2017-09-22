package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constantes;
import util.DAOFactory;

/**
 * Servlet implementation class DesassociarModulo
 */
public class DesassociarModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer  pessoaId = Integer.valueOf(request.getParameter("pessoa_id"));
		Integer  moduloId = Integer.valueOf(request.getParameter("modulo_id"));
		DAOFactory.criarModuloDAO().desassociarUsuarioModulo(pessoaId, moduloId);
		response.sendRedirect(Constantes.ADM_URL+"/pessoa_modulos?pessoa_id="+pessoaId);
	}

}
