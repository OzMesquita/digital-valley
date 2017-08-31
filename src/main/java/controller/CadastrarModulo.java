package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Modulo;
import util.Facade;

public class CadastrarModulo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String url = request.getParameter("url");
		String imagem = request.getParameter("imagem");
		String aluno = request.getParameter("aluno");
		String professor = request.getParameter("professor");
		String secretario = request.getParameter("secretario");
		String funcionario = request.getParameter("funcionario");
		
		
		String pagina = "cadastarModulo.jsp?erroCadastro=1";
		try {
				
			Modulo modulo = new Modulo();
			
			modulo.setImagem(imagem);
			modulo.setTitulo(titulo);
			modulo.setUrl(url);
			
			Facade.cadastrarModulo(modulo);
			pagina = "cadastarModulo.jsp?sucessoCadastro=1";
			
		} catch (Exception e) {
			
		}
		response.sendRedirect(pagina);
	}

}