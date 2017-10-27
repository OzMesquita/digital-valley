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
			String sessionMsg = "";
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
								sessionMsg += "Erro: O arquivo selecionado não pode ultrapassar "
										+ (Constantes.getMAX_USER_PROFILE_IMAGE_SIZE_BYTES() / (1024 * 1024))
										+ " MB.<br>";
							}
						} else {
							sessionMsg += "Erro: O arquivo selecionado deve ser uma imagem.<br>";
						}
					}
				}
				String nomeDoCampoSenha = "senha";
				String nomeDoCampocSenha = "senha_repetida";
				String senha = dados.get(nomeDoCampoSenha).trim();
				String senhaRepetida = dados.get(nomeDoCampocSenha).trim();
				// configurar objetos
				Usuario usuarioDaSessao = (Usuario) session.getAttribute("usuario");
				Pessoa pessoaDaSessao = usuarioDaSessao.getPessoa();
				Pessoa pessoaEditada = new Pessoa();
				Usuario usuarioEditado = new Usuario();
				pessoaEditada.setId(pessoaDaSessao.getId());
				pessoaEditada.setNome(pessoaDaSessao.getNome());
				pessoaEditada.setCpf(pessoaDaSessao.getCpf());
				pessoaEditada.setDataNascimento(dados.get("nascimento"));
				pessoaEditada.setEmail(dados.get("email"));
				usuarioEditado.setPessoa(pessoaEditada);
				usuarioEditado.setNivel(usuarioDaSessao.getNivel());
				usuarioEditado.setToken(usuarioDaSessao.getToken());
				usuarioEditado.setTokenUsuario(usuarioDaSessao.getTokenUsuario());
				usuarioEditado.setLogin(dados.get("login"));
				if (!senha.isEmpty() && !senhaRepetida.isEmpty() && senha.equals(senhaRepetida)) {
					usuarioEditado.setSenha(dados.get(nomeDoCampoSenha));
				} else {
					usuarioEditado.setSenha(DAOFactory.criarPessoaDAO().buscarPorId(usuarioDaSessao.getPessoa().getId())
							.getUsuario().getSenha());
					sessionMsg += "Erro: As senhas estão diferentes.<br>";
				}
				System.out.println("Salvando imagem");
				// salvar imagem
				if (imagemPerfil != null) {
					System.out.println("Salvando foto");					
					String nomeImagemPerfil = pessoaDaSessao.getId() + "-" + imagemPerfil.getName();
					imagemPerfil.write(new File(Constantes.getUSER_PROFILE_IMAGES_DIR() + nomeImagemPerfil));
					pessoaEditada.setImagem(nomeImagemPerfil);
				} else {
					System.out.println("Nao salva");
					pessoaEditada.setImagem(pessoaDaSessao.getImagem());
				}
				// salvar dados no banco
				Facade.editarPessoa(pessoaEditada, usuarioEditado);
				session.setAttribute("usuario", usuarioEditado);
				sessionMsg +=  "Dados alterados com sucesso.<br>";
			} catch (Exception e) {
				e.printStackTrace();
				sessionMsg += e.getMessage();
			}
			session.setAttribute(Constantes.getSessionMsg(), sessionMsg.isEmpty() ? null : sessionMsg);
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
