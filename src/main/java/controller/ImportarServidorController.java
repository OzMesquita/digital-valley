package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Facade;

public class ImportarServidorController  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String siape = request.getParameter("siape");
		HttpSession session = request.getSession();
		String pagina = "importarSevidores.jsp?erroPreCadastro=1";
		
		try {
			
			Facade.preCadastroServidor(nome, siape);
			pagina = "importarSevidores.jsp?sucessoPrecadastro=1";
			
			
		} catch (Exception e) {
			session.setAttribute("msg", e.getMessage());
		}
		
		response.sendRedirect(pagina);
		
	}

}
