<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<input type="text" id="filtro" name="filtro"
		placeholder="Digite o nome da empresa que deseja procurar." />
	<div class="container">
		<ul id="empresas">
		</ul>
	</div>
	<div class="loading">
		<svg id="dots" width="64px" height="64px" version="1.1" id="L4"
			xmlns="http://www.w3.org/2000/svg"
			xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
			viewBox="0 0 100 100" enable-background="new 0 0 0 0"
			xml:space="preserve">
			  <circle fill="#fff" stroke="none" cx="6" cy="50" r="6">
			    <animate attributeName="opacity" dur="1s" values="0;1;0"
				repeatCount="indefinite" begin="0.1" />    
			  </circle>
			  <circle fill="#fff" stroke="none" cx="26" cy="50" r="6">
			    <animate attributeName="opacity" dur="1s" values="0;1;0"
				repeatCount="indefinite" begin="0.2" />       
			  </circle>
			  <circle fill="#fff" stroke="none" cx="46" cy="50" r="6">
			    <animate attributeName="opacity" dur="1s" values="0;1;0"
				repeatCount="indefinite" begin="0.3" />     
			  </circle>
			</svg>
	</div>
	<script type="text/javascript" src="scripts/app2.js"></script>
</body>
</html>