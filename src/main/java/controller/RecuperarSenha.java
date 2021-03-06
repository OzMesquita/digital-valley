package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pessoa;
import util.Constantes;
import util.Facade;

/**
 *
 * @author Usuario
 */
public class RecuperarSenha extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
        try{
            String email = request.getParameter("email");
            
            if(email!= null){
            	Pessoa p = Facade.BuscarEmailVinculado(email);
                if(p != null){
                	Facade.inserirToken(p);
                	String mensagem = "erro ao enviar email";
                	try {
                		Facade.EnviarEmailRecuperacaoDeSenha(p);
                		mensagem = "Um e-mail foi enviado para a conta informada.";
					} catch (Exception e) {
						mensagem += e.getMessage();
					}
                    
                    
                    request.getSession().setAttribute(Constantes.getSessionMsg(),mensagem);
                    request.getSession().setAttribute("pessoa", p);
                    
                }else{
                	request.getSession().setAttribute("msg", "Este e-mail não está vinculado a uma conta ativa.");
                    throw new IllegalArgumentException("Este e-mail não está vinculado a uma conta ativa.");
                }
              
            }else{
                throw new IllegalArgumentException("E-mail não pode ser vazio.");
            }
        }catch (Exception e) {
        	session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}
        response.sendRedirect("recuperSenha.jsp");
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
