package br.com.fiap.estacionamento.control.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.estacionamento.model.business.ValetBO;
import br.com.fiap.estacionamento.model.entities.Valet;
import br.com.fiap.estacionamento.model.entities.Veiculo;


@WebServlet(urlPatterns = {"/registrar_entrada", "/registrar_saida"})
public class ValetServlet extends HttpServlet {

	private static final long serialVersionUID = -4897072213971233247L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		String placa = req.getParameter("placa");
		
		Veiculo veiculo = new Veiculo(marca, modelo, placa);
		ValetBO bo = new ValetBO();
		bo.registrarVeiculo(veiculo);
		req.setAttribute("valets", bo.consultarPatio());
		
		req.getRequestDispatcher("valet.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String sId = req.getParameter("id");
		Long id = Long.parseLong(sId);
		
		ValetBO bo = new ValetBO();
		Valet valet = bo.registrarSaida(id);
		req.setAttribute("valet", valet);
		req.setAttribute("valets", bo.consultarPatio());
		
		req.getRequestDispatcher("valet.jsp").forward(req, resp);
		
	}

}
