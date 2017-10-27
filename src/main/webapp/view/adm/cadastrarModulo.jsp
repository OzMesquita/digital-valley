<%@page import="util.Facade"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Modulo"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String mensagem = (String) session.getAttribute("msg");
	if (mensagem == null) {
		mensagem = "";
	}
%>
<div class="row">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Cadastro de Módulo</h3>
			</div>
			<div class="panel-body">
				<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="alert alert-danger" role="alert">
  						<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
				<%} %>
				<form method="post" action="adm/cadastrarModulo" name="formCadastro">
					<div class="form-group">
						<label for="titulo">Título</label><input type="text"
							title="Título" name="titulo" id="titulo" required
							class="form-control">
					</div>
					<div class="form-group">
						<label for="url">URL</label><input type="text" title="URL"
							name="url" id="url" required class="form-control">
					</div>
					<div class="form-group">
						<label for="imagem">Imagem</label><input type="file"
							class="btn btn-info" id="imagem" name="imagem">
					</div>
					<div class="form-group">
						<label>Perfil de Acesso</label>
						<p>
							<input type="checkbox" id="perfil_todos_checkbox" name="todos"><strong>Todos</strong>
						</p>
						<%
							List<Perfil> perfis = Facade.ListarPeril();
							for (Perfil p : perfis) {
						%>
						<p>
							<input type="checkbox" class="perfil_checkbox"
								name="<%=p.getNome()%>" value="ok"><%=p.getNome()%>
						</p>
						<%
							}
						%>
					</div>
					<div class="row">
						<div class="col-md-6 col-md-offset-3">
							<div class="form-group">
								<input class="form-control btn btn-success" type="submit"
									value="Salvar">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=Constantes.getAppJsUrl()%>/marcarCheckBoxDePerfis.js"></script>