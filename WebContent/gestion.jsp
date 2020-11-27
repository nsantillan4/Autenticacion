<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="confirmacion.servicios.Usuario"%>
<%@page import="confirmacion.servicios.Servicios"%>
<%@page import="java.util.HashMap , java.util.Map.Entry"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Usuario</h1>
	<%
		Usuario user = (Usuario) request.getAttribute("clave");
	%>
	<table>
		<tr>
			<td>Nombre</td>
			<td><%=user.getNombre() %></td>
		</tr>

		<tr>
			<td>Clave</td>
			<td><%= user.getId()%></td>
		</tr>
	</table>

	<h1>Todos los usuarios</h1>
	<table>

	<%
	Servicios svr = new Servicios();
	HashMap<String, String> usuarios = svr.inicializar();
	for(Entry<String, String> usus : usuarios.entrySet())
	{%>
		<tr>
			<td><jsp:expression> usus.getKey()</jsp:expression></td>
			<td><jsp:expression> usus.getValue()</jsp:expression></td>
		<tr>

	<%}%>	
	</table>
</body>
	</html>
