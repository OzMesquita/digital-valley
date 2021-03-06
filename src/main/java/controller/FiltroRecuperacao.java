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
import model.Aluno;
import model.Pessoa;
import model.Servidor;
import util.Constantes;
import util.Facade;


public class FiltroRecuperacao implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = (HttpSession) (((HttpServletRequest) request).getSession());
		
		
		String token = request.getParameter("token");
		Pessoa pessoa = Facade.verificarTokenRecuperacao(token);
		Aluno aluno = null;
		Servidor servidor = null;

		
		if (pessoa instanceof Aluno){
			aluno = (Aluno) pessoa;
		}else{
			servidor = (Servidor) pessoa;
		}

		if (pessoa != null){
			if(aluno != null){
				session.setAttribute("matricula", aluno.getMatricula());
				chain.doFilter(request, response);
				
			}
			if(servidor != null){
				session.setAttribute("siape", servidor.getSiape());
				chain.doFilter(request, response);
			}
		} else {
			((HttpServletResponse) response).sendRedirect(Constantes.getAppUrl()+"/login.jsp?recuperacao=1");
			
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
