<%@ page import="com.educacionit.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Mi primera Sesion</title>
</head>

<body>
	<%
	String mensaje = (String) request.getAttribute("mensaje");
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	String id = (String) request.getAttribute("id");
	
	if(usuario != null){
		response.sendRedirect("formulario.jsp");
	}else{
	%>

	<h1><%=mensaje %></h1>
	<h2><%=usuario.getCorreo(); %></h2>
	<h3><%="Numero de sesion: " + id %></h3>
	<%
	}
	%>
</body>
</html>