<%-- 
    Document   : editarUsuario
    Created on : 02/09/2017, 15:37:05
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.EnumNivel"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Usuario"%>
<%@page import="model.Aluno" %>
<%@page import="util.Facade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>lista de alunos</title>
        
         <meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="../visu/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../visu/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="../visu/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
 <!-- js-->
 <script src="../visu/js/jquery-1.11.1.min.js"></script>
 <script src="../visu/js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="../visu/css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="../visu/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- chart -->
<script src="../visu/js/Chart.js"></script>
<!-- //chart -->

<!-- Metis Menu -->
<script src="../visu/js/metisMenu.min.js"></script>
<script src="../visu/js/custom.js"></script>
<link href="../visu/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

    </head>
    <body class="cbp-spmenu-push">
    <% 
		List<Aluno> usuarios = new ArrayList<Aluno>();	
   		usuarios = (ArrayList<Aluno>)Facade.buscarAlunos() ;
    	
		String mensagem = (String) session.getAttribute("msg");
		
   
	
	%>
    
	<div class="main-content">
            <jsp:include page="../include/menu-left.jsp"></jsp:include>
        <jsp:include page="../include/header-top.jsp" ></jsp:include>
           
            <div id="page-wrapper">
                <div class="container-fluid" style="min-height:400px">
        <!-- aqui-->
                    <div class="col-md-12" >
                            <div class="card">
                                <div class="header" style="text-align: center;">
                                    <h4 class="title">Usuários</h4><hr style="border: 1px solid lightgray">
                                    <div id="busca">
                                        <form action="pesquisaUsuario" method="get">
                                            <input id="txt_busca" type="search" name="busca" placeholder="Buscar por usuários..."/>
                                            <!--  <img style="margin-left: -5%;" src="../assets2/img/busca.png" id="btnBusca" alt="Buscar"  title="Buscar Usuários" onclick="busca()"/> -->
                                            <input style="margin-left: 1%;" class ="btn_pad" type="submit" value="Buscar" title="Buscar Usuários"/>
                                        </form>
                                    </div>
                                    
                                </div>
                                <div id="tabUsuarios">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <th>Matrícula</th>
                                            <th>Nome</th>
                                            <th>E-mail</th>
                                            <th>Nível</th>
                                        </thead>
                                        <tbody>
                                          <% for(Aluno user : usuarios){
 
	                                          %>
                                            <tr>
                                                  <td><%=user.getMatricula() %></td>
                                                  <td><a href="editarNivelDoUsuario.jsp?idUsuario=<%=user.getId() %>"><%=user.getNome()%></a></td>
                                                  <td><%=user.getEmail()%></td>
                                                  <td><%=user.getUsuario().getNivel()%></td>
                                            </tr>                    
                                          <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
		
        
        
        
        <!-- aqui-->
           </div>
            </div>
            <%@include file="../include/footer.jsp" %>
        </div>
            <!-- Classie -->
           <script src="../visu/js/classie.js"></script>
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
        <script src="../visu/js/jquery.nicescroll.js"></script>
        <script src="../visu/js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
        <script src="../visu/js/bootstrap.js"> </script>
        
    </body>
</html>
