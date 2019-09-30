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
import dao.PerfilDAO;
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
		String pagina = "cadastrarModulo.jsp?sucessoCadastro=0";
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
							if (item.getSize() <= Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES()) {// mudei de <=
																										// para > para
																										// teste(Matheus)
								imagemPerfil = item;
							} else {
								sessionMsg = "Erro: O arquivo selecionado não pode ultrapassar "
										+ (Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES() / (1024 * 1024))
										+ " MB.<br>";
							}
						} else {
							// Ao inves de notificar que não houve envio de imagem o sistema apenas define
							// uma imagem padrão
							// sessionMsg = "Erro: Não foi selecionada uma imagem para a logo.";
							sessionMsg = "Erro: Imagem inválida, então selecionamos uma padrão.";
						}
					}
				}
				Modulo modulo = new Modulo();
				modulo.setTitulo(dados.get("titulo"));
				modulo.setUrl(dados.get("url"));
				modulo.setDescricao(dados.get("descricao"));
				String nomeImagemPerfil;
				if (imagemPerfil !=null) {
					nomeImagemPerfil = "logo_"+System.currentTimeMillis()+ ".png";
					imagemPerfil.write(new File(Constantes.getUSER_PROFILE_IMAGES_DIR()+ nomeImagemPerfil));
					modulo.setImagem(nomeImagemPerfil);
				}else {
					modulo.setImagem("i2.png");
				}

				Modulo mTeste = Facade.buscarPorNome(modulo.getTitulo());
				if (mTeste != null && mTeste.getTitulo().equals(modulo.getTitulo())) {
					pagina = "cadastrarModulo.jsp?erroCadastrar=1";
					session.setAttribute(Constantes.getSessionMsgError(), "Módulo já cadastrado");

				} else {
					Facade.cadastrarModulo(modulo);

					modulo = Facade.buscarPorNome(modulo.getTitulo());
					// Verificar essa atribuição de modulos

					for (Perfil p : perfis) {
						if (dados.get(p.getNome()) != null) {
							util.Facade.adicionarModulosParaPerfil(p.getId(), modulo.getId());
						}
					}
					// Verificar o bloco acima
					pagina = "cadastrarModulo.jsp?sucessoCadastro=1";
					session.setAttribute(Constantes.getSessionMsg(),
							"Sucesso ao cadastrar Modulo " + modulo.getTitulo());
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
				session.setAttribute(Constantes.getSessionMsgError(), sessionMsg + "\n" + e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute(Constantes.getSessionMsgError(), sessionMsg + "\n" + e.getMessage());
			}

		} else {
			System.out.println("Oi 12");
			session.setAttribute(Constantes.getSessionMsgError(),
					"Erro: O formulário não estar com enctype=\"multipart/form-data\".");
		}
		resp.sendRedirect(pagina);
	}

}