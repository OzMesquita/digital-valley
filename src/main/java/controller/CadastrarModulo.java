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


import model.Modulo;
import model.Perfil;
import model.Usuario;
import util.Constantes;
import util.Facade;

@MultipartConfig
public class CadastrarModulo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pagina = "cadastrarModulo.jsp?erroEditar=1";
		if (ServletFileUpload.isMultipartContent(req)) {
			String sessionMsg = "";
			List<Perfil> perfis = Facade.ListarPeril();
			try {
				// pegar dados do formulário
				DiskFileItemFactory factory = new DiskFileItemFactory(Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES(),
						(File) this.getServletConfig().getServletContext()
								.getAttribute("javax.servlet.context.tempdir"));
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(req);
				Map<String, String> dados = new HashMap<String, String>();
				FileItem imagemPerfil = null;
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						dados.put(item.getFieldName(), item.getString());
					} else {				
						if (item.getContentType().startsWith("image/")) {
							if (item.getSize() <= Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES()) {
								imagemPerfil = item;
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
				Modulo modulo = new Modulo();
				modulo.setTitulo(dados.get("titulo"));
				modulo.setUrl(dados.get("url"));
				
				String nomeImagemPerfil = "modulo_logo_"+System.currentTimeMillis()+ "_" + imagemPerfil.getName();
				imagemPerfil.write(new File(Constantes.getUSER_PROFILE_IMAGES_DIR() + nomeImagemPerfil));
				modulo.setImagem(Constantes.getUSER_PROFILE_IMAGES_DIR() + nomeImagemPerfil);
				
				Facade.cadastrarModulo(modulo);
				
				modulo = Facade.buscarPorNome(modulo.getTitulo());
				String aux;
				for(Perfil p: perfis){
					aux = req.getParameter(p.getNome());
					if(aux != null && aux.equals("ok")){
						util.Facade.adicionarModulosParaPerfil(p.getId(), modulo.getId());
					}
				}
				pagina = "cadastrarModulo.jsp?sucessoCadastro=1";
				session.setAttribute(Constantes.getSessionMsg(), "Sucesso ao cadastrar Modulo "+modulo.getTitulo());
			} catch (NullPointerException e) {
				sessionMsg += e.getMessage()+"null";
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				sessionMsg += e.getMessage();
			}
			
		} else {
			System.out.println("Oi 12");
			session.setAttribute(Constantes.getSessionMsg(),
					"Erro: O formulário não estar com enctype=\"multipart/form-data\".");
		}
		resp.sendRedirect(pagina);
	}	

}