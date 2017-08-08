package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig
public class ImportacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int curso = Integer.valueOf(request.getParameter("curso"));
		String dados = request.getParameter("matriculas");
		String nome, matricula;
		String aux;
		String pagina;
		HttpSession session = request.getSession();
		try {

			while(dados.length() >=6){
				
				matricula = dados.substring(0,6);
				nome = dados.substring(6,dados.indexOf("\n"));
				System.out.println("CAdastrado :"+matricula+" "+nome);
				util.Facade.preCadastrarAluno(nome, matricula, curso);
				aux = dados.replace(matricula, "");
				dados = aux;
				aux = dados.replace(nome+"\n", "");
				dados = aux;
				System.out.println("inicioAUx"+aux);
				
			}
			pagina = "importarMatriculas.jsp?sucesso=1";
			
		} catch (Exception e) {
			session.setAttribute("excecao", e.getMessage());
			pagina = "importarMatriculas.jsp?erro=1";
		}		
		
		response.sendRedirect(pagina);
	}
}
