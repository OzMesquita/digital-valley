package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.Perfil;
import util.Constantes;

/**
 * Servlet implementation class ModulosDePerfil
 */
public class ModulosDePerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Perfil perfil = DAOFactory.criarPerfilDAO().buscarPorId(Integer.valueOf(request.getParameter("perfil_id")));
		request.setAttribute("modulosDoPerfil", DAOFactory.criarModuloDAO().getModulosDePerfil(perfil));
		request.setAttribute("modulos", DAOFactory.criarModuloDAO().getModulosDisponiveisParaPerfil(perfil));
		request.setAttribute("perfil", perfil);
		request.setAttribute("url", Constantes.ADM_URL); 
		request.getRequestDispatcher("modulosDePerfil.jsp").forward(request, response);
	}

}
