package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Facade;

public class VerificarCadastro  {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String pagina = "verificacaoCadastro.jsp?erroVerificacao=1";
		
		try {
			if(Facade.verificacao(matricula, nome)){
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
