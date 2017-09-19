<%@page import="model.Usuario"%>
<%@page import="util.Constantes"%>
<% Usuario u = (Usuario) session.getAttribute("usuario"); %>
<script src="../visu/js/metisMenu.min.js"></script>
<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
                    <div class="navbar-collapse">
                        <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                            <ul class="nav" id="side-menu">
                                <li>
                                    <a href="<%=Constantes.APP_URL %>/view/telaInicial.jsp" class="active"><i class="fa fa-home nav_icon"></i>Inicio</a>
                                </li>
                                <% if(u.getNivel().toString().toLowerCase().equals("administrador")){%>
                                
                                <li>
                                    <a href="#"><i class="fa fa-cogs nav_icon"></i>Importar matr�culas <span class="fa arrow"></span></a>
                                    <ul class="nav nav-second-level collapse">
                                        <li>
                                            <a href="<%=Constantes.ADM_URL %>/importarAlunos.jsp">Alunos</a>
                                        </li>
                                        <li>
                                            <a href="<%=Constantes.ADM_URL %>/importarServidores.jsp">Servidores</a>
                                        </li>
                                    </ul>
                                </li>

                                <li>
                                    <a href="#"><i class="fa fa-th-large nav_icon"></i>Modulos<span class="fa arrow"></span></a>
                                    <ul class="nav nav-second-level collapse">
                                        <li>
                                            <a href="<%=Constantes.ADM_URL %>/atribuicaoDeModulos.jsp">Atribuir m�dulos <span class="nav-badge-btm"></span></a>
                                        </li>
                                        <li>
                                            <a href="<%=Constantes.ADM_URL %>/cadastrarModulo.jsp">Cadastrar m�dulo</a>
                                        </li>
                                    </ul>
                                </li>

                                <li>
                                    <a href="#"><i class="fa fa-check-square-o nav_icon"></i>Usu�rios <span class="fa arrow"></span></a>
                                    <ul class="nav nav-second-level collapse">
                                        <li>
                                            <a href="<%=Constantes.ADM_URL %>/listaDeUsuarios.jsp">Listar Usu�rios <span class="nav-badge-btm"></span></a>
                                        </li>
                                      
                                    </ul>
                                </li>
                                <%} %>
                            </ul>
                            
                           
                            
                            <!-- //sidebar-collapse -->
                        </nav>
                    </div>
		</div>
		<!--left-fixed -navigation-->
		