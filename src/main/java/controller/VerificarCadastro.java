package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Facade;

public class VerificarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String pagina = "verificacaoCadastro.jsp?erroVerificacao=1";
		HttpSession session = request.getSession();
		System.out.println("servlet");
		try {
			System.out.println("Entrou IF");
			if(Facade.verificacao(matricula, nome)){
				pagina = "/Controle_de_Acesso/cadastro/cadastraAluno.jsp";
				session.setAttribute("cadastro", "ok");
				System.out.println("sucesso");
			}
		} catch (Exception e) {
			session.setAttribute("excecao", e.getMessage());
			System.out.println("excecao : "+e.getMessage());
		}
		
		response.sendRedirect(pagina);
		
		
	}

}
