package br.com.fiap.estacionamento.control.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.estacionamento.model.business.UsuarioBO;
import br.com.fiap.estacionamento.model.business.ValetBO;
import br.com.fiap.estacionamento.model.entities.Usuario;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4090057824194952155L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioBO().validarLogin(email, senha);
		
		if(usuario != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario);
			req.setAttribute("valets", new ValetBO().consultarPatio());
			RequestDispatcher dispatcher = req.getRequestDispatcher("valet.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("erro", "Usuário e/ou Senha não existem.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("erro.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
