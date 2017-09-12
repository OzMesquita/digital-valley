<%-- 
    Document   : atribuicaoDeModulos
    Created on : 02/09/2017, 18:19:47
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack"%>
<%@page import="model.Pessoa"%>
<%@page import="model.Modulo"%>
<%@page import="javafx.scene.control.Alert"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../visu/css/wecss.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editar</title>
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
        List<Perfil> perfis = new ArrayList<>();
        
        if(mostra.equals("Perfil")){
            if(session.getAttribute("perfis")!= null){
                perfis = (List<Perfil>) session.getAttribute("perfis");
            }
            else{ 
                perfis = new ArrayList<>();
            }

        }else{
            if(session.getAttribute("usuarios")== null){
                usuarios = new ArrayList<>();
            }
            else{
                usuarios = (List<Pessoa>) session.getAttribute("usuarios");
            }
        }
        //modulos disponiveis
        List<Modulo> modulosDisponiveis = new ArrayList<>() ;
        List<Modulo> modulosCadastrados = new ArrayList<>();
        if(selecionado != null){
            if(session.getAttribute("modulosDisponiveis")== null){
                modulosDisponiveis = new ArrayList<>();
            }
            else{
                modulosDisponiveis = (List<Modulo>) session.getAttribute("modulosDisponiveis");
            }
        //modulos cadastrados
            if(session.getAttribute("modulosCadastrados")== null){
                modulosCadastrados = new ArrayList<>();
            }
            else{
                modulosCadastrados = (List<Modulo>) session.getAttribute("modulosCadastrados");
            }
        }
        String mensagem = (String) session.getAttribute("msg");
        if(mensagem == null){mensagem = "";}
    %>
        
        
        
	<div class="main-content">
        <jsp:include page="../include/menu-left.jsp"></jsp:include>
        <jsp:include page="../include/header-top.jsp" ></jsp:include>
           
            <div id="page-wrapper">
                <div class="container-fluid" style="min-height:400px">
        <!-- aqui-->
        <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title" style="text-align: center;">Módulos do Sistema</h4><hr style="border: 1px solid lightgray">
                                <div class="erroMsg"><small><%= mensagem %><%session.setAttribute("msg", null);%></small></div>
                                <div id="rdio_per">
                                    <form name="btn_buttons">
                                        <ul  id="p_por">
                                            <li><a href="atribuicaoDeModulos.jsp?mostra=Usuarios"> USUÁRIOS</a></li>
                                        	 <li><a href="atribuicaoDeModulos.jsp?mostra=Perfil"> PERFIL </a></li>
                                    	</ul>
                                    </form>
                                </div>
                                <div id="busca">
                                    <form action="pesquisaUsuario" method="get">
                                        <input id="txt_busca" type="search" name="busca" <% if(mostra.equals("Usuarios")){%> autofocus="true" <%}else{%>disabled <%}%> placeholder="Buscar por usuários..."/>
                                        <img style="margin-left: -5%;" src="../../assets2/img/busca.png" id="btnBusca" alt="Buscar"  title="Buscar Usuários" onclick="busca()"/>
                                        <input style="margin-left: 1%;" class ="btn_pad" type="submit" value="Buscar" title="Buscar Usuários" <% if(!mostra.equals("Usuarios")){%>disabled<%}%>/>
                                    </form>
                                </div>
                            </div>
                        </div>
                            <div id="corpo">
                                <div id="centro">
                                    <div id="user1">
                                        <div class="form-group">
                                            <label id="tbl_titu" class="col-md-3" for="selectmultiple"><%= mostra %></label>
                                            <label class="col-md-3" for="selectmultiple">Módulos Disponiveis</label>
                                            <label class="col-md-2" for="selectmultiple">Módulos Cadastrados</label>
                                            <div id="tbls" class="col-md-3">
                                                <select id="selectmultiple" name="selectmultiplePerfil" class="form-control" multiple="multiple" size="15">
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
                                        <div id="">
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
									<form action="AdicionarModulos" method="post" name="modulos">
                                        <div id="">
                                            <div class="form-group">
                                             <!-- <label class="col-md-4 " for="selectmultiple">Módulos Cadastrados</label> -->
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
					                        <input class="btn_pad" id="btn_s" type="submit" value="Salvar" title="Salvar Alterações"/>
					                	</div>
                                        
                                   </form>
                                </div>
                            </div>
                         </div>
        			
        <!-- aqui-->
           </div>
            </div>
        </div>
        <jsp:include page="../include/footer.jsp"></jsp:include>
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
                    var itemSelecionado = x.options[x.selectedIndex].value;
                    document.getElementById('selecionado').value = itemSelecionado;
                    document.location.href = 'pesquisaModulos?busca='+document.getElementById('selecionado').value+'';
                }
        </script>
        
        
        <script src="../visu/js/wejs.js"> </script>
    </body>
</html>
