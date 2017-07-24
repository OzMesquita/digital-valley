<%-- 
    Document   : newjspADM
    Created on : 29/06/2017, 20:23:55
    Author     : Usuario
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="../assets2/img/favicon.ico">
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
                #btn_s{margin-left: 85%;}
                #btnBusca{
                    width: 3%;
                    height: 3%;
                }
                #btnBusca:hover{
                    opacity: 0.5;
                }
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
                .selected{background:black;}
                #check{float: right;
                        position: relative;
                        margin-top: 4%;}
                #img-mod{width:40px; height:40px}
                #user1{
                        margin-left: -33.5%;
                        margin-top: 3%;
                }
                #tbl_titu{margin-left: 27%;
                text-align: left;}
                #tbls{margin-left: 27%}
                .form-group label{font-size: 19px;
                }
                .footer{margin-top: 1%;}
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
                                    <input id="txt_busca" type="search"  placeholder="Buscar..."/>
                                    <a href="#"><img src="../assets2/img/busca.png" id="btnBusca" alt="Buscar"  title="Buscar Usuários" onclick="busca()"/></a> 
                                   <!-- <input class ="btn_pad" type="button" value="Buscar" title="Buscar Usuários"/> -->
                                </div>
                            </div>
                        
                        
                        
                        </div>
                        
                        
                            <div id="corpo">
                                <div id="centro">
                                    <div id="user1">
                                        <div class="form-group">
                                            <label id="tbl_titu" class="col-md-3" for="selectmultiple"><script> if(document.write(sessionStorage.getItem('mostra')) === null){ sessionStorage.setItem('mostra',"Perfil")}</script></label>
                                            <label class="col-md-3" for="selectmultiple">Módulos Disponiveis</label>
                                            <label class="col-md-2" for="selectmultiple">Módulos Cadastrados</label>
                                            <div id="tbls" class="col-md-3">
                                                <select id="selectmultiple" name="selectmultiplePerfil" class="form-control" multiple="multiple" size="15">
                                                    <option value="1" onclick="mostra()">Dayvson</option>
                                                    <option value="2" onclick="mostra()">Dharlin</option>
                                                    <option value="3" onclick="mostra()">Francisco Gilberto Lima Paiva</option>
                                                    <option value="4" onclick="mostra()">Tágila </option>
                                                    <option value="5" onclick="mostra()">Option two</option>
                                                    <option value="6" onclick="mostra()">Option two</option>
                                                    <option value="7" onclick="mostra()">Option two</option>
                                                    <option value="8" onclick="mostra()">Option two</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                        <div id="">
                                                <!--  <label class="col-md-4 " for="selectmultiple">Módulos Cadastrados</label>-->
                                            <div class="col-md-3">
                                                  <select id="selectmultipleDisp" name="selectmultipleDisponivel" class="form-control" multiple="multiple" size="15">
                                                    <option value="1" >Option one</option>
                                                    <option value="2" >Option ten</option>
                                                    <option value="3" >Option twenty</option>
                                                    <option value="4" >Option fifty</option>
                                                    <option value="5" >Option sixty</option>
                                                  </select>
                                            </div>
                                                <!--</div> -->
                                        </div>
                                        <div class="form-group">
                                         <!-- <label class="col-md-4 " for="selectmultiple">Módulos Cadastrados</label> -->
                                          <div class="col-md-1">
                                                <div id="">
                                                    <div id="btn_inclui">
                                                        <input id="btn_r" type="button" name="incluir" value=">>" title="Incluir Módulo" onclick="inclui()"/>
                                                    </div>
                                                    <div id="btn_retira">
                                                        <input id="btn_i" type="button" name="retirar" value="<<" title="Remover Módulo" onclick="remove()" />
                                                    </div>
                                                </div>
                                          </div>
                                        </div>

                                        <div id="">
                                            <div class="form-group">
                                             <!-- <label class="col-md-4 " for="selectmultiple">Módulos Cadastrados</label> -->
                                              <div class="col-md-3">
                                                    <select id="selectmultipleCad" name="selectmultipleCadastrado" class="form-control" multiple="multiple" size="15">
                                                      <option value="1" >Option one</option>
                                                      <option value="2" >Option two</option>
                                                      <option value="3" >Option three</option>
                                                      <option value="4" >Option four</option>
                                                      <option value="5" >Option five</option>
                                                    </select>
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
	
</body>
<!--   Core JS Files   -->
	<script src="../assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="../assets2/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../assets2/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="../assets2/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="../assets2/js/jquery.validate.min.js"></script>
        
        <script>
            function busca(){
                var texto = document.getElementById('txt_busca');
                var busca = texto.value;
                alert(busca);
                
                var url = 'pesquisa';
                var parametro = 'idBusca = '+busca;
                var meuAjax = new Ajax.request(url,{
                    method: 'post';
                    parameters: parametro;
                    onComplete: mostraResposta;
                });
                
                
            }
            function mostraResposta(resposta){
                $('selectmultiple').value.resposta.responseText;
                
            }
        </script>
        
        <script>
            function inclui(){
                var novoElemento = document.createElement('option');
                var remove = document.getElementById('selectmultipleDisp');
                var itemSelecionado = remove.options[remove.selectedIndex].text;
                novoElemento.textContent = itemSelecionado;
                var lista = document.getElementById('selectmultipleCad');
                lista.appendChild(novoElemento);
                remove.removeChild(remove.options[remove.selectedIndex]);
            }
        </script>
        
        <script>
            function remove(){
                var novoElemento = document.createElement('option');
                var remove = document.getElementById('selectmultipleCad');
                var itemSelecionado = remove.options[remove.selectedIndex].text;
                novoElemento.textContent = itemSelecionado;
                remove.removeChild(remove.options[remove.selectedIndex]);
                var lista = document.getElementById('selectmultipleDisp');
                lista.appendChild(novoElemento);
            }
        </script>
        
        
       <script>
                function mostra(){
                    var x = document.getElementById('selectmultiple');
                    var itemSelecionado = x.options[x.selectedIndex].text;
                    sessionStorage.setItem("usu_selecionado",itemSelecionado);
                    alert(itemSelecionado);
                }
        </script>
        
        <script>
            function getMostra(){
                var mostra = document.getElementsByName('usuarios');
                
                for (var i = 0; i < mostra.length; i++) {
                    if (mostra[i].checked) {
                        var b = mostra[i].value;
                            if(b === 'sim')
                                    b = "Usuários";
                            else b = "Perfil";
                        sessionStorage.setItem("mostra",b);
                        document.location.reload();
                    }
                }
            }
        </script>   
</html>