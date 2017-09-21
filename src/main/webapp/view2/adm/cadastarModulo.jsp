<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Modulo"%>

<!doctype html>
<html lang="pt">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Cadastrar Módulo</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!--     Fonts and icons     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css"
	rel="stylesheet">

<!-- CSS Files -->
<link href="../../assets2/css/bootstrap.min.css" rel="stylesheet" />
<link href="../../assets2/css/gsdk-bootstrap-wizard.css"
	rel="stylesheet" />

<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="../../assets2/css/demo.css" rel="stylesheet" />
<!--meu css -->
<link rel="stylesheet" href="newcss.css" type="text/css" />
<link href="../../assets2/css2/drop.css" rel="stylesheet" />

<style>
#btn_confirma {
	width: 150px;
	height: 35px;
	background: steelblue;
	color: white;
	float: right;
}

#faixa_topo {
	height: 10%;
	color: white;
	background: steelblue;
	text-align: center;
	text-transform: uppercase;
}

#texto_faixa {
	margin-top: 1.2%;
}

#topo {
	background: steelblue;
}

#nivelUsuario {
	margin-top: 70px;
}

#textB {
	color: white;
}

#rodap {
	background: steelblue;
	border-radius: 0px 0px 10px 10px;
}

#save {
	margin-right: 100px;
	margin-top: 15px;
	width: 110px;
	height: 30px;
	color: white;
	margin-left: 30%;
}

#tudo {
	width: 80%;
	margin-left: 10%;
	border-radius: 10px;
	border: solid 1px;
}

#rodape {
	margin-right: 40%;
	color: white;
}

#save {
	background: steelblue;
	border-color: steelblue;
}

#txt_busca {
	width: 45%;
	border-radius: 10px;
	height: 35px;
}

.btn_pad {
	background: steelblue;
	color: white;
	border-radius: 8%;
	width: 10%;
	height: 35px;
}
</style>
</head>
<body>
	<%	String mensagem = (String)session.getAttribute("msg");
			if(mensagem == null){
				mensagem = "";
			}
		 %>


	<div id="tudo" class="wrapper">
		<div class="main-panel">
			<nav class="navbar navbar-default navbar-fixed">
				<div id="topo" class="container-fluid">
					<div class="navbar-header">
						<a id="textB" class="navbar-brand">Sistema Controle de Acesso</a>
					</div>
					<%@ include file="../menuDropDown.jsp"%>
				</div>
			</nav>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6 " style="margin-left: 25%;">
							<div class="card">
								<div class="header">
									<h4 class="title" style="text-align: center;">Cadastro de
										Módulo</h4>
								</div>
								<div class="erroMsg">
									<small><%= mensagem %>
										<%session.setAttribute("msg", null);%></small>
								</div>
								<div class="content">
									<div id="corpo">
										<div id="centro">
											<form method="post" action="cadastrarModulo"
												name="formCadastro">
												<label for="titulo">Título</label><input type="text"
													title="Preencha este campo" name="titulo" required
													class="form-control"><br> <label for="url">URL</label><input
													type="text" title="Preencha este campo" name="url" required
													class="form-control"><br> <label for="imagem">Imagem</label><input
													type="file" title="Preencha este campo" name="imagem"><br>
												<label for="perfil">Perfil de Acesso</label><br>
												<div style="margin-left: 3%">
													<input type="checkbox" class="marcar" name="todos" value=""
														onclick="marcardesmarcar()"> Todos<br> <input
														type="checkbox" class="marcar" name="aluno" value="1">
													Aluno<br> <input type="checkbox" class="marcar"
														name="professor" value="2"> Professor<br> <input
														type="checkbox" class="marcar" name="secretario" value="2">
													Secretário<br> <input type="checkbox" class="marcar"
														name="funcionário" value="4"> Funcionário<br>
												</div>
												<div style="margin-top: 0% !important">
													<input id="btn_confirma" type="submit" value="Salvar"
														title="Salvar módulo">
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer class="footer">
			<div id="rodap" class="container-fluid">
				<p id="rodape" class="copyright pull-right">
					<br> ₢ Todos os direitos reservados | N2S
				</p>
			</div>
		</footer>
	</div>
</body>

<script>
            function marcardesmarcar() {
                $('.marcar').each(function () {
                    if (this.checked) this.checked = false;
                    else this.checked = true;
                });
            }
        </script>
<!--   Core JS Files   -->
<script src="../../assets2/js/jquery-2.2.4.min.js"
	type="text/javascript"></script>
<script src="../../assets2/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../assets2/js/jquery.bootstrap.wizard.js"
	type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="../../assets2/js/gsdk-bootstrap-wizard.js"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="../../assets2/js/jquery.validate.min.js"></script>
<script src="../../assets2/js2/drop.js"></script>


</html>
