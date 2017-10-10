<%@page import="util.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Tela de recuperação</title>
<link rel="stylesheet" type="text/css"
	href="<%=Constantes.getAppCssUrl()%>/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<p>Confirmar recuperação de senha</p>
						<p>
							<small><strong>Quase lá!</strong> Só mais uma etapa.
								Confirme seus dados</small>
						</p>
					</div>
					<div class="panel-body">
						<form method="post" action="ConfirmaRecuperacao">
							<div class="form-group">
								<label>Escolha seu tipo de usuário</label>
								<div class="btn-group" role="group">
									<button type="button" id="btnFormAluno"
										class="btn btn-primary active">Aluno</button>
									<button type="button" id="btnFormServidor"
										class="btn btn-primary">Professor</button>
								</div>
							</div>
							<div id="formulario_recuperar_senha_aluno">
								<div class="form-group">
									<label for="matricula">Matrícula</label> <input type="text"
										name="matricula" maxlength="6" class="form-control">
								</div>
								<div class="form-group">
									<label for="cpfA">CPF</label><input type="text" name="cpfA"
										id="cpfA" class="form-control">
								</div>
							</div>
							<div id="formulario_recuperar_senha_servidor">
								<div class="form-group">
									<label for="siape">Siape</label><input type="text" name="siape"
										id="siape" maxlength="7" class="form-control">
								</div>
								<div class="form-group">
									<label for="cpfS">CPF</label><input type="text" name="cpfS"
										id="cpfS" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<a class="btn btn-warning"
									href="<%=Constantes.getAppUrl()%>/login.jsp">Voltar para
									tela de login</a>
							</div>
							<div class="form-group">
								<input class="btn btn-success form-control" type="submit"
									value="Confirmar">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<footer>
	<div class="text-center">₢ Todos os direitos reservados | N2S</div>
</footer>
<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/bootstrap.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/formularioDeRecuperacao.js"
	type="text/javascript"></script>
</html>

