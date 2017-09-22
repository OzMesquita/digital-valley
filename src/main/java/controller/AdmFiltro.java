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
import model.EnumNivel;
import model.Usuario;
import util.DAOFactory;

public class AdmFiltro implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = (HttpSession) (((HttpServletRequest)request).getSession());
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		String token = "";
		
		if(usuario !=null){
			PessoaDAO pDAO = DAOFactory.criarPessoaDAO();
			token = pDAO.buscarTokenRecuperacao(usuario.getPessoa());
		}
		
		if (!token.equals("")) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("/Controle_de_Acesso/login.jsp?permisaoRecuperacao=1");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
