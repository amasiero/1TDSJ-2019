<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Empresas</title>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="styles/main.css" />
</head>
<body>
	<jsp:useBean id="dao"
		class="br.com.fiap.servlet_ajax.model.dao.EmpresaDAO" />
	<input type="text" id="filtro" name="filtro"
		placeholder="Digite o nome da empresa que deseja procurar." />
	<div class="container">
		<ul id="empresas">
			<c:forEach var="empresa" items="${dao.buscaPorSimilaridade(null) }">
				<li>${empresa.nome }</li>
			</c:forEach>
		</ul>
	</div>
	<script type="text/javascript" src="scripts/app.js"></script>
</body>
</html>