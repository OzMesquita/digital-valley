<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>
<%@page import="util.Facade"%>
<%
	String mensagem = (String) session.getAttribute("msg");
	if (mensagem == null) {
		mensagem = "";
	}
%>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Informações do Usuário</h3>
			</div>
			<div class="panel-body">
				<%
					if (request.getParameter("erro") != null) {
				%>
				<div class="alert alert-danger">
					<%=(String) request.getParameter("erro")%>
				</div>
				<%
					}
				%>
				<form action="editarUsuario" method="post">
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label for="codigo_interno">Código Interno</label> <input
									id="codigo_interno" type="text" class="form-control" disabled
									value="<%=usuario.getPessoa().getId()%>">
							</div>
						</div>
						<div class="col-md-9">
							<div class="form-group">
								<label for="nome">Nome Completo</label> <input type="text"
									class="form-control" name="nome" id="nome" disabled
									value="<%=usuario.getPessoa().getNome()%>">
							</div>
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
									id="nascimento" class="form-control" name="nascimento" required
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
									class="form-control" name="senha" id="senha" required>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="cSenha">Confirmar Senha</label> <input
									type="password" class="form-control" name="cSenha" id="cSenha"
									placeholder="Confirmar senha">
							</div>
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success text-centered form-control"
							value="Salvar" title="Salvar alterações">
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
<script type="text/javascript">
	$(document).ready(function($) {
		$("#nascimento").mask("00/00/0000");
		$("#cpf").mask("000.000.000-00");
	});
</script>