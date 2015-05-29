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

	<%
		String nombre = session.getAttribute("nombre").toString();
		String edad = session.getAttribute("edad").toString();
	%>
	<p>
		Hola <%=nombre%>, tu edad es de <%=edad%> años
	</p>

</body>
</html>