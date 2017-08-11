/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Modulo;
import model.Perfil;
import model.Pessoa;
import model.Usuario;
import util.Facade;

/**
 *
 * @author Usuario
 */
public class PesquisaModulos extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        System.out.println("entrou servlet modulo");
        List<Modulo> modulosDisponiveis; 
        List<Modulo> modulosCadastrados;
        int id = Integer.parseInt(request.getParameter("busca"));
        
        if(session.getAttribute("mostra").toString().toLowerCase().equals("usuarios")){
            Pessoa selecionado = Facade.buscarPessoaPorId(id);
            modulosCadastrados = (List<Modulo>) Facade.buscarModulosPorPessoas(selecionado);
            modulosDisponiveis = (List<Modulo>) Facade.buscarTodosModulos();
            modulosDisponiveis.removeAll(modulosCadastrados);
            session.setAttribute("usuarioSelecionado", selecionado);
        }else{
            Perfil perfilSelecionado = Facade.buscaPerfilPorId(id);
            modulosCadastrados = (List<Modulo>) Facade.buscarModulosPorPerfil(perfilSelecionado);
            modulosDisponiveis = (List<Modulo>) Facade.buscarTodosModulos();
            modulosDisponiveis.removeAll(modulosCadastrados);
            session.setAttribute("perfilSelecionado", perfilSelecionado);
        
        }
        session.setAttribute("modulosDisponiveis", modulosDisponiveis);
        session.setAttribute("modulosCadastrados", modulosCadastrados);
        response.sendRedirect("TelaADM.jsp");
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
