<%-- 
    Document   : editarNivelDoUsuario
    Created on : 05/09/2017, 07:28:00
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>
<%@page import="util.Facade"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <%
		Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        String id = request.getParameter("idUsuario");
        
        
        
        
		Pessoa p = Facade.buscarPessoaPorId(id);
		if (p == null) {
		} else {
	%>
        
	<div class="main-content">
            <jsp:include page="include/menu-left.jsp"></jsp:include>
        <jsp:include page="include/header-top.jsp" ></jsp:include>
           
            <div id="page-wrapper">
                <div class="container-fluid" style="min-height:400px">
        <!-- aqui -->
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
        
        <!-- aqui -->
            </div>
            </div>
            <%@include file="include/footer.jsp" %>
        </div>
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