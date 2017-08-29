<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets2/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Alterar nivel do usuário</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

	<!-- CSS Files -->
    <link href="../../assets2/css/bootstrap.min.css" rel="stylesheet" />
	<link href="../../assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="../../assets2/css/demo.css" rel="stylesheet" />
     <link href="../../assets2/css2/drop.css" rel="stylesheet" type="text/css" media="all" />
	
	
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
			width: 110px;
			height: 30px;
			color: white;
			margin-left: 30%;	
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

	</style>
	
</head>
<body >
	<%
		Usuario usuarioDaSessao = (Usuario) session.getAttribute("usuario");
		Pessoa p = (Pessoa) session.getAttribute("pessoa");
		if (p == null) {
		} else {
	%>


<div id ="tudo" class="wrapper">
    
    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div id ="topo" class="container-fluid">
                <div class="navbar-header">
                    
                    <a id="textB" class="navbar-brand" href="">Perfil do Usuário</a>
                </div>
                 <%@ include file="../menuDropDown.jsp"  %>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Perfil do Usuário</h4>
                            </div>
                            <div class="content">
                                <form action="AlterarEmail" method="post">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Código</label>
                                                <input type="text" class="form-control" disabled  value="<%= p.getId()%>">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>CPF</label>
                                                <input type="text" id="cpf" class="form-control" disabled  value="<%= p.getCpf()%>">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>Nome do Usuário</label>
                                                <input type="text" class="form-control" disabled value="<%= p.getNome()%>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Data de Nascimento</label>
                                                <input type="text" class="form-control" disabled value="<%= p.getDataNascimento()%>">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>E-mail</label>
                                                <input type="text" name="email" class="form-control" required value="<%=p.getEmail()%>">
                                            </div>
                                        </div>
                                    </div>

                                		                                   
                                    <div class="clearfix"></div>
                                    <input id="save"  type="submit" value="Salvar">
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card card-user">
                            
                            <div class="content">
                                <div class="author">
                                     <form id="nivelUsuario" action="AlterarNivel" method="post">
										<div class="header">
											<label>Nivel do Usuário</label>
											
										</div>
										<select class="form-control" name="nivel" required>
											<option disabled="disable" selected="true" > <%=p.getUsuario().getNivel() %></option>
											<option value="comum">Usuário Comum</option>										
											<option value="administrador">Administrador</option>
										</select>
										
										<input id="save"  type="submit" value="Salvar">
									</form>
                                </div>
                                
                                <br>
                                                                  
                            </div>
                            <hr>
                        </div>
                    </div>

                </div>
            </div>
        </div>


        <footer class="footer">
            <div id="rodap"class="container-fluid">
                <p id="rodape" class="copyright pull-right">
				<br>
                    ₢ Todos os direitos reservados | N2S
                </p>
            </div>
        </footer>

    </div>
</div>

<%} %>
</body>

    <!--   Core JS Files   -->
	<script src="../../assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="../../assets2/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../../assets2/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="../../assets2/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="../../assets2/js/jquery.validate.min.js"></script>
    <script src="../../assets2/js2/drop.js"></script>


</html>
