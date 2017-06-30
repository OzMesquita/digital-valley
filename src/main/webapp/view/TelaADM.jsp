<%-- 
    Document   : newjspADM
    Created on : 29/06/2017, 20:23:55
    Author     : Usuario
--%>

<%@page import="model.Modulo"%>
<%@page import="java.util.Vector"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>lista de usuários</title>

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
		#txt_busca{width: 45%;
			border-radius: 10px;
			height: 35px;
		}
		.btn_pad{background: steelblue;
			color: white;
			border-radius: 8%;
			width: 10%;
			height: 35px;
		}
		#busca{position: absolute;
			left: 30%;
			width: 70%;
		}
                #users,#acesso, #sem_acesso{width: 25%;
                    border-style: solid;
                    border-width: 2px;
                    border-radius: 10px;
                    height: auto;
                }
                #acesso{
                    position: relative;
                    margin-left: 70%;
                     /*margin-top: -41%;*/
                    margin-top: -29.5%;
                }
                #sem_acesso{
                    position: relative;
                    margin-left: 30%;
                    margin-top: -29.5%;}
                #botoes{width: 10%;
                    position: absolute;
                    margin-left: 60%;
                    margin-top: -23%;
}
                #btn_inclui{height: 50px;
                    width: 60px;
                }
                #btn_i{background: steelblue;
                    height: 80%;
                    width: 90%;
                    color: white;
                    font-weight: bold;
                }
                #btn_retira{
                    height: 50px;
                    width: 60px;
                }
                #btn_r{background: steelblue;
                    height: 80%;
                    width: 90%;
                    color: white;
                    font-weight: bold;
                }
                #btn_salva{margin-top: 3%;}
                th{text-align: center;}
                #btn_s{margin-left: 90%;}
                #rdio_per{
                    font-weight: bold;
                    font-size: 15px;
                    width: 10%;
                    position: absolute;
                }
                #corpo{margin-top: 6%}
                #centro{}
                .ativo{
                    background: steelblue;
                    color: white;
                }
                #linhas tr:hover{background: steelblue;
                    color: white;}
                #linhas:visited{background: blueviolet;}
	</style>
        
        
       
</head>
	
	
<body>
    <% if(session.getAttribute("mostra") == null){
            String user = "Usuários";
            session.setAttribute("mostra", user); 
        }
   
    
       Vector<Usuario> usuarios = (Vector<Usuario>) session.getAttribute("usuarios");
       
       if(session.getAttribute("usuario_selecionado")!= null){
           Vector<Modulo> modulos = (Vector<Modulo>) session.getAttribute("modulos_usuario");
       }


    %>
	
	
	<div id ="tudo" class="wrapper">
	    
	    <div class="main-panel">
	        <nav class="navbar navbar-default navbar-fixed">
	            <div id ="topo" class="container-fluid">
	                <div class="navbar-header">
	                    <a id="textB" class="navbar-brand" >Lista de Usuários</a>
	                </div>
	                <div class="collapse navbar-collapse">
	                    <ul class="nav navbar-nav navbar-right">
	                         <li>
	                            <a id="textB" href="login.jsp">
	                                Sair
	                            </a>
	                        </li>
	                    </ul>
	                </div>
	            </div>
	        </nav>
	
                <div class="content">
                <div class="container-fluid">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <div id="rdio_per">
                                    <form name="btn_buttons">
                                        <input type="radio" name="usuarios" value="sim"  onclick="getMostra()"/> USUÁRIOS<br />
                                        <input type="radio" name="usuarios" value="nao" onclick="getMostra()"/> PERFIL <br />
                                    </form>
                                </div>
                                <div id="busca">
                                    <input id="txt_busca" type="text"  placeholder="Buscar..."/>
                                    <!--  <img src="search3.png" id="btnBusca" alt="Buscar"/> -->
                                    <input class ="btn_pad" type="button" value="Buscar" title="Buscar Usuários"/>
                                </div>
                            </div>
                            <div id="corpo">
                                    <div id="centro">
                                            <div id="users">
                                                <jsp:include page="partsTabelaUsuario.jsp"/>
                                            </div>
                                            <div id="sem_acesso">
                                                <table class="table table-hover table-striped">
                                                    <thead>
                                                        <th>Módulos Disponiveis</th>
                                                    </thead>
                                                    <tbody id="linhas">
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                    </tbody>
                                              </table>
                                            </div>
                                            <div id="acesso">

                                                <table class="table table-hover table-striped">
                                                    <thead>
                                                        <th>Módulos Cadastrados</th>
                                                    </thead>
                                                    <tbody id="linhas">
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>
                                                        <tr><td>testando</td></tr>                       
                                                        <tr><td>testando</td></tr>                       
                                                        <tr><td>testando</td></tr>                       
                                                        <tr><td>testando</td></tr>                       
                                                        <tr><td>testando</td></tr>                       
                                                        <tr><td>testando</td></tr>                       
                                                        <tr><td>testando</td></tr>                       
                                                        <tr><td>testando</td></tr>                       
                                                  </tbody>
                                                </table>
                                            </div>
                                            <div id="botoes">
                                                <div id="btn_inclui">
                                                    <input id="btn_r" type="button" name="incluir" value=">>" title="Incluir Módulo"/>
                                                </div>
                                                <div id="btn_retira">
                                                    <input id="btn_i" type="button" name="retirar" value="<<" title="Remover Módulo"/>
                                                </div>
                                            </div>
                                    </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div id="btn_salva">
                    <input class="btn_pad" id="btn_s" type="submit" value="Salvar" title="Salvar Alterações"/>
            </div>
                                                    </div>
            <div>
	       <footer class="footer">
	            <div id="rodap" class="container-fluid">
	                <p id="rodape" class="copyright pull-right">
                        <br>
	                    ₢ Todos os direitos reservados | N2S
	                </p>
	            </div>
	        </footer>
            </div>
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
	<script src="assets2/js/jquery.validate.min.js"></script>
        
        <script type="text/javascript">
            $(#mytable > tbody > tr > td).on('click','tr' ,function (e)){
                $(this).siblings().removeClass('ativo');
                $(this).toggleClass('ativo');
            };
        </script>
        
        <script>
            function getMostra(){
                var mostra = document.getElementsByName('usuarios');
                
                for (var i = 0; i < mostra.length; i++) {
                    if (mostra[i].checked) {
                        var b = mostra[i].value;
                        sessionStorage.setItem("mostra",b);
                        document.location.reload();
                    }
                }
            }
        </script>
   
</html>