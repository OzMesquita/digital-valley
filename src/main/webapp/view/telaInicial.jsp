<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@page import="model.Modulo" %>>

<!doctype html>
<html lang="pt">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>módulos do sistema</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

	<!-- CSS Files -->
    <link href="../assets2/css/bootstrap.min.css" rel="stylesheet" />
	<link href="../assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="../assets2/css/demo.css" rel="stylesheet" />
	<!-- meu css -->
	<link rel="stylesheet" href="../assets2/css/newcss.css"/>
	


</head>
<body>
	<% List<Modulo> modulos = (List<Modulo>) session.getAttribute("modulos");	%>

<div id="tudo" class="wrapper">
    

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div id="topo" class="container-fluid">
                <div class="navbar-header">
                    <a id="textB" class="navbar-brand" href="">Módulos do Sistema</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a id="textB" href="logout">
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Módulos do Sistema</h4>
                            </div>
                            <div class="content all-icons">
                                <div class="row">
                                <%	
                                for(Modulo m: modulos){
	                                	
	                             %>
                                    <div id="borda" class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                    <div id="centro" class="font-icon-detail">
										<img src="<%=m.getImagem()%>"/><br>
										 <a id="nModulo" href="<%= m.getUrl() %>" > <%=m.getTitulo() %> </a>  
                                    </div>
                                     
                                  </div>
                                  <%} %>
                              
                                </div>
                               
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <a href="EditarNivel.jsp">editar Nivel dos usuários</a>
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
	<script src="../assets2/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="../assets2/js/jquery.validate.min.js"></script>


</html>
