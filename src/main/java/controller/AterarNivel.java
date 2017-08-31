package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pessoa;
import model.Usuario;

public class AterarNivel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer nivel= Integer.valueOf(request.getParameter("nivel"));
		String pagina = "editarNivel.jsp";
		HttpSession session = request.getSession();

		try {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			Pessoa pessoa = usuario.getPessoa();
			usuario.setNivel(nivel);
			util.Facade.editarPessoa(pessoa, usuario);
			pagina = "editarNivel.jsp?sucessoEditar=1";
			session.setAttribute("msg" ,"Alterado com sucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.setAttribute("msg", e.getMessage());
		}

		
		response.sendRedirect(pagina);
		

	}

}