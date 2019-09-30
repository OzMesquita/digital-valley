package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constantes;
import util.Facade;

/**
 * Servlet implementation class ImagemModulo
 */
public class ImagemModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Get the absolute path of the image
			String filename = Constantes.getUSER_PROFILE_IMAGES_DIR()+Facade.getDiretorioImagemModulo(Integer.valueOf(request.getParameter("id_modulo")));
			// retrieve mimeType dynamically
			String mime = request.getServletContext().getMimeType(filename);
			if (mime == null) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			} else {
				System.out.println(filename);
				File file = new File(filename);
				FileInputStream in = new FileInputStream(file);
				// copiar conteudo
				OutputStream out = response.getOutputStream();
				byte[] buf = new byte[1024];
				for (int count = 0; (count = in.read(buf)) >= 0;) {
					out.write(buf, 0, count);
				}
				out.close();
				in.close();
				response.setContentType(mime);
				response.setContentLength((int) file.length());
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);			
		}
	}

}
