package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import model.Modulo;
import util.Constantes;

public class ExcluirModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("url");
		int idModulo = Integer.valueOf(request.getParameter("idModulo"));
		String pagina = "editarModulo.jsp?idModulo="+idModulo;
		HttpSession session = request.getSession();

		try {
			Modulo modulo = util.Facade.buscarModulosPorId(idModulo);
			DAOFactory.criarModuloDAO().remover(modulo.getId());
			pagina = util.Constantes.getAdmUrl()+"/listar_modulos?sucessoRemover=1&idModulo="+idModulo;
			session.setAttribute(Constantes.getSessionMsg(), "Módulo removido com sucesso!");
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsgError(), e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}