<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="confirmacion.servicios.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="clave" scope="request" class="confirmacion.servicios.Usuario" />
<meta charset="ISO-8859-1">
<title>Muestra</title>
</head>
<body>
	Nombre: <jsp:getProperty name="clave" property="nombre" />
   ID:  <jsp:getProperty name="clave" property="id" />
</body>
</html>