
<%@page import="Modelos.Pessoa"%>
<!doctype html>
<html lang="pt">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Editar usuário</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

	<!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="assets/css/demo.css" rel="stylesheet" />
	
	
	<style>
		#topo{background: steelblue; }
		#nivelUsuario{margin-top: 70px;}
		#textB{color: white;}
		#rodap{
			background: steelblue;
			border-radius: 0px 0px 10px 10px;
		}		
		#save{
			margin-right: 100px;
			margin-top: 15px;
		}
		#tudo{
			width: 80%;
			margin-left: 10%;
			border-radius: 10px;
		}
		#rodape{
			margin-right: 40%;
			color: white;
		}
		#save{
			background: steelblue;
			border-color: steelblue;
		}
		#salva{
			background: steelblue;
			margin-top: 15px;
			width: 110px;
			height: 30px;
			color: white;
			margin-left: 84%;	
		}

	</style>
        <% Pessoa usuario = (Pessoa) session.getAttribute("usuario"); %>
</head>
<body>
	<div id ="tudo" class="wrapper">   
		<div class="main-panel" style=" border: 1px solid; border-radius:10px;">
			<nav class="navbar navbar-default navbar-fixed">
                            <div id ="topo" class="container-fluid">
                                <div class="navbar-header">
                                    <a id="textB" class="navbar-brand" href="">Sistema Controle de Acesso</a>
                                </div>
                                <div class="collapse navbar-collapse">
                                    <ul class="nav navbar-nav navbar-right">
                                        <li>
                                           <a id="textB" title="Fazer logout" href="logout">
                                               Sair
                                           </a>
                                       </li>
                                    </ul>
                                </div>
                            </div>
			</nav>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-8" style="margin-left: 15%;">
							<div class="card">
                                                            <div class="header" style="text-align: center;">
                                                                <h4 class="title">Informações do Usuário</h4>
                                                            </div>
                                                            <div class="content">
                                                                    <form action="atualizacao" method="post">
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <label>Código Interno</label>
                                                                                    <input type="text" class="form-control" disabled value="<%= usuario.getId()%>">
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <label>CPF</label>
                                                                                    <input type="text" id="cpf" class="form-control" maxlength="11" placeholder="Cpf" onkeypress="return SomenteNumero(event)" value="<%= usuario.getCpf() %>">
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                    <div class="form-group">
                                                                                            <label for="sexo">Sexo</label>
                                                                                            <select name="sexo" class="form-control">
                                                                                                    <option value="F"> Feminino</option>
                                                                                                    <option value="M"> Masculino</option>
                                                                                            </select>
                                                                                    </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-8">
                                                                                <div class="form-group">
                                                                                    <label>Nome Completo</label>
                                                                                    <input type="text" class="form-control" name="nome"  value="<%= usuario.getNome()%>">
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group">
                                                                                    <label>Data de Nascimento</label>
                                                                                    <input type="data" class="form-control" name="nascimento" maxlength="8"  value="<%= usuario.getDataNascimento() %>">
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-12">
                                                                                <div class="form-group">
                                                                                    <label>E-mail</label>
                                                                                    <input type="email" class="form-control" name="email" value="<%= usuario.getEmail() %>">
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group">
                                                                                    <label>Login</label>
                                                                                    <input type="text" class="form-control" name="login" value="<%= usuario.getUsuario().getLogin() %>">
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group">
                                                                                    <label>Nova Senha</label>
                                                                                    <input type="password" class="form-control" name="senha" placeholder="Nova senha">
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group">
                                                                                    <label>Confirmar Nova Senha</label>
                                                                                    <input type="password" class="form-control" name="cSenha" placeholder="Confirmar senha">
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <input type="submit" id="salva" value="Salvar" title="Salvar alterações">                                
                                                                        <div class="clearfix"></div>
                                                                    </form>
                                                            </div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer class="footer">
				<div id="rodap"class="container-fluid">
					<p id="rodape" class="copyright pull-right">
					<br>
						â‚¢ Todos os direitos reservados | N2S
					</p>
				</div>
			</footer>
		</div>
	</div>
</body>

    <!--   Core JS Files   -->
	<script src="assets/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="assets/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="assets/js/jquery.validate.min.js"></script>

	<script>
		function SomenteNumero(e){
                    var tecla=(window.event)?event.keyCode:e.which;   
                    if((tecla>47 && tecla<58)) return true;
                    else{
                        if (tecla===8 || tecla===0) return true;
                        else  return false;
                    }
		}
	</script>
	

</html>
