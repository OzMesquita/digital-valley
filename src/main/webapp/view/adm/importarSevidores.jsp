<%-- 
    Document   : importarMatriculas
    Created on : 25/07/2017, 19:32:04
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Importação de servidores</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

	<!-- CSS Files -->
    <link href="../assets2/css/bootstrap.min.css" rel="stylesheet" />
	<link href="../assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="../assets2/css/demo.css" rel="stylesheet" />
	
	
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
			margin-left: 60%;	
		}
                .footer{margin-top: 1%;}

	</style>
        
</head>
<body>
	<%if(session.getAttribute("excecao")!= null){ %>
		<p><%=session.getAttribute("excecao") %></p>
	<% 
		session.removeAttribute("excecao");
	}%>


	<div id ="tudo" class="wrapper">   
		<div class="main-panel" style=" border: 1px solid; border-radius:10px;">
			<nav class="navbar navbar-default navbar-fixed">
                <div id ="topo" class="container-fluid">
                    <div class="navbar-header">
                        <a id="textB" class="navbar-brand" href="">Sistema Controle de Acesso</a>
                    </div>
                     <%@ include file="menuDropDown.jsp"  %>
                </div>
			</nav>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-8" style="margin-left: 15%;">
							<div class="card">
                                <div class="header" style="text-align: center;">
                                    <h4 class="title">Importação de Servidores</h4>
                                </div>
                                <div class="content">
                                    <form action="importar" method="post" style="margin-left: 20%;">
                                        <div class="row">
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <label>Matriculas</label><small style="color: gray;"> </small><br>
                                                    <textarea name="matriculas" rows="10" cols="50"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <input type="submit" id="salva" value="Importar" title="Importar matriculas">                                
                                        
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
						₢ Todos os direitos reservados | N2S
					</p>
				</div>
			</footer>
		</div>
	</div>
</body>

    <!--   Core JS Files   -->
	<script src="../assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="../assets2/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../assets2/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="../assets/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="../assets/js/jquery.validate.min.js"></script>

	

</html>

