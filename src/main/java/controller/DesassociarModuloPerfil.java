package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import util.Constantes;

/**
 * Servlet implementation class DesassociarModuloPerfil
 */
public class DesassociarModuloPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer perfilId = Integer.valueOf(request.getParameter("perfil_id"));
		Integer moduloId = Integer.valueOf(request.getParameter("modulo_id"));
		DAOFactory.criarModuloDAO().desassociarPerfilModulo(perfilId, moduloId);
		response.sendRedirect(Constantes.ADM_URL+"/perfil_modulos?perfil_id="+perfilId);
	}

}
