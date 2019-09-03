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
    	Usuario usuario = null;
    	String pagina = "confirmaRecuperacao.jsp?erroRecuperação=1";
    	HttpSession session = request.getSession();
        try{
        	String matricula = "";
        	String siape = "";
            matricula = request.getParameter("matricula");
            siape = request.getParameter("siape");
            String cpfA = request.getParameter("cpfA");
            String cpfS = request.getParameter("cpfS");
            if(matricula != "" ){
            	String aux = cpfA.replaceAll("-", "");            
        		cpfA = aux.replaceAll("[.]", "");
            	usuario = Facade.buscarPorMatriculaAndCPF(matricula,cpfA);
            }else if(siape != null){
            	String aux2 = cpfS.replaceAll("-", "");
        		cpfS = aux2.replaceAll("[.]", "");
            	usuario = Facade.buscarPorSiapeAndCPF(siape, cpfS);
            }else{
            	session.setAttribute(Constantes.getSessionMsgError()," CPF não pode ser vazio.");
            	usuario = null;
            }
          
           
        }catch (Exception e) {
        	session.setAttribute(Constantes.getSessionMsgError(), "Falha ao buscar a conta");
		}  
        if (usuario != null){
        	session.setAttribute("usuario",usuario);
        	pagina = util.Constantes.getAppUrl()+"/recuperarSenha.jsp";
        }else{
        	session.setAttribute("usuario", null);
        	session.setAttribute(Constantes.getSessionMsgError(), "Código interno e/ou cpf inválido");
        	pagina = util.Constantes.getAppUrl()+"/login.jsp";
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
