package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Modulo;
import model.Pessoa;
import util.Constantes;
import util.DAOFactory;

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
		RequestDispatcher rd = request.getRequestDispatcher("modulosDePessoa.jsp");
		Integer pessoa_id = Integer.valueOf(request.getParameter("pessoa_id"));
		Pessoa pessoa = DAOFactory.criarPessoaDAO().buscarPorId(pessoa_id);
		request.setAttribute("modulosAssociados", DAOFactory.criarModuloDAO().listarAssociadosParaPessoa(pessoa));
		request.setAttribute("modulosDisponiveis", DAOFactory.criarModuloDAO().listarDisponiveisParaPessoa(pessoa));
		request.setAttribute("pessoa", DAOFactory.criarPessoaDAO().buscarPorId(pessoa_id));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
