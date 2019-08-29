package br.com.fiap.quadro.notas.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.quadro.notas.model.entities.Aluno;

@WebServlet(urlPatterns = "/perdido")
public class PerdidoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ServletContext contexto = getServletContext();
		contexto.setAttribute("data", new Date());
		
		HttpSession s = req.getSession();
		s.setAttribute("aluno", new Aluno("Andrey", 6.5, 5.5));
		
	}

}
