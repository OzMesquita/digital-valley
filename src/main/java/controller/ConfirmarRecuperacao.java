package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import util.Facade;

/**
 * Servlet implementation class ConfirmarRecuperacao
 */
public class ConfirmarRecuperacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarRecuperacao() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String matricula = request.getParameter("matricula");
            String cpf = request.getParameter("cpf");
            
            if(cpf!= null){
                Usuario usuario;;
                usuario = Facade.buscarPorMatriculaAndCPF(matricula,cpf);
                request.getSession().setAttribute("usuario",usuario);
                response.sendRedirect("editarUsuario.jsp");
                    
            }else{
            	request.getSession().setAttribute("msg","CPF não pode ser vazio.");
                
            }
              
           
        }catch (Exception e) {
			request.getSession().setAttribute("msg", "falha ao buscar conta.");
		}  
        
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
