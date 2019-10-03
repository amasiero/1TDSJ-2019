package br.com.fiap.estacionamento.control.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 7870012854961099632L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");
		if(tarefa == null || tarefa.isEmpty()) throw new IllegalArgumentException("A tarefa não foi informada");
		tarefa = "br.com.fiap.estacionamento.control.web." + tarefa;
		
		try {
			Class<?> classe = Class.forName(tarefa);
			Tarefa instancia  = (Tarefa) classe.newInstance();
			String url = instancia.processarRequest(req, resp);
			req.getRequestDispatcher(url).forward(req, resp);
			
		}catch(ClassNotFoundException | 
				IllegalAccessException | 
				InstantiationException e) {
			e.printStackTrace();
		}catch(RuntimeException e) {
			throw e;
		}
		
		
	}
}
