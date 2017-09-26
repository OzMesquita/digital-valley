package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constantes;
import util.DAOFactory;

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
		DAOFactory.criarModuloDAO().associarUsuarioModulo(pessoaId, moduloId);
		response.sendRedirect(Constantes.ADM_URL+"/pessoa_modulos?pessoa_id="+pessoaId);
	}

}
