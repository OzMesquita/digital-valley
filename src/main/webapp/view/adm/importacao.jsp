<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Importação de Dados</title>
</head>
<body>
	<form method="post" action="importar" enctype="multipart/form-data" >
	<label>Curso</label>
		<select name="curso">
			<option value="1">Ciencia da Computação</option>
			<option value="3">Engenharia de Software</option>
			<option value="3">Engenharia Civil</option>
		</select><br>
		
		<label>Arquivo</label>	
		<input type="file" name="arquivo" ><br>
		<input type="submit" value="enviar" >
	</form><br>
	
	


</body>
</html>