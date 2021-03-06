package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import model.Pessoa;
import util.Constantes;
import util.Facade;

/**
 * Servlet implementation class ModulosDePessoa
 */
public class ModulosDePessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModulosDePessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try{
		RequestDispatcher rd = request.getRequestDispatcher("modulosDePessoa.jsp");
		Integer pessoa_id = Integer.valueOf(request.getParameter("pessoa_id"));
		Pessoa pessoa = DAOFactory.criarPessoaDAO().buscarPorId(pessoa_id);
		request.setAttribute("modulosAssociados", Facade.buscarModulosAssociados(pessoa, Integer.valueOf(request.getParameter("perfil_id"))));
		request.setAttribute("modulosDisponiveis", DAOFactory.criarModuloDAO().listar());
		request.setAttribute("pessoa", DAOFactory.criarPessoaDAO().buscarPorId(pessoa_id));
		rd.forward(request, response);
		}catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}
		
	}

}
