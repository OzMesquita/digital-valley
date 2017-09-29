package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import util.Constantes;
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
    	Usuario usuario = new Usuario();
    	String pagina = "confirmaRecuperacao.jsp?erroRecuperação=1";
    	HttpSession session = request.getSession();
        try{
            String matricula = request.getParameter("matricula");
            String siape = request.getParameter("siape");
            String cpfA = request.getParameter("cpfA");
            String cpfS = request.getParameter("cpfS");
            String aux = cpfA.replaceAll("-", "");
    		cpfA = aux.replaceAll("[.]", "");
            aux = cpfS.replaceAll("-", "");
    		cpfS = aux.replaceAll("[.]", "");
    		
    		
    		
            if(!matricula.equals("")){
            	usuario = Facade.buscarPorMatriculaAndCPF(matricula,cpfA);
            }else if(!siape.equals("")){
            	usuario = Facade.buscarPorSiapeAndCPF(siape, cpfS);
            }else{
            	session.setAttribute(Constantes.getSessionMsg(),"CPF não pode ser vazio.");
            }
          
           
        }catch (Exception e) {
        	session.setAttribute(Constantes.getSessionMsg(), "Falha ao buscar a conta");
		}  
        if (usuario != null){
        	session.setAttribute("usuario",usuario);
        	pagina = util.Constantes.getAppUrl()+"/../view/editarUsuario.jsp";
        }
        
        response.sendRedirect(pagina);
        
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
