<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="UTF-8">
<title>Avenger´s Park</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<c:if test="${not empty usuario}">
		<c:redirect url="valet.jsp"/>
	</c:if>
	<section class="container">
		<div class="form-login">
			<h1 class="title">Avenger´s Park</h1>
			<form action="controller" method="post">
				<label>E-mail: <input type="email" name="email"
					placeholder="Informe seu e-mail ou nome de usuário" required />
				</label> <label>Senha: <input type="password" name="senha"
					placeholder="Informe sua senha" required />
				</label>
				<button name="tarefa">Acessar</button>
			</form>
		</div>
	</section>
</body>
</html>