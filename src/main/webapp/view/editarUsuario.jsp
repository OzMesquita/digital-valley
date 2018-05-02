<%@page import="model.Servidor"%>
<%@page import="model.Aluno"%>
<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>
<%@page import="util.Facade"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-md-8 col-md-offset-2" id="infoUsuario">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Informações do Usuário</h3>
			</div>
			
			<div class="panel-body">
			
			
			<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="<%=session.getAttribute(Constantes.getSessionMsg()).equals("Dados alterados com sucesso") ? "alert alert-success": "alert alert-danger" %>" role="alert">
  						<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
				<%} %>	
				<form action="editarUsuario" method="post" enctype="multipart/form-data">

					<div class="row">
						<div class="col-md-4">
							<p>
								<img
									src="<%=Constantes.getAppUrl()%>/view/imagem_perfil_usuario?id_usuario=<%=usuario.getPessoa().getId()%>"
									id="img-edicao-perfil">
							</p>
							<div class="form-group">

								<label for="image-perfil">Editar imagem perfil:</label> <input
									type="file" name="image-perfil" id="image-perfil">
							</div>
						</div>
						<div class="col-md-8">
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
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label for="cpf">CPF</label> <input type="text" id="cpf"
										name="cpf" class="form-control" maxlength="14" required
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
						</div>
					</div>

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label for="login">Login</label> <input type="text"
									class="form-control" name="login" id="login" required
									value="<%=usuario.getLogin()%>">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="senha">Nova Senha</label> <input type="password"
									class="form-control" name="senha" id="senha">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="senha_repetida">Confirmar Senha</label> <input
									type="password" class="form-control" name="senha_repetida"
									id="senha_repetida">
							</div>
						</div>

					</div>
					<div class="form-group">
						<input type="submit"
							class="btn btn-success text-center form-control" value="Salvar"
							title="Salvar alterações">
					</div>
				</form>
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
