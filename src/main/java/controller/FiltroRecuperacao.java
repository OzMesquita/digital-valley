package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PessoaDAO;
import model.Pessoa;
import util.DAOFactory;

public class FiltroRecuperacao implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = (HttpSession) (((HttpServletRequest) request).getSession());
		Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
		PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
		String token = pDAO.buscarTokenRecuperacao(pessoa);

		if (token != null) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("/Controle_de_Acesso/login.jsp?permisaoPreCadastro=1");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
