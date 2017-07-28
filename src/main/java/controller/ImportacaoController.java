package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class ImportacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*Part part = request.getPart("owlFile");
		BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream()));
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			
		}*/
		Part arquivo = request.getPart("arquivo") ;
		String curso = request.getParameter("curso");
		System.out.println(curso);
		String caminho = request.getServletContext().getRealPath("");
		File fileSaveDir = new File(caminho);
		if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
		System.out.println(caminho);
		arquivo.write(caminho);
		caminho += arquivo.getSubmittedFileName(); 
		
		FileReader file = new FileReader(caminho);
		BufferedReader reader = new BufferedReader(file);
		String ler = reader.readLine();
		String matricula;
		String nome;
		while(ler != null ){
			
			matricula = ler.substring(0, 6);
			nome = ler.substring(7);
			ler = reader.readLine();
			
			System.out.println(matricula+" "+nome);
			util.Facade.preCadastrarAluno(nome, matricula, Integer.valueOf(curso));
			
		}
		reader.close();
	}
}
