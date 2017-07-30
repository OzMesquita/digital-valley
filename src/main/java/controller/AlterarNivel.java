package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Modulo;

import model.Usuario;
import util.Facade;

public class AlterarNivel extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Usuario usuarioSelecionado = (Usuario)session.getAttribute("usuarioSelecionado");
		String[] modulosAdicionados = request.getParameterValues("modulosCadadastrados");
		
		Vector<Modulo> modulosCadadastrados = new Vector();
		
		
	}

}
