package br.com.fiap.estacionamento.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {
	public String processarRequest(HttpServletRequest req, HttpServletResponse resp);
}
