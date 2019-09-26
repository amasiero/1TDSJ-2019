package br.com.fiap.estacionamento.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa {


	@Override
	public String processarRequest(HttpServletRequest req, HttpServletResponse resp)  {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return"index.jsp";
		
	}

}
