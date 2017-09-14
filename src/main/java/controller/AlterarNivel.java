package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pessoa;
import model.Usuario;

public class AlterarNivel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer nivel= Integer.valueOf(request.getParameter("nivel"));
		String pagina = "/Controle_de_Acesso/view/adm/editarNivelDoUsuario.jsp";
		HttpSession session = request.getSession();

		try {
			
			Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
			Usuario usuario = pessoa.getUsuario();
			usuario.setNivel(nivel);
			util.Facade.editarPessoa(pessoa, usuario);
			pagina = "/Controle_de_Acesso/view/adm/editarNivelDoUsuario.jsp?sucessoEditar=1";
			session.setAttribute("msg" ,"Alterado com sucesso");
		} catch (Exception e) {
			session.setAttribute("msg", e.getMessage());
		}

		
		response.sendRedirect(pagina);
		

	}

}