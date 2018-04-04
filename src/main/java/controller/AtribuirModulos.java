package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.PessoaDAO;
import model.EnumNivel;
import util.Constantes;


public class AtribuirModulos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		try {
			// paginacao de pessoas
			Integer paginaAtual = request.getParameter("pagina") != null ? Integer.valueOf(request.getParameter("pagina"))
					: 1;
			Integer fim = Constantes.getNumberOfRowsPerPage() * paginaAtual;
			Integer inicio = fim - Constantes.getNumberOfRowsPerPage();
			// pegar dados de pessoas
			String nomePessoa = request.getParameter("nome") != null ? (String) request.getParameter("nome") : "";
			Integer nivelAluno = EnumNivel.COMUM.getValorNivel();
			PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();			
			// enviar dados
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("atribuicaoDeModulos.jsp");
			request.setAttribute("url", Constantes.getAdmUrl());
			request.setAttribute("pessoas", pessoaDAO.buscarPorNomeENivel(nomePessoa, nivelAluno, inicio, fim));
			request.setAttribute("perfis", DAOFactory.criarPerfilDAO().Listar());
			request.setAttribute("quantidadeDePaginas", (pessoaDAO.getQuantidadePorNomeENivel(nomePessoa, nivelAluno)+(fim-inicio-1)) /  (fim - inicio));
			request.setAttribute("paginaAtual", paginaAtual);
			request.setAttribute("nomePessoa", nomePessoa);
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}

	}

}
