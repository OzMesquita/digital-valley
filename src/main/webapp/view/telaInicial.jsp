<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Modulo"%>

<div class="cbp-spmenu-push">
	<% ArrayList<Modulo> modulos = (ArrayList<Modulo>) session.getAttribute("modulos");%>

		<div id="page-wrapper">
			<div class="container-fluid" style="min-height: 400px">

				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title" style="text-align: center;">M�dulos do
								Sistema</h4>
							<hr style="border: 1px solid lightgray">
						</div>
						<div class="content all-icons">
							<div class="row">

								<%  if( !modulos.isEmpty()){
                                            	for(Modulo m: modulos){
                                         %>
								<div id="borda"
									class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
									<div id="centro" class="font-icon-detail"
										style="text-align: center;">
										<img id="img_m" src="<%=m.getImagem()%>" /><br>
										<form action="requisitarModulo" method="post">
											<input type="hidden" name="url" value="<%= m.getUrl()%>">
											<input type="submit" id="reqisita" value="Requisitar"
												title="<%=m.getTitulo() %>">
										</form>
									</div>
								</div>
								<%}}else{%>
								<div>
									<p id="text_aviso"
										style="color: red; font-size: 20px; text-align: center;">
										Voc� n�o possui m�dulos cadastrados!</p>
								</div>
								<%}%>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

