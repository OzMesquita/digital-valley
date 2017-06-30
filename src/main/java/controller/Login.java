package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import model.Modulo;
import model.Usuario;
import util.DAOFactory;
import util.Facade;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
				List<Modulo> modulos = Facade.buscarModulosPorPessas(usuario.getPessoa());
				session.setAttribute("usuario", usuario);
				session.setAttribute("modulos", modulos);
				pagina = "view/telaInicial.jsp";	
				
			}
		
			
		} catch (Exception e) {
			session.setAttribute("msg","Usuários e/ou senha inválidos");
			session.setAttribute("excecao",e.getMessage());
			
		}
			response.sendRedirect(pagina);
	}

}
