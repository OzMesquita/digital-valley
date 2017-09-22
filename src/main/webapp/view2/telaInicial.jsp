<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@page import="model.Modulo"%>




<div id="tudo" class="wrapper">


	<div class="main-panel"
		style="border: 1px solid; border-radius: 0px 0px 10px 10px;">
		<nav class="navbar navbar-default navbar-fixed">
			<div id="topo" class="container-fluid">
				<div class="navbar-header">
					<a id="textB" class="navbar-brand" href="">Sistema Controle de
						Acesso</a>
				</div>
				<%@ include file="menuDropDown.jsp"%>
			</div>
		</nav>

		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="header">
								<h4 class="title">Módulos do Sistema</h4>
							</div>
							<div class="content all-icons">
								<div class="row">
									<%	if( !modulos.isEmpty()){
										for(Modulo m: modulos){
	                             %>
									<div id="borda"
										class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
										<div id="centro" class="font-icon-detail">
											<img id="img_m" src="<%=m.getImagem()%>" /><br> <a
												id="nModulo" href="<%= m.getUrl() %>"> <%=m.getTitulo() %>
											</a>
										</div>
									</div>
									<%}}else{ %>
									<p id="text_aviso">Você não possui módulos cadastrados!</p>
									<%}%>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>



		</div>

		<footer class="footer">
			<div id="rodap" class="container-fluid">
				<p id="rodape" class="copyright pull-right">
					<br> ₢ Todos os direitos reservados | N2S
				</p>
			</div>
		</footer>

	</div>
</div>


</body>

<!--   Core JS Files   -->
<script src="../assets2/js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="../assets2/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets2/js/jquery.bootstrap.wizard.js"
	type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="../assets2/js/gsdk-bootstrap-wizard.js"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="../assets2/js/jquery.validate.min.js"></script>
<script src="../assets2/js2/drop.js" type="text/javascript"></script>



</html>
