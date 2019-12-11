package controller;


import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import dao.DAOFactory;
import model.Modulo;
import model.Perfil;
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
			List<Perfil> perfis = DAOFactory.criarModuloDAO().getPerfisAssociados(idModulo);
			for(Perfil perfil : perfis) {
				DAOFactory.criarModuloDAO().desassociarPerfilModulo(perfil.getId(), modulo.getId());
			}	
			DAOFactory.criarModuloDAO().remover(modulo.getId());
			if (modulo.getImagem() != null && !modulo.getImagem().contentEquals("") ) {
				new File(Constantes.getUSER_PROFILE_IMAGES_DIR() + modulo.getImagem()).delete();
			}
			pagina = util.Constantes.getAdmUrl()+"/listar_modulos?sucessoRemover=1&idModulo="+idModulo;
			session.setAttribute(Constantes.getSessionMsg(), "Módulo removido com sucesso!");
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsgError(), e.getMessage());
		}
		response.sendRedirect(pagina);
	}

}