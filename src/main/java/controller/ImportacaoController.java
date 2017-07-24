package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		String arquivo = request.getParameter("arquivo");
		FileReader file = new FileReader("C:\\n2s\\bd.txt");
		BufferedReader reader = new BufferedReader(file);
		while(reader.equals("EOF")){
			
		}
		
	}
}
