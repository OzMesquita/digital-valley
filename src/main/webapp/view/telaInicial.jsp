<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Modulo"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="cbp-spmenu-push">
	<% ArrayList<Modulo> modulos = (ArrayList<Modulo>) session.getAttribute("modulos");%>

		<div id="page-wrapper">
			<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
					<div class="alert alert-danger" role="alert">
  						<%=session.getAttribute(Constantes.getSessionMsg()) %>
					</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
				<%} %>
				<div >
					
						<div class="header">
							<h4 class="title" style="text-align: center;">Módulos do
								Sistema</h4>
							<hr style="border: 1px solid lightgray">
						</div>
							<div class="row">

								<%  if( modulos !=null && !modulos.isEmpty()){
                                            	for(Modulo m: modulos){
                                         %>
								<div
									class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
									<div id="centro" class="font-icon-detail"
										style="text-align: center;">
										<img id="img-modulos" alt="<%=m.getTitulo() %>" src="<%=m.getImagem()%>" /><br>
										<form action="requisitarModulo" method="post">
											<input type="hidden" name="url" value="<%= m.getUrl()%>">
											<input type="submit" id="btn-modulo" value="<%=m.getTitulo()%>"
												title="<%=m.getTitulo() %>">											
										</form>
									</div>
								</div>
								<%}}else{%>
								<div>
									<p id="text_aviso"
										style="color: red; font-size: 20px; text-align: center;">
										Você não possui módulos cadastrados!</p>
								</div>
								<%}%>
							</div>

						</div>
		</div>
	</div>

