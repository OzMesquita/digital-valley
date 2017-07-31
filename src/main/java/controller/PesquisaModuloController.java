package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PesquisaModuloController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busca = request.getParameter("busca");
		HttpSession session = request.getSession();
		
		switch(busca){
			case "Aluno":{
				session.setAttribute("busca", util.Facade.buscarAlunos());
			}
		
		}
		
		response.sendRedirect("TelaADM.jsp");
		
	}

}
