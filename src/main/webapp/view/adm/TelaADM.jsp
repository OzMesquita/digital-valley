<%-- 
    Document   : indexJsp
    Created on : 26/07/2017, 19:07:49
    Author     : Usuario
--%>


<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8" />
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Tela de atribuição</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

	<!-- CSS Files -->
    <link href="../../assets2/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../../assets2/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../../assets2/css/demo.css" rel="stylesheet" />

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
                        border: solid 1px;
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
                #btn_s{margin-left: 83%;}
                #btnBusca{
                    width: 3%;
                    height: 3%;
                    opacity: 0.5;
                }
                
                #rdio_per{
                    font-weight: bold;
                    font-size: 15px;
                    width: 20%;
                    position: absolute;
                }
                #corpo{margin-top: 7%}
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
                #selectmultiple option{
                    font-weight: bold;
                }
                #selectmultipleCad option{
                    font-weight: bold;
                }
                #selectmultipleDisp option{
                    font-weight: bold;
                }
                
                #p_por li{
                    display: inline;
                    margin-left: 5%;
                }
                #selectmultiple option:hover{
                    background: lightgray;
                }
                #selectmultipleCad option:hover{
                    background: lightgray;
                }
                #selectmultipleDisp option:hover{
                    background: lightgray;
                }
	</style>
        
   
       
