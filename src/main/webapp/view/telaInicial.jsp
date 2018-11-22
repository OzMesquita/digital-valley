<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Modulo"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% ArrayList<Modulo> modulos = (ArrayList<Modulo>) session.getAttribute("modulos");%>

<section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">Módulos do Sistema</h1>
          <p class="lead text-muted">Estes são os módulos disponíveis para você.</p>
        </div>
      </section>
 <div class="album py-5 bg-light">
	<div class="container" align="center">
		<%if(session.getAttribute(Constantes.getSessionMsg()) != null){ %>
		<div class="alert alert-danger" role="alert">
			<%=session.getAttribute(Constantes.getSessionMsg()) %>
		</div>
					<%session.setAttribute(Constantes.getSessionMsg(), null); %>
					
				<%} %>
​
 <div class="row">
 <!-- -->
 	<%if( modulos !=null && !modulos.isEmpty()){
     	for(Modulo m: modulos){
    %>
      <div class="col-md-3" style="margin-top: 0px;">
       <div class="card mb-3 shadow-sm" align="center">
        <a href="<%=Constantes.getAppUrl()%>/requisitarModulo?url=<%=m.getUrl() %>"> <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 150px; width: 150px; display: block;" src="<%=m.getImagem()%>" data-holder-rendered="true"></a>
        <div class="card-body">
         <p class="card-text"><p><h4><%=m.getTitulo()%></h4></p><%=(m.getDescricao() != null) ? m.getDescricao() : "Sem descrição" %></p>
         <div class="d-flex justify-content-between align-items-center">
          <div class="btn-group" style="width:100%;">
           <a class="btn btn-primary" style="width:100%;" href="<%=Constantes.getAppUrl()%>/requisitarModulo?url=<%=m.getUrl() %>">Abrir</a> 
          </div>
         </div>
        </div>
       </div>
      </div>
      
    <%}}%>
  </div>
 </div>
 
 </div>
 

