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
 * Servlet implementation class AssociarModulo
 */
public class AssociarModuloPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssociarModuloPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer  pessoaId = Integer.valueOf(request.getParameter("pessoa_id"));
		Integer  moduloId = Integer.valueOf(request.getParameter("modulo_id"));
		Integer  perfilId = Integer.valueOf(request.getParameter("perfil_id"));
		HttpSession session = request.getSession();
		try {
			DAOFactory.criarModuloDAO().associarUsuarioModulo(pessoaId, moduloId);
			
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}
		
		response.sendRedirect(Constantes.getAdmUrl()+"/pessoa_modulos?pessoa_id="+pessoaId+"&perfil_id="+perfilId);
	}

}
