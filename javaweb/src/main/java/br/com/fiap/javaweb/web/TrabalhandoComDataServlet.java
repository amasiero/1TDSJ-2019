package br.com.fiap.javaweb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class TrabalhandoComDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String data = req.getParameter("data");
		Date agora = new Date();
		PrintWriter out = resp.getWriter();
		try {
			agora = data == null ? new Date() : df.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		out.println("<h1>" + df.format(agora) + "</h1>");
		out.flush();
		out.close();
		
	}

}
