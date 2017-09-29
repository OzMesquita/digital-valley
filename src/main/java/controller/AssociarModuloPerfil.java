package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import util.Constantes;

/**
 * Servlet implementation class AssociarModuloPerfil
 */
public class AssociarModuloPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer perfilId = Integer.valueOf(request.getParameter("perfil_id"));
		Integer moduloId = Integer.valueOf(request.getParameter("modulo_id"));
		HttpSession session = request.getSession();
		try {
			DAOFactory.criarModuloDAO().associarPerfilModulo(perfilId, moduloId);
			
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}
		
		response.sendRedirect(Constantes.getAdmUrl()+"/perfil_modulos?perfil_id="+perfilId);
	}

}
