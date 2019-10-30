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
import util.Facade;


public class ListarModulos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// paginacao de pessoas
			Integer paginaAtual = request.getParameter("pagina") != null
					? Integer.valueOf(request.getParameter("pagina"))
					: 1;
			Integer fim = Constantes.getNumberOfRowsPerPage() * paginaAtual;
			Integer inicio = fim - Constantes.getNumberOfRowsPerPage();
			Integer quantidadePorPagina = fim - inicio;
			Integer quantidadeDeModulos = null;
			// pegar dados de pessoas
			String nomeModulo = request.getParameter("nome") != null ? (String) request.getParameter("nome") : "";
			
			List<Modulo> modulos = null;
			
			if (nomeModulo.equals("")) {
				quantidadeDeModulos = Facade.getQuantidadeModulo();
				modulos = Facade.buscarTodosModulos();
			}else {
				quantidadeDeModulos=Facade.getQuantidadeModulo(nomeModulo,inicio,fim);
				modulos = Facade.buscarPorNome(nomeModulo, inicio, fim);
			}				
				
			// enviar dados
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaDeModulos.jsp");
			request.setAttribute("url", Constantes.getAdmUrl());
			request.setAttribute("modulos", modulos);
			request.setAttribute("quantidadeDePaginas", (quantidadeDeModulos+(quantidadePorPagina-1)) / quantidadePorPagina);
			request.setAttribute("paginaAtual", paginaAtual);
			request.setAttribute("nome", nomeModulo);
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}
	}

}
