<%-- 
    Document   : index
    Created on : 01/09/2017, 19:01:06
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Modulo" %>
<!DOCTYPE html>
<html>
    <head>
        <title>inicio</title>
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

<!-- Metis Menu -->
<script src="visu/js/metisMenu.min.js"></script>
<script src="visu/js/custom.js"></script>
<link href="visu/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

    </head>
    <body class="cbp-spmenu-push">
            <% ArrayList<Modulo> modulos = (ArrayList<Modulo>) session.getAttribute("modulos");%>


	<div class="main-content">
    
        <jsp:include page="include/menu-left.jsp"></jsp:include>
        <jsp:include page="include/header-top.jsp" ></jsp:include>
           
            <div id="page-wrapper">
                <div class="container-fluid" style="min-height:400px">
                   
                        <div class="col-md-12">
                            <div class="card">
                                <div class="header">
                                    <h4 class="title" style="text-align: center;">Módulos do Sistema</h4><hr style="border: 1px solid lightgray">
                                </div>
                                <div class="content all-icons">
                                    <div class="row">

                                        <%  if( !modulos.isEmpty()){
                                            	for(Modulo m: modulos){
                                         %>
                                       <div id="borda" class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                           <div id="centro" class="font-icon-detail" style="text-align: center;">
                                               <img id="img_m" src="<%=m.getImagem()%>"/><br>
                                                <a id="nModulo" href="<%= m.getUrl() %>" ><%=m.getTitulo() %> </a>  
                                           </div>
                                       </div>
                                       <%}}else{%>    
                                    <div>
                                        <p id="text_aviso" style="color: red; font-size: 20px; text-align: center;"> Você não possui módulos cadastrados!</p>  
                                    </div>
                                    <%}%>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                   
            </div>
            </div>
            <jsp:include page="include/footer.jsp"></jsp:include>
            
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

