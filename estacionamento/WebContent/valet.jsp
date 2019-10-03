<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%@ page import="java.util.List, 
					  br.com.fiap.estacionamento.model.entities.Valet, 
					  br.com.fiap.estacionamento.model.business.ValetBO"%>

<%
	List<Valet> valets = new ValetBO().consultarPatio();
	request.setAttribute("valets", valets);
%> --%>

<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="UTF-8">
<title>Avenger´s Park</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<jsp:useBean id="valets" class="br.com.fiap.estacionamento.model.business.ValetBO"/>
	<section class="container">
		<c:choose>
			<c:when test="${not empty usuario}">
				<header>
				<h1>Avenger´s Park</h1>
				<p>
					Seja bem-vindo, ${usuario.nome}! <a href="controller?tarefa=Logout">Sair</a>
				</p>
				</header>
				<div class="form-valet">
					<form action="controller" method="post">
						<label>Placa: <input class="big" type="text" name="placa"
							placeholder="Informe a placa do veículo" required />
						</label> <label>Marca: <input class="big" type="text" name="marca"
							placeholder="Informe a marca do veículo" required />
						</label> <label>Modelo: <input class="big" type="text"
							name="modelo" placeholder="Informe o modelo do veículo" required />
						</label>
						<button name="tarefa" value="Estaciona">Registrar</button>
					</form>
				</div>
				<hr />
				<c:if test="${not empty valet}">
					<div class="ticket">
						<h3>Saída efetuada com sucesso</h3>
						<p>Veiculo: ${valet.veiculo.marca} ${valet.veiculo.modelo}</p>
						<p>Placa: ${valet.veiculo.placa}</p>
						<p>Entrada: ${valet.entradaEmTexto}</p>
						<p>Saída: ${valet.saidaEmTexto}</p>
						<p>Pagou: R$ ${valet.preco }</p>
					</div>
					<hr />
				</c:if>
				<div class="tabela-valet">
					<h1 class="subtitle">Veículos Estacionados</h1>
					<table>
						<thead>
							<tr>
								<th>Placa</th>
								<th>Marca</th>
								<th>Modelo</th>
								<th>Entrada</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="valet" items="${valets.consultarPatio()}">
								<tr>
									<td>${valet.veiculo.placa}</td>
									<td>${valet.veiculo.marca}</td>
									<td>${valet.veiculo.modelo}</td>
									<td>${valet.entradaEmTexto}</td>
									<td><a href="controller?id=${valet.id}&tarefa=Estaciona">
									Efetuar	Saída </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<h1 class="title">Avenger´s Park</h1>
				<h2 class="subtitle">You shall not pass!</h2>
				<h3 class="subsubtitle">Faça a autenticação para acessar!</h3>
				<a href="index.jsp">Voltar para tela de login.</a>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>