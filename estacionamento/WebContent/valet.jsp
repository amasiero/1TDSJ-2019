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
<html>
<head>
<meta charset="UTF-8">
<title>Avenger´s Park</title>
</head>
<body>
	<h1>Avenger´s Park</h1>
	<c:choose>
		<c:when test="${not empty usuario}">
			<p>
				Seja bem-vindo, ${usuario.nome}! <a href="logout">Sair</a>
			</p>
			<fieldset>
				<legend>Entre com os dados do veiculo:</legend>
				<form action="registrar_entrada" method="post">
					<label>Marca: <input type="text" name="marca"
						placeholder="Digite a marca do veiculo" />
					</label> <label>Modelo: <input type="text" name="modelo"
						placeholder="Digite o modelo do veiculo" />
					</label> <label>Placa: <input type="text" name="placa"
						placeholder="Digite a placa do veiculo" />
					</label>
					<button>Registrar Entrada</button>
				</form>
			</fieldset>
			<hr />
			<c:if test="${not empty valet}">
				<h3>Saída efetuada com sucesso</h3>
				<p>Veiculo: ${valet.veiculo.marca} ${valet.veiculo.modelo}</p>
				<p>Placa: ${valet.veiculo.placa}</p>
				<p>Entrada: ${valet.entradaEmTexto}</p>
				<p>Saída: ${valet.saidaEmTexto}</p>
				<p>Pagou: R$ ${valet.preco }</p>
				<hr />
			</c:if>
			<h2>Estacionados</h2>
			<table>
				<thead>
					<tr>
						<th>Marca</th>
						<th>Modelo</th>
						<th>Placa</th>
						<th>Entrada</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="valet" items="${valets}">
						<tr>
							<td>${valet.veiculo.marca}</td>
							<td>${valet.veiculo.modelo}</td>
							<td>${valet.veiculo.placa}</td>
							<td>${valet.entradaEmTexto}</td>
							<td><a href="registrar_saida?id=${valet.id}"> Efetuar
									Saída </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<h2>You shall not pass!</h2>
			<h3>Faça a autenticação para acessar!</h3>
			<a href="index.jsp">Voltar para tela de login.</a>
		</c:otherwise>
	</c:choose>
</body>
</html>