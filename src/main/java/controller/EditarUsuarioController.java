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

import model.Pessoa;
import model.Usuario;
import util.Constantes;
import util.Facade;

@MultipartConfig
public class EditarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (ServletFileUpload.isMultipartContent(req)) {
			try {
				// pegar dados do formulário
				DiskFileItemFactory factory = new DiskFileItemFactory(Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES(),
						(File) this.getServletConfig().getServletContext()
								.getAttribute("javax.servlet.context.tempdir"));
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(req);
				Iterator<FileItem> iter = items.iterator();
				Map<String, String> dados = new HashMap<String, String>();
				FileItem imagemPerfil = null;
				for (FileItem item = iter.next(); iter.hasNext(); item = iter.next()) {	
					if (item.isFormField()) {
						dados.put(item.getFieldName(), item.getString());
					} else {
						if (item.getContentType().startsWith("image/")) {
							if (item.getSize() <= Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES()) {
								imagemPerfil = item;
							} else {
								session.setAttribute(Constantes.getSessionMsg(),
										"Erro: O arquivo selecionado não pode ultrapassar "
												+ (Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES() / (1024 * 1024))
												+ " MB.");
							}
						} else {
							session.setAttribute(Constantes.getSessionMsg(),
									"Erro: O arquivo selecionado deve ser uma imagem.");
						}
					}
				}
				String nomeDoCampoSenha = "senha";
				String nomeDoCampocSenha = "senha_repetida";
				System.out.println(dados.get(nomeDoCampoSenha) + " " + dados.get(nomeDoCampocSenha));
				if (dados.get(nomeDoCampoSenha).equals(dados.get(nomeDoCampocSenha))) {
					// configurar objetos
					Usuario usuarioDaSessao = (Usuario) session.getAttribute("usuario");
					Pessoa pessoaDaSessao = usuarioDaSessao.getPessoa();
					Pessoa pessoaEditada = new Pessoa();
					Usuario usuarioEditado = new Usuario();
					pessoaEditada.setId(pessoaDaSessao.getId());
					pessoaEditada.setNome(pessoaDaSessao.getNome());
					pessoaEditada.setCpf(dados.get("cpf"));
					pessoaEditada.setDataNascimento(dados.get("nascimento"));
					pessoaEditada.setEmail("email");
					usuarioEditado.setPessoa(pessoaEditada);
					usuarioEditado.setNivel(usuarioDaSessao.getNivel());
					usuarioEditado.setToken(usuarioDaSessao.getToken());
					usuarioEditado.setTokenUsuario(usuarioDaSessao.getTokenUsuario());
					usuarioEditado.setLogin(dados.get("login"));
					usuarioEditado.setSenha(dados.get(nomeDoCampoSenha));
					// salvar imagem
					if (imagemPerfil != null) {
						String[] parts = imagemPerfil.getName().split(".");
						String nomeImagemPerfil = pessoaDaSessao.getId() + "." + parts[parts.length - 1];
						imagemPerfil.write(new File(Constantes.getUSER_PROFILE_IMAGES_DIR() + nomeImagemPerfil));
						pessoaEditada.setImagem(nomeImagemPerfil);
					} else {
						pessoaEditada.setImagem(pessoaDaSessao.getImagem());
					}
					// salvar dados no banco
					Facade.editarPessoa(pessoaEditada, usuarioEditado);
					session.setAttribute("usuario", usuarioEditado);
				} else {
					session.setAttribute(Constantes.getSessionMsg(), "Erro: As senhas estão diferentes.");
				}
			} catch (Exception e) {
				session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
			}
		} else {
			session.setAttribute(Constantes.getSessionMsg(),
					"Erro: O formulário não estar com enctype=\"multipart/form-data\".");
		}
		resp.sendRedirect("editarUsuario");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("editarUsuario.jsp").forward(req, resp);
	}

}
