package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Constantes;
import util.Facade;

@MultipartConfig
public class ImportacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int curso = Integer.valueOf(request.getParameter("curso"));
		String dados = request.getParameter("matriculas");
		dados = dados + "\n";
		String nome, matricula;
		String aux;
		String pagina;
		pagina = "importarAlunos.jsp?erro=1";
		
		HttpSession session = request.getSession();
		
		try {
			if (curso==0) {
				throw new RuntimeException("Curso não selecionado!");
			}
			if (util.Facade.validarPreCadastroAluno(dados)) {
				while(dados.length() >=6){
					matricula = dados.substring(0,6);
					nome = dados.substring(6,dados.indexOf("\n"));
					util.Facade.preCadastrarAluno(nome.replaceAll("\\s+$", "").toUpperCase(), matricula, curso);
					aux = dados.replace(matricula, "");
					dados = aux;
					aux = dados.replace(nome+"\n", "");
					dados = aux;
				}
			}else {
				throw new Exception("Os dados informados não são válidos.\n Por favor verifique as informações e tente novamente!");
			}	
			pagina = "importarAlunos.jsp?sucesso=1";
			session.setAttribute(Constantes.getSessionMsg(), "Pré cadastro do(s) aluno(s) realizado com sucesso!");
			
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsgError(), e.getMessage());	
			session.setAttribute("matriculas",request.getParameter("matriculas"));
			session.setAttribute("curso",curso);
		}		
		
		response.sendRedirect(pagina);
	}
}
