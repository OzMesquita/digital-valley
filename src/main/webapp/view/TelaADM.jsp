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
		#txt_busca{width: 25%;
			border-radius: 10px;
			height: 35px;
		}
		.btn_pad{background: steelblue;
			color: white;
			border-radius: 8%;
			width: 06%;
			height: 35px;
		}
		#busca{position: absolute;
			left: 40%;
			width: 90%;
		}
                #users,#acesso, #sem_acesso{width: 25%;
                    border-style: solid;
                    border-width: 2px;
                    height: auto;
                }
                #acesso{
                    position: absolute;
                    margin-left: 70%;
                    margin-top: -15.1%;}
                #sem_acesso{
                    position: absolute;
                    margin-left: 30%;
                    margin-top: -15.1%;}
                #botoes{width: 10%;
                    position: absolute;
                    margin-left: 60%;
                    margin-top: -10%;
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
	</style>
</head>
	
	
<body>

	
	
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <div id="rdio_per">
                                    <input type="radio" name="webmaster" value="usuarios"/> USUÁRIOS<br />
                                    <input type="radio" name="webmaster" value="perfil"/> PERFIL<br />
                                </div>
                              <div id="busca">
                                  <input id="txt_Busca" type="text"  placeholder="Buscar..."/>
                                  <!--  <img src="search3.png" id="btnBusca" alt="Buscar"/> -->
                                  <input class ="btn_pad" type="button" value="Buscar" title="Buscar Usuários"/>
                              </div>
                              
                            </div>
							<div id="corpo">
								<div >
									<div id="users">
									  <table class="table table-hover table-striped">
										<thead>
											<th>Usuários</th>
										</thead>
											<tbody>
												<tr><td>testando</td></tr>
												<tr><td>testando</td></tr>
												<tr><td>testando</td></tr>
												<tr><td>testando</td></tr>
											</tbody>
									  </table>
									</div>
									<div id="sem_acesso">
										  <table class="table table-hover table-striped">
										<thead>
											<th>Módulos Disponiveis</th>
										</thead>
										  <tbody>
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
											<tbody>
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
	<script src="../assets2/js/jquery.validate.min.js"></script>
   
</html>