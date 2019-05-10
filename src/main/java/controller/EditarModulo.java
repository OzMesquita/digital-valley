package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Modulo;
import util.Constantes;

public class EditarModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("url");
		String descricao = request.getParameter("descricao");
		int idModulo = Integer.valueOf(request.getParameter("idModulo"));
		String pagina = "editarModulo.jsp?idModulo="+idModulo;
		HttpSession session = request.getSession();

		try {
			Modulo modulo = util.Facade.buscarModulosPorId(idModulo);
			modulo.setUrl(url);
			modulo.setDescricao(descricao);
			util.Facade.editarModulo(modulo);
			pagina = util.Constantes.getAdmUrl()+"/listar_modulos?sucessoEditar=1&idUsuario="+idModulo;
			session.setAttribute(Constantes.getSessionMsg(), "Módulo editado com sucesso!");
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsgError(), e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}