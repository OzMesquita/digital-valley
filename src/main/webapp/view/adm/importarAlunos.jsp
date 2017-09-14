<%-- 
    Document   : importarAlunos
    Created on : 04/09/2017, 07:46:42
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>importar alunos</title>
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
<script src="visu/js/Chart.js"></script>
<!-- //chart -->
<!--Calender-->

<!--End Calender-->
<!-- Metis Menu -->
<script src="../visu/js/metisMenu.min.js"></script>
<script src="../visu/js/custom.js"></script>
<link href="../visu/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

    </head>
    <body class="cbp-spmenu-push">
	<div class="main-content">
            <jsp:include page="../include/menu-left.jsp"></jsp:include>
        <jsp:include page="../include/header-top.jsp" ></jsp:include>
           
            <div id="page-wrapper">
                <div class="container-fluid" style="min-height:400px">
        <!-- aqui-->
            <div class="row">
						<div class="col-md-8" style="margin-left: 15%;">
							<div class="card">
                                <div class="header" style="text-align: center;">
                                    <h4 class="title">Importação de Matriculas</h4><hr style="border: 1px solid lightgray">
                                </div>
                                <div class="content">
                                    <form action="importar" method="post" style="margin-left: 20%;">
                                        <div class="row">
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <label>Curso</label>
                                                    <select class="form-control"  name="curso">
                                                        <option disabled="disabled" selected="selected" value="0">Selecione um curso</option>
                                                        <option value="1"> Ciência da Computação</option>
                                                        <option value="2"> Engenharia Civil</option>
                                                        <option value="3"> Engenharia de Produção</option>
                                                        <option value="4"> Engenharia de Software</option>
                                                        <option value="5"> Engenharia Mecânica</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <label>Matriculas</label><small style="color: gray;"> </small><br>
                                                    <textarea name="matriculas" rows="10" cols="50"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <input type="submit" id="salva" value="Importar" title="Importar arquivo">                                
                                        
                                    </form>
                                </div>
							</div>
						</div>
					</div>
        
        <!-- aqui-->
                </div>
            </div>
                <jsp:include page="../include/footer.jsp"></jsp:include>
        
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
