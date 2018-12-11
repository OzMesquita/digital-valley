<%@page import="model.Servidor"%>
<%@page import="model.Aluno"%>
<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>
<%@page import="util.Facade"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Informações do usuário</h1>
          <p class="lead text-muted">Atualize suas informações.</p>
        </div>
      </section>
<div class="container">
  				<div class="row">
  					<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="<%=(request.getParameter("sucessoEditar") != null && request.getParameter("sucessoEditar").equals("1")) ? "alert alert-success": "alert alert-danger" %>" role="alert">
  						<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
					<%} %>	
					<div class="col-md-12">
  					<div class="card">
						  <h5 class="card-header">Geral</h5>
						  <div class="card-body">
							<form action="editarUsuario" method="post">
							<div class="row">
							<%
								if((usuario.getPessoa() instanceof Aluno)==false && (usuario.getPessoa() instanceof Servidor)==false){%>
										<div class="col-md-12">
											<div class="form-group">
												<label for="nome">Nome Completo</label> <input type="text"
												class="form-control" name="nome" id="nome" disabled
												value="<%=usuario.getPessoa().getNome()%>">
											</div>
										</div>
								<%}else{%>
								<div class="col-md-3">
									<div class="form-group">
										<%
											String codigoInterno = "";
											if (usuario.getPessoa() instanceof Aluno) {
												Aluno aluno = (Aluno) usuario.getPessoa();
												codigoInterno = aluno.getMatricula();
											} else if (usuario.getPessoa() instanceof Servidor) {
												Servidor servidor = (Servidor) usuario.getPessoa();
												codigoInterno = servidor.getSiape();

											}
										%>
										<label for="codigo_interno">Código Interno</label> <input
											id="codigo_interno" name="codigo_interno" type="text"
											class="form-control" disabled value="<%=codigoInterno%>">
									</div>
								</div>
								<div class="col-md-9">
									<div class="form-group">	
										<label for="nome">Nome Completo</label> <input type="text"
											class="form-control" name="nome" id="nome" disabled
											value="<%=usuario.getPessoa().getNome()%>">
									</div>
								</div>
								<%}%>
							</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label for="cpf">CPF</label> <input type="text" id="cpf"
										name="cpf" class="form-control" maxlength="14" disabled="disabled"
										value="<%=usuario.getPessoa().getCpf()%>">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label for="nascimento">Data de Nascimento</label> <input
										title="Preencha este campo corretamente" type="text"
										id="nascimento" class="form-control" name="nascimento"
										required
										value="<%=Facade.converterLocalDateParaString(usuario.getPessoa().getDataNascimento())%>">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="email">E-mail</label> <input type="text" id="email"
										class="form-control" name="email" required
										value="<%=usuario.getPessoa().getEmail()%>">
								</div>
							</div>
							<div class="col-md-12">
							<div class="form-group">
								<label for="login">Login</label> <input type="text"
									class="form-control" name="login" id="login" required
									value="<%=usuario.getLogin()%>">
							</div>
						</div>
						<div class="col-md-12">
						<div class="form-group">
						<input type="submit"
							class="btn btn-primary text-center form-control" value="Salvar"
							title="Salvar alterações">
					</div>
					</div>
						</div>
					</div>
					
				</form>
  </div>
  </div>
  
  
  <div class="col-md-3">
  <div class="card">
						    <h5 class="card-header">Avatar</h5>
						  <div class="card-body">
						    <p>
								<img
									src="<%=Constantes.getAppUrl()%>/view/imagem_perfil_usuario?id_usuario=<%=usuario.getPessoa().getId()%>"
									id="img-edicao-perfil" style="width:200px; height:200px; border-radius:50%">
							</p>
							<form action="<%=Constantes.getAppUrl()%>/removeImagemPerfilUsuario" method="post">
							
							</form>
							<div class="modal fade" id="removeImagemModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Remover Imagem de Perfil</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							       Você realmente deseja remover sua imagem de perfil?
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
							        <form action="<%=Constantes.getAppUrl()%>/removeImagemPerfilUsuario" method="post">
										<button type="submit" class="btn btn-primary">Sim</button>
									</form>
							      </div>
							    </div>
							  </div>
							</div>
							<div class="form-group">
								<button type="button" data-toggle="modal" data-target="#removeImagemModal"
									class="btn btn-outline-danger text-center form-control"
									title="Remover Imagem">Remover Imagem</button>
							</div>
				<form action="<%=Constantes.getAppUrl()%>/alterarImagemPerfilUsuario" method="post" enctype="multipart/form-data">
							<div class="form-group" style="width:100%">
									<label class="btn btn-outline-dark btn-file" style="width:100%">
									    <span id="text-btn-input-image">Selecionar Nova Imagem</span> <input accept="image/*" type="file" name="image-perfil" id="image-input" style="display: none;">
									</label>
							</div>
							<div class="form-group btn-submit-image" style="display:none;">
								<input type="submit"
									class="btn btn-primary text-center form-control" value="Salvar Imagem"
									title="Alterar Imagem">
							</div>
							</form>
						  </div>
						</div>
						</div>
						
						
						
						
						
						<div class="col-md-9">
  <div class="card">
  <h5 class="card-header">Senha</h5>
  <div class="card-body">
    <form action="<%=Constantes.getAppUrl()%>/alterarSenhaUsuario" method="post">
					<div class="row">
					<div class="col-md-12">
							<div class="form-group">
								<label for="senha">Senha Antiga</label> <input type="password"
									class="form-control" name="senha_antiga" id="senha">
							</div>
							<div class="form-group">
								<label for="senha">Nova Senha</label> <input type="password"
									class="form-control" name="senha" id="senha">
							</div>
							<div class="form-group">
								<label for="senha_repetida">Confirmar Senha</label> <input
									type="password" class="form-control" name="senha_repetida"
									id="senha_repetida">
							</div></div>

					</div>
					<div class="form-group">
						<input type="submit"
							class="btn btn-primary text-center form-control" value="Salvar"
							title="Salvar alterações">
					</div>
				</form>
  </div>
</div>
</div>
		
				
  
  
  				</div>
			</div>
<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/jquery.mask.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/validacao.js"
	type="text/javascript"></script>
	
	<script>
		$(function () {
			$('#image-input').change(function () {
				var file = $(this).val();
				if (file == "") {
					$("#text-btn-input-image").html("Selecionar Nova Imagem");
					$(".btn-submit-image").hide();
				} else {
					$("#text-btn-input-image").html("Imagem Selecionada");
					$(".btn-submit-image").show();
				}
			});
		});
	</script>
