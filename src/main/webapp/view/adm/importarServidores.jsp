<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-default header">
			<div class="panel-heading">
				<h3 id="titulo_da_pagina">Pré-Cadastrar Servidores</h3>
			</div>
			<div class="panel-body">
				<div class="panel-body">
					<%
						if (session.getAttribute(Constantes.getSessionMsg()) != null) {
					%>
					<div class="alert alert-danger" role="alert">
						<%=session.getAttribute(Constantes.getSessionMsg())%>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null);%>

					<%
						}
					
						if (request.getParameter("sucessoPrecadastro") != null  && request.getParameter("sucessoPrecadastro").equals("1")) {
					%>
					<div class="alert alert-success" role="alert">
						<%="Sucesso ao cadastrar Servidor"%>
					</div>
					<%
						}
					%>
					<form action="importarServidor" method="post">
						<div class="form-group">
							<label for="nome">Nome Completo </label> <input required="true"
								name="nome" id="nome" type="text" class="form-control">
						</div>
						<div class="form-group">
							<label for="siape">Siape </label><input required="true"
								name="siape" id="siape" type="text" class="form-control">
						</div>
						<div class="form-group">
							<input type="submit"
								class="btn btn-success form-control text-center"
								value="Importar" title="Importar matriculas">
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