<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastre-se</title>
</head>
<body>
	<a href="verificacaoCadastro.jsp?tipoUsuario=1">Aluno</a>
	<a href="verificacaoCadastro.jsp?tipoUsuario=2">Servidor</a>

<% if(request.getParameter("tipoUsuario").equals("1")){%>
	<form method="post" action="verificacao" >
		<label for="matricula" >Matricula</label><input type="text" name="matricula" ><br>
		<label for="nome" >Nome Completo</label><input type="text" name="nome" ><br>
		<input type="submit" value="Confirmar" >
	</form>
<% } %>	
	
<% if(request.getParameter("tipoUsuario").equals("2")){%>
	<form method="post" action="verificacao" >
		<label for="siape" >SIAPE</label><input type="text" name="siape" ><br>
		<label for="nome" >Nome Completo</label><input type="text" name="nome" ><br>
		<input type="submit" value="Confirmar" >
	</form>
<% } %>	
</body>
</html>