package br.com.fiap.estacionamento.control.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 5870044853196571017L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}

}
