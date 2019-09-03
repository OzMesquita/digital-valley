package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Aluno;
import util.Facade;

/**
 * Servlet implementation class Service
 */
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String matricula = request.getParameter("matricula");
		Aluno a = Facade.buscarPorMatricula(matricula);
		String anwser="";
	    PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		if (a == null) {
			if (Facade.buscarPreCadastroPorMatricula(matricula)==null) {
				anwser="404";
			}else {
				JsonObject  json = Json.createObjectBuilder()
						.add("matricula", matricula)
						.add("nome",Facade.buscarPreCadastroPorMatricula(matricula))
						.build();
				anwser = json.toString();
			}
		}else {
			JsonObject  json = Json.createObjectBuilder()
					.add("matricula", matricula)
					.add("nome",a.getNome())
					.build();
			anwser = json.toString();
		}
		try {
	    out.println(anwser);   
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			out.close();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
