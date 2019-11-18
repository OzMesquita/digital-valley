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

import model.Aluno;
import model.Pessoa;
import model.Servidor;
import model.Usuario;
import util.Constantes;
import util.Facade;

/**
 * Servlet implementation class AlterarImagemPerfilUsuario
 */
@MultipartConfig
public class AlterarImagemPerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarImagemPerfilUsuario() {
        super();
        // TODO Auto-generated constructor stub
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
		HttpSession session = request.getSession();
		String pagina = "view/editarUsuario.jsp?sucessoEditar=0";
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
				FileItem imagemPerfil = null;
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
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
				
				Usuario usuarioDaSessao = (Usuario) session.getAttribute("usuario");
				Pessoa pessoaDaSessao = usuarioDaSessao.getPessoa();
		
				// salvar imagem
				if (imagemPerfil != null) {
					String nomeImagemPerfil =  "usuario_"+System.currentTimeMillis()+ ".png";//pessoaDaSessao.getId() + "-" + imagemPerfil.getName();
					if (pessoaDaSessao.getImagem() != null) {
						new File(Constantes.getUSER_PROFILE_IMAGES_DIR() + pessoaDaSessao.getImagem()).delete();
					}
					imagemPerfil.write(new File(Constantes.getUSER_PROFILE_IMAGES_DIR() + nomeImagemPerfil));
					usuarioDaSessao.getPessoa().setImagem(nomeImagemPerfil);
					Facade.editarUsuarioESenha(usuarioDaSessao.getPessoa(), usuarioDaSessao);
				} else {
					sessionMsg = "Erro: O arquivo selecionado deve ser uma imagem.<br>";
				}
				session.setAttribute("usuario", usuarioDaSessao);
				if(sessionMsg.isEmpty()) {
					pagina = "view/editarUsuario.jsp?sucessoEditar=1";
					sessionMsg = "Imagem de perfil alterada com sucesso!";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				sessionMsg += e.getMessage();
			}
			session.setAttribute(Constantes.getSessionMsg(), sessionMsg);
			
		} else {
			session.setAttribute(Constantes.getSessionMsgError(),
					"Erro: O formulário não estar com enctype=\"multipart/form-data\".");
		}
		response.sendRedirect(pagina);
	}

}
