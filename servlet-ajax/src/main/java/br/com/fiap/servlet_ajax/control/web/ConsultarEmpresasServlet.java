package br.com.fiap.servlet_ajax.control.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.fiap.servlet_ajax.model.dao.EmpresaDAO;
import br.com.fiap.servlet_ajax.model.entities.Empresa;

@WebServlet("/consultar")
public class ConsultarEmpresasServlet extends HttpServlet {

	private static final long serialVersionUID = 4975393732667867710L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// Recebe parametro de entrada
		String filtro = req.getParameter("filtro");
		// Realiza o processamento necessário de acordo com a regra de negocio
		List<Empresa> empresas = (List<Empresa>) new EmpresaDAO().buscaPorSimilaridade(filtro);
		empresas.sort((e1, e2) ->  e1.getNome().compareTo(e2.getNome()));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Prepara o tipo de resposta
		resp.setContentType("application/json");
		// Retorna a informação processada
		resp.getWriter().write(new Gson().toJson(empresas));
	}

}
