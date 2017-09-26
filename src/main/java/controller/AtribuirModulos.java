package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDAO;
import model.EnumNivel;
import model.Pessoa;
import util.Constantes;
import util.DAOFactory;

/**
 * Servlet implementation class AtribuirModulos
 */
public class AtribuirModulos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// paginacao
		Integer paginaAtual = request.getParameter("pagina") != null ? Integer.valueOf(request.getParameter("pagina"))
				: 1;
		Integer fim = Constantes.NUMBER_OF_ROWS_PER_PAGE * paginaAtual;
		Integer inicio = fim - Constantes.NUMBER_OF_ROWS_PER_PAGE;
		Integer quantidadePorPagina = fim - inicio;
		// pegar dados
		String nomePessoa = (String) request.getParameter("nome");
		Integer nivelComum = EnumNivel.COMUM.getValorNivel();
		String url = Constantes.ADM_URL;
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		Integer quantidadeDePessoasDeNivelComum;
		List<Pessoa> pessoas;
		// se pesquisa foi feita
		if (nomePessoa != null) {
			quantidadeDePessoasDeNivelComum = pessoaDAO.getQuantidadePorNomeENivel(nomePessoa, nivelComum);
			pessoaDAO = DAOFactory.criarPessoaDAO();
			pessoas = pessoaDAO.buscarPorNomeENivel(nomePessoa, nivelComum, inicio, fim);
		} else {
			quantidadeDePessoasDeNivelComum = pessoaDAO.getQuantidadePorNivel(nivelComum);
			pessoaDAO = DAOFactory.criarPessoaDAO();
			pessoas = pessoaDAO.buscarPorNivel(nivelComum, inicio, fim);
		}
		// listagem
		pessoaDAO = DAOFactory.criarPessoaDAO();
		// enviar dados
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("atribuicaoDeModulos.jsp");
		request.setAttribute("url", url);
		request.setAttribute("pessoas", pessoas);
		request.setAttribute("quantidadeDePaginas", quantidadeDePessoasDeNivelComum / quantidadePorPagina);
		request.setAttribute("paginaAtual", paginaAtual);
		requestDispatcher.forward(request, response);
	}

}
