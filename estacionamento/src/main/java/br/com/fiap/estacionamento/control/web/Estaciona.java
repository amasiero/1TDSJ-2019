package br.com.fiap.estacionamento.control.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.estacionamento.model.business.ValetBO;
import br.com.fiap.estacionamento.model.entities.Valet;
import br.com.fiap.estacionamento.model.entities.Veiculo;

public class Estaciona implements Tarefa {

	@Override
	public String processarRequest(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equalsIgnoreCase("GET"))
			return doGet(req, resp);
		else
			return doPost(req, resp);
	}
	
	private String doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		String placa = req.getParameter("placa");
		
		Veiculo veiculo = new Veiculo(marca, modelo, placa);
		ValetBO bo = new ValetBO();
		bo.registrarVeiculo(veiculo);
		return "valet.jsp";
		
	}
	
	private String doGet(HttpServletRequest req, HttpServletResponse resp)  {
		String sId = req.getParameter("id");
		Long id = Long.parseLong(sId);
		
		ValetBO bo = new ValetBO();
		Valet valet = bo.registrarSaida(id);
		req.setAttribute("valet", valet);
		return "valet.jsp";
		
	}

}
