package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;
import util.Constantes;
import util.Facade;


public class ListarUsuarios extends HttpServlet {
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
			Integer quantidadeDePessoas = null;
			// pegar dados de pessoas
			String nomePessoa = request.getParameter("nome") != null ? (String) request.getParameter("nome") : "";
			String tipo = (String) request.getParameter("tipo");
			List<Pessoa> pessoas = null;
			if (tipo == null) {
				tipo = "todos";
			}
			if (tipo.equals("todos")) {				
				quantidadeDePessoas = Facade.getQuantidadePessoasPorNome(nomePessoa);
				pessoas = Facade.buscarPessoasPorNome(nomePessoa, inicio, fim);
			}else if (tipo.equals("alunos")){
				quantidadeDePessoas = Facade.getQuantidadeAlunosPorNome(nomePessoa);
				pessoas =  (List<Pessoa>)(List<?>)  Facade.buscarAlunosPorNome(nomePessoa, inicio, fim);
			}else{
				quantidadeDePessoas = Facade.getQuantidadeServidoresPorNome(nomePessoa);
				pessoas =  (List<Pessoa>)(List<?>)  Facade.buscarServidoresPorNome(nomePessoa, inicio, fim);
			}			
			// enviar dados
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaDeUsuarios.jsp");
			request.setAttribute("url", Constantes.getAdmUrl());
			request.setAttribute("pessoas", pessoas);
			request.setAttribute("quantidadeDePaginas", (quantidadeDePessoas+(quantidadePorPagina-1)) / quantidadePorPagina);
			request.setAttribute("paginaAtual", paginaAtual);
			request.setAttribute("nome", nomePessoa);
			request.setAttribute("tipo", tipo);
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}
	}

}
