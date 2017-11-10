package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.UsuarioDAO;
import model.Modulo;
import model.Usuario;
import util.Constantes;
import util.Facade;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String pagina = "login.jsp?erroLogin=1";
		HttpSession session = request.getSession();
		
		try {
			UsuarioDAO uDAO = DAOFactory.criarUsuarioDAO();
			if(uDAO.autenticar(login, senha)){
				Usuario usuario = Facade.buscarPorLogin(login);
				List<Modulo> modulos = Facade.buscarTodosModulosPorPerfil(usuario.getPessoa());
				
				session.setAttribute("usuario", usuario);
				session.setAttribute("modulos", modulos);
				pagina = "view/telaInicial.jsp";
				uDAO = DAOFactory.criarUsuarioDAO();
				uDAO.salvarToken(Facade.buildToken(), usuario.getPessoa().getId());				
			}else{
				session.setAttribute(Constantes.getSessionMsg(),"Usuários e/ou senha inválidos");
			}
			
			
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(),"Usuários e/ou senha inválidos");
			
			
		}
			response.sendRedirect(pagina);
	}
}
