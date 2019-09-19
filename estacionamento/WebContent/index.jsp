<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Avenger´s Park</title>
</head>
<body>
	<h1>Avenger´s Park</h1>
	<fieldset>
		<legend>Acesse o sistema</legend>
		<form action="login" method="post">
			<label>Usuario:
				<input type="text" name="email" placeholder="Digite o seu usuário ou e-mail" />
			</label>
			<label>Senha:
				<input type="password" name="senha" placeholder="Digite sua senha" />
			</label>
			<button>Acessar</button>
		</form>
	</fieldset>
</body>
</html>