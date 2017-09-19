<%@page import="util.Constantes"%>
<%@page import="model.Usuario"%>
<%@page import="model.Pessoa"%>

<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<!--logo -->
				<div class="logo">
					<a href="telaInicial.jsp">
						<h1>Sistema</h1>
						<span><b>Controle de Acesso</b></span>
					</a>
				</div>
				<!--//logo-->
				
				<div class="clearfix"> </div>
			</div>
			<div class="header-right">
				<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<span class="prfil-img"><img src="<%=Constantes.APP_URL %>/view/visu/images/2.png" alt=""> </span> 
									<div class="user-name">
										<p><%=usuario.getLogin() %></p>
										<span><%=usuario.getNivel() %></span>
									</div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">
								
								<li> <a href="<%=Constantes.APP_URL %>/view/editarUsuario.jsp"><i class="fa fa-user"></i> Perfil</a> </li> 
								<li> <a href="<%=Constantes.APP_URL %>/logout"><i class="fa fa-sign-out"></i> Logout</a> </li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>				
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->