</head>
	
	
<body>
    <%  
        Pessoa selecionado = null;
        Perfil perfilSelecionado = null;
        String mostra = null;
        
         
        //seleciona o que mostra
        if((String)request.getParameter("mostra") != null){
            mostra = (String) request.getParameter("mostra");
            session.setAttribute("mostra", mostra);
            session.setAttribute("usuarioSelecionado", selecionado);
        }else{
            mostra = (String) session.getAttribute("mostra");
            if(mostra==null){
                mostra = "Usuarios";
                session.setAttribute("mostra", mostra);
                selecionado = null;
                session.setAttribute("usuarioSelecionado", selecionado);
            }
        }
        
        //usuario selecionado
        if(mostra.equals("Usuarios")){
            if(session.getAttribute("usuarioSelecionado")!= null){
                selecionado = (Pessoa) session.getAttribute("usuarioSelecionado");
            }else{
                selecionado = new Pessoa();
            }
        }
        else{
            if(session.getAttribute("perfilSelecionado")!= null){
                perfilSelecionado = (Perfil) session.getAttribute("perfilSelecionado");
            }else{
                perfilSelecionado = new Perfil();
            }
        }
        //fazer pesquisa no banco
       
        
        //usuarios

        List<Pessoa> usuarios = (List<Pessoa>) session.getAttribute("usuarios");
        Vector<Perfil> perfis = new Vector();
        
        if(mostra.equals("Perfil")){
            if(session.getAttribute("perfis")!= null){
                perfis = (Vector<Perfil>) session.getAttribute("perfis");
            }
            else{ 
                perfis = new Vector();
            }
            //perfis.add(new Perfil("Aluno"));
            //perfis.add(new Perfil("Administrador"));
            //perfis.add(new Perfil("Professor"));
            //perfis.add(new Perfil("Secretário"));
            //perfis.add(new Perfil("Servidor"));
        }else{
            if(session.getAttribute("usuarios")== null){
                usuarios = new Vector();
            }
            else{
                usuarios = (List<Pessoa>) session.getAttribute("usuarios");
            }
        }
        //modulos disponiveis
        Vector<Modulo> modulosDisponiveis = new Vector();
        Vector<Modulo> modulosCadastrados = new Vector();
        if(selecionado != null){
            if(session.getAttribute("modulosDisponiveis")== null){
                modulosDisponiveis = new Vector();
            }
            else{
                modulosDisponiveis = (Vector) session.getAttribute("modulosDisponiveis");
            }
        //modulos cadastrados
            if(session.getAttribute("modulosCadastrados")== null){
                modulosCadastrados = new Vector();
            }
            else{
                modulosCadastrados = (Vector) session.getAttribute("modulosCadastrados");
            }
        }
    %>
    
	<div id ="tudo" class="wrapper">
	    <div class="main-panel">
	        <nav class="navbar navbar-default navbar-fixed">
	            <div id ="topo" class="container-fluid">
	                <div class="navbar-header">
	                    <a id="textB" class="navbar-brand" >Sistema Controle de Acesso</a>
	                </div>
	                <div class="collapse navbar-collapse">
	                    <ul class="nav navbar-nav navbar-right">
	                         <li>
                                     <a id="textB" title="Fazer logout" href="logout.jsp">
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
                                    Pesquisar por:
                                    <form name="btn_buttons">
                                        <ul  id="p_por">
                                            <li><a href="TelaADM.jsp?mostra=Usuarios" >USUÁRIOS</a></li>
                                            <li><a href="TelaADM.jsp?mostra=Perfil" >PERFIL</a></li>
                                        </ul>
                                    </form>
                                </div>
                                <div id="busca">
                                    <form action="pesquisaUsuario" method="get">
                                        <input id="txt_busca" type="search" name="busca" <% if(mostra.equals("Usuarios")){%> autofocus="true" <%}else{%>disabled <%}%> placeholder="Buscar por usuários..."/>
                                        <img style="margin-left: -5%;" src="assets2/img/busca.png" id="btnBusca" alt="Buscar"  title="Buscar Usuários" onclick="busca()"/>
                                        <input style="margin-left: 1%;" class ="btn_pad" type="submit" value="Buscar" title="Buscar Usuários" <% if(!mostra.equals("Usuarios")){%>disabled<%}%>/>
                                    </form>
                                </div>
                            </div>
                        </div>
                       
                            <div id="corpo" >
                                <div id="centro">
                                    <form action="indexJsp.jsp" method="post" name="modulos">
                                        <div id="user1">
                                            <div class="form-group">
                                                <label id="tbl_titu" class="col-md-3" for="selectmultiple"> <%= mostra %> </label>
                                                <label class="col-md-3" for="selectmultiple">Módulos Disponiveis</label>
                                                <label class="col-md-2" for="selectmultiple" style="width: 20%;">Módulos Cadastrados</label>
                                                <div id="tbls" class="col-md-3">
                                                    <input type="hidden" id="selecionado" name="usuarioSelecionado" value=""/>
                                                    <select id="selectmultiple" name="selectmultiplePerfil" required class="form-control" multiple="multiple" size="15">
                                                        <%if(usuarios != null || perfis!= null){
                                                            if(mostra.equals("Perfil")){ 
                                                                for(int i=0;i<perfis.size();i++){%>
                                                                    <option value="<%= perfis.get(i) %>" onclick="mostra()" <%if(perfilSelecionado!= null){if(perfis.get(i).getId() == perfilSelecionado.getId()){%>selected="true"<%}}%>><%= perfis.get(i).getNome() %> </option> 
                                                            <%}}else{
                                                                for(int i=0;i<usuarios.size();i++){%>
                                                                    <option value="<%= usuarios.get(i).getId() %>" onclick="mostra()" <%if(selecionado!= null){if(usuarios.get(i).getId() == selecionado.getId()){%>selected="true"<%}}%>><%= usuarios.get(i).getNome() %> </option>
                                                            <%}}
                                                        }else{%>
                                                            <option disabled="disable">(Faça uma busca por usuário)</option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                        </div> 
                                    </form>
                                    <div >
                                            <!--  <label class="col-md-4 " for="selectmultiple">Módulos Cadastrados</label>-->
                                        <div class="col-md-3">
                                              <select id="selectmultipleDisp" name="selectmultipleDisponivel" class="form-control" multiple="multiple" size="15">
                                                <%if(selecionado!= null){
                                                     for(int i=0;i<modulosDisponiveis.size();i++){%>
                                                        <option value="<%= modulosDisponiveis.get(i).getId() %>"><%= modulosDisponiveis.get(i).getTitulo() %> </option>  
                                                    <%}}else{%>
                                                    <option disabled="disable">(Selecione algum usuário)</option>
                                                <%}%>


                                              </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                      <div class="col-md-1">
                                            <div >
                                                <div id="btn_inclui">
                                                    <input id="btn_r" type="button" name="incluir" value=">>" title="Incluir Módulo" onclick="inclui()"/>
                                                </div>
                                                <div id="btn_retira">
                                                    <input id="btn_i" type="button" name="retirar" value="<<" title="Remover Módulo" onclick="remove()" />
                                                </div>
                                            </div>
                                      </div>
                                    </div>

                                    <form action="adm" method="post" name="modulos">
                                        <div >
                                            <div class="form-group">
                                                <div class="col-md-3">
                                                    <select id="selectmultipleCad" name="selectmultipleCadastrado" class="form-control" multiple="multiple" size="15">
                                                        <%if(selecionado!= null){
                                                            for(int i=0;i<modulosCadastrados.size();i++){%>
                                                                <option value="<%= modulosCadastrados.get(i).getId() %>" ><%= modulosCadastrados.get(i).getTitulo() %></option>
                                                        <%}}else{%>
                                                            <option disabled="disable">(Selecione algum usuário)</option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="btn_salva">
                                            <input type="hidden" id="lista" name="lista">
                                            <input class="btn_pad" id="btn_s" style=" margin-top: 1%; " type="submit" value="Salvar" title="Salvar Alterações" onclick="selecionaTudo()"/>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            
                        
                         </div>
                     </div>
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
	<script src="../assets/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../assets/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="../assets/js/gsdk-bootstrap-wizard.js"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="../assets/js/jquery.validate.min.js"></script>
        
        <script>
            function selecionaTudo(){
                var selecionados = document.getElementById('selectmultipleCad');
                for(i=0; i < selecionados.length;i++){
                    selecionados.options[i].selected = true;
                }
                document.getElementById('lista').value = selecionados;
            }
        </script>

        <script>
            function mostraResposta(resposta){
                var remove = document.getElementById('selectmultipleDisp');
                remove.removeChild(remove.options);
                
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
                    document.getElementById('selecionado').value = itemSelecionado;
                    document.location.href = 'PesquisaModulos?busca='+document.getElementById('selecionado').value+'';
                }
        </script>
        
       
</html>

