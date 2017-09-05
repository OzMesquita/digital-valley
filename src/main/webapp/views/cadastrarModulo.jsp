<%-- 
    Document   : importarServidores
    Created on : 04/09/2017, 09:10:07
    Author     : Usuario
--%>

<%@page import="util.Facade"%>
<%@page import="model.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@page import="model.Modulo" %>
<!DOCTYPE html>
<html>
    <head>
                <title>importar servidores</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="visu/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="visu/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="visu/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
 <!-- js-->
 <script src="visu/js/jquery-1.11.1.min.js"></script>
 <script src="visu/js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="visu/css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="visu/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- chart -->
<script src="visu/js/Chart.js"></script>
<!-- //chart -->
<!--Calender-->

<!--End Calender-->
<!-- Metis Menu -->
<script src="visu/js/metisMenu.min.js"></script>
<script src="visu/js/custom.js"></script>
<link href="visu/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

    </head>
    <body class="cbp-spmenu-push">
        <%  String mensagem = (String)session.getAttribute("msg");
            if(mensagem == null){
                mensagem = "";
            }
         %>

	<div class="main-content">
            <jsp:include page="include/menu-left.jsp"></jsp:include>
        <jsp:include page="include/header-top.jsp" ></jsp:include>
           
            <div id="page-wrapper">
                <div class="container-fluid" style="min-height:400px">
        
                    <!-- aqui -->
                    <div class="row">
                            <div class="col-md-6 " style="margin-left: 25%;">
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title" style="text-align: center;">Cadastro de Módulo</h4><hr style="border: 1px solid lightgray">
                                    </div>
                                    <div class="erroMsg"><small><%= mensagem %><%session.setAttribute("msg", null);%></small></div>
                                    <div class="content">
                                        <div id="corpo">
                                            <div id="centro">
                                                <form method="post" action="adm/cadastrarModulo" name="formCadastro" >
                                                    <label for="titulo" >Título</label><input type="text" title="Preencha este campo" name="titulo" required class="form-control"><br>
                                                    <label for="url" >URL</label><input type="text" title="Preencha este campo" name="url" required class="form-control"><br>
                                                    <label for="imagem" >Imagem</label><input type="file" title="Preencha este campo" name="imagem" ><br>
                                                    <label for="perfil" >Perfil de Acesso</label><br>
                                                    <div style="margin-left: 3%">
                                                        <input type="checkbox" class="marcar" name="todos" value="" onclick="marcardesmarcar()"> Todos<br>
                                                        <%
                                                        	List<Perfil> perfis = Facade.ListarPeril();
                                                        	for(Perfil p: perfis){
                                                        %>
                                                        		<input  type="checkbox" class="marcar" name="<%=p.getNome() %>" value="ok"> <%=p.getNome() %><br>                                                        
                                                        <%} %>
                                                    </div>
                                                    <div style="margin-top: 0% !important">
                                                        <input id="btn_confirma" type="submit" value="Salvar" title="Salvar módulo">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    
                    <!-- aqui -->
 </div>
            </div>
                <jsp:include page="include/footer.jsp"></jsp:include>
        
             <!-- Classie -->
           <script src="visu/js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			

			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!--scrolling js-->
        <script src="visu/js/jquery.nicescroll.js"></script>
        <script src="visu/js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
        <script src="visu/js/bootstrap.js"> </script>
        </body>
</html>

