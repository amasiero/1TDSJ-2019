package br.com.fiap.quadro.notas.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.quadro.notas.bussiness.AlunoBO;
import br.com.fiap.quadro.notas.dao.AlunoDAO;
import br.com.fiap.quadro.notas.model.entities.Aluno;

@WebServlet(urlPatterns = {"/aluno/cadastrar", "/aluno/consultar"})
public class AlunoServlet extends HttpServlet {

	private static final long serialVersionUID = -4017862143965021960L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String nome = req.getParameter("nome");
		
		Aluno a = new AlunoDAO().consultarPorNome(nome);
		
		resp.addCookie(new Cookie("nome", a.getNome()));
		resp.addCookie(new Cookie("p1", String.valueOf(a.getP1())));
		resp.addCookie(new Cookie("p2", String.valueOf(a.getP2())));
		
		req.getRequestDispatcher("../aluno.html").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String nome = req.getParameter("nome");
		String sP1 = req.getParameter("p1");
		String sP2 = req.getParameter("p2");
		
		out.println("<html><body>");
		
		if(nome == null || sP1 == null || sP2 == null) {
			out.println("<h1 style=\"color:red\">Os campos são obrigatórios!</h1>");
		} else {
			Aluno a = new Aluno(nome, Double.parseDouble(sP1), Double.parseDouble(sP2));
			AlunoBO bo = new AlunoBO();
			if(bo.validarNota(a.getP1()) && bo.validarNota(a.getP2())) {
				new AlunoDAO().adicionar(a);
				out.println("<h1>O aluno " + a.getNome() + " foi cadastrado com sucesso, junto com"
						+ "suas notas.</h1>");
			} else {
				out.println("<h1 style=\"color:red\">As notas precisam estar entre 0 e 10!</h1>");
			}
		}
		
		out.println("<a href=\"../index.html\">Voltar para Home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();
		
	}
	
}
