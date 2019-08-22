package br.com.fiap.hotel.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.hotel.bussiness.UsuarioBO;
import br.com.fiap.hotel.dao.UsuarioDAO;
import br.com.fiap.hotel.model.entities.Usuario;

@WebServlet(urlPatterns = "/usuario")
public class UsuarioServlet extends HttpServlet{
	private static final long serialVersionUID = 1l;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario(nome, login, senha);
		
		out.println("<html><body>");
		
		if(new UsuarioBO().validarUsuario(usuario)) {
			new UsuarioDAO().adicionar(usuario);
			out.println("<h2>Usuário " + usuario.getNome() + " criado com sucesso.</h2>");
			
		} else {
			out.println("<h2 style=\"color:red;\"> É preciso "
					+ "informar todos os campos do usuário</h2>");
		}
		
		out.println("<a href=\"index.html\">Voltar para Home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();
		
	}
}








