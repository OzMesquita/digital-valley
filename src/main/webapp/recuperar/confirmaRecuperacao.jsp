<%@page import="util.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Tela de recuperação</title>
<link rel="stylesheet" type="text/css"
	href="<%=Constantes.getAppCssUrl()%>/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=Constantes.getAppCssUrl()%>/style.css">

<style type="text/css">
html, body {
	height: 98%;
}

footer {
	height: 2%;
}
</style>
</head>
<body>

	<div class="image-container set-full-height "
		style="background: steelblue; height: 100%;">

		<div class="container fundo-claro">

			<div id="cabecalho-recuperacao" align="center">
				<h2>CONFIRMAR RECUPERAÇÃO DE SENHA</h2>
			</div>

			<div class="wizard-navigation" id="tipo-usuario-recuperacao">
				<ul class="nav nav-pills tab-menu" id="tipo_usuario">
					<li class="active  col-md-6 sem-padding-left sem-padding-right"
						id="tab-esquerda"><a href="#aluno-tab" data-toggle="tab"
						aria-expanded="true">ALUNO</a></li>

					<li class="col-md-6 sem-padding-left sem-padding-right"
						id="tab-direita"><a href="#servidor-tab" data-toggle="tab"
						aria-expanded="false">SERVIDOR</a></li>
				</ul>

				<div class="moving-tab"
					style="width: 375px; transform: translate3d(0px, 0px, 0px); transition: transform 0s;">
				</div>




				<div class="tab-content">

					<div class="tab-pane active col-md-12" id="aluno-tab">
						<div class="row">
							<form action="ConfirmaRecuperacao" class="form-espacamento">
								<div class="form-group">
									<label for="matricula">Matrícula:</label> <input type="text"
										id="matricula" name="matricula" maxlength="6"
										class="form-control">
								</div>
								<div class="form-group">
									<label for="cpfA">CPF:</label><input type="text" name="cpfA"
										id="cpfA" class="form-control cpf">
								</div>
								<div class="row">
									<div class="form-group col-md-4 ">
										<a class="btn btn-sucess"
											href="<%=Constantes.getAppUrl()%>/login.jsp"> <span
											class="glyphicon glyphicon-arrow-left"></span> Voltar
										</a>
									</div>
									<div class="form-group col-md-4">
										<button type="submit" class="btn btn-success form-control"
											type="submit">
											<span class="glyphicon glyphicon-ok"></span> Salvar
										</button>
									</div>
								</div>

							</form>
						</div>
					</div>


					<div class="tab-pane col-md-12" id="servidor-tab">
						<div class="row">
							<form action="ConfirmaRecuperacao" class="form-espacamento">
								<div class="form-group">
									<label for="matricula">Siape:</label> <input type="text"
										id="siape" name="siape" maxlength="7" class="form-control">
								</div>
								<div class="form-group">
									<label for="cpfA">CPF:</label><input type="text" name="cpfS"
										id="cpfS" class="form-control cpf">
								</div>

								<div class="row">
									<div class="form-group col-md-4">
										<a class="btn btn-sucess"
											href="<%=Constantes.getAppUrl()%>/login.jsp"> <span
											class="glyphicon glyphicon-arrow-left"></span> Voltar
										</a>
									</div>
									<div class="form-group col-md-4">
										<button type="submit" class="btn btn-success form-control"
											type="submit">
											<span class="glyphicon glyphicon-ok"></span> Salvar
										</button>
									</div>
								</div>

							</form>
						</div>
					</div>


				</div>
			</div>

		</div>
	</div>


<footer>
	<div class="text-center">₢ Todos os direitos reservados | N2S</div>
</footer>
</body>
<script src="<%=Constantes.getAppJsUrl()%>/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/bootstrap.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/formularioDeRecuperacao.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/jquery.mask.min.js"
	type="text/javascript"></script>
<script src="<%=Constantes.getAppJsUrl()%>/validacao.js"
	type="text/javascript"></script>

</html>

