package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Constantes;
import util.Facade;

public class ImportarServidorController  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String siape = request.getParameter("siape");
		HttpSession session = request.getSession();
		String pagina = "importarServidores.jsp?erroPreCadastro=1";
		
		
		try {
			
			Facade.preCadastroServidor(nome.replaceAll("\\s+$", "").toUpperCase(), siape);
			pagina = "importarServidores.jsp?sucessoPrecadastro=1";
			session.setAttribute(Constantes.getSessionMsg(), "Sucesso ao cadastrar servidor(a)!");
			
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsgError(), "Erro ao cadastrar servidor(a)! \n"+e.getMessage());
			
		}
		
		response.sendRedirect(pagina);
		
	}

}
