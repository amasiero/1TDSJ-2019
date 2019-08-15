package br.com.fiap.javaweb.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/potato")
public class PotatoServlet extends HttpServlet {

	private static final long serialVersionUID = 2129182049581199200L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");

		String palavra = req.getParameter("palavra");

		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>POTATO</h1>");
		out.println("<h2> A palavra digitada foi: " + palavra + "</h2>");
		out.println("</body></html>");
		out.flush();
		out.close();
	}

}
