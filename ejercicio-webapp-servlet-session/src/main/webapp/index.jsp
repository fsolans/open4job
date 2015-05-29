<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Servlet basico</h1>

	<!-- Redirecciona a /appServlet enviando los datos  -->
	<form action="./appServlet">
		<span class="label label-primary">Edad:</span> 
		<input type="text"name="edad"/> Nombre: 
		<input type="text" name="nombre"/>
		<input type="submit" class="btn btn-primary btn" role="button"
			value="Enviar al servlet"/>
	</form>

</body>
</html>