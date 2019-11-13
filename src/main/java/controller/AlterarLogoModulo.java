package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.DAOFactory;
import model.Modulo;
import util.Constantes;
import util.Facade;

/**
 * Servlet implementation class AlterarImagemPerfilUsuario
 */
@MultipartConfig
public class AlterarLogoModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pagina = "editarModulo.jsp?sucessoEditar=0";
		if (ServletFileUpload.isMultipartContent(request)) {
			String sessionMsg = "";
			try {
				// pegar dados do formulário
				DiskFileItemFactory factory = new DiskFileItemFactory(Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES(),
						(File) this.getServletConfig().getServletContext()
								.getAttribute("javax.servlet.context.tempdir"));
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				Map<String, String> dados = new HashMap<String, String>();
				FileItem logoModulo = null;
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						dados.put(item.getFieldName(), item.getString());
					} else {
						if (item.getContentType().startsWith("image/")) {
							if (item.getSize() <= Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES()) {
								logoModulo = item;
							} else {
								sessionMsg = "Erro: O arquivo selecionado não pode ultrapassar "
										+ (Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES() / (1024 * 1024))
										+ " MB.<br>";
							}
						} else {
							sessionMsg = "Erro: O arquivo selecionado deve ser uma imagem.<br>";
						}
					}
				}
				// salvar imagem
				if (logoModulo != null) {
					int id = Integer.parseInt(session.getAttribute("idModulo").toString());						
					Modulo modulo = Facade.buscarModulosPorId(id);
					String nomeImagemPerfil = "logo_"+System.currentTimeMillis()+ ".png";
					logoModulo.write(new File(Constantes.getUSER_PROFILE_IMAGES_DIR()+ nomeImagemPerfil));
					modulo.setImagem(nomeImagemPerfil);
					Facade.editarModulo(modulo);
				} else {
					sessionMsg = "Erro: O arquivo selecionado deve ser uma imagem.<br>";
					session.setAttribute(Constantes.getSessionMsgError(), sessionMsg);
				}
				
				if(sessionMsg.isEmpty()) {
					pagina = "editarModulo.jsp?sucessoEditar=1";
					sessionMsg = "Logo de módulo alterada com sucesso!";
					session.setAttribute(Constantes.getSessionMsg(), sessionMsg);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute(Constantes.getSessionMsgError(), sessionMsg + "\n" + e.getMessage());
			}
			
			
		} else {
			session.setAttribute(Constantes.getSessionMsgError(),
					"Erro: O formulário não está com enctype=\"multipart/form-data\".");
		}
		response.sendRedirect(pagina);
	}

}
