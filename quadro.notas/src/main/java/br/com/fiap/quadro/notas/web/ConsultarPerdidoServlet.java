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

@WebServlet(urlPatterns = "/consultar_perdido")
public class ConsultarPerdidoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		Date data = (Date) context.getAttribute("data");
		
		HttpSession s = req.getSession();
		Aluno a = (Aluno) s.getAttribute("aluno");
		
		if(a != null) resp.getWriter().println("<h1>" + a.getNome() + "</h1>");
		if(data != null) resp.getWriter().println("<h1>" + data + "</h1>");
		
	}
}
