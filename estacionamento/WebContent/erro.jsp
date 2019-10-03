<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="utf-8">
<title>Avenger´s Park</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<c:set var="code" value='<%=   request.getAttribute("javax.servlet.error.status_code") %>'/>
	<c:set var="exception" value='<%= request.getAttribute("javax.servlet.error.exception") %>'/>
	<c:set var="message" value='<%= request.getAttribute("javax.servlet.error.message") %>'/>
	<section class="container">
		<h1 class="title">Avenger´s Park</h1>
		<h2 class="subtitle">Erro:</h2>
		<h3 class="subsubtitle">${code}</h3>
		<h3 class="subsubtitle">${exception}</h3>
		<h3 class="subsubtitle">${message}</h3>
		<a href="index.jsp">Voltar para a Home</a>
	</section>
</body>
</html>