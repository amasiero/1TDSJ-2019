package br.com.fiap.estacionamento.model.business;

import java.util.Date;
import java.util.List;

import br.com.fiap.estacionamento.model.dao.ValetDAO;
import br.com.fiap.estacionamento.model.entities.Valet;
import br.com.fiap.estacionamento.model.entities.Veiculo;

public class ValetBO {
	
	private final double PRECO_BASE = 4;
	private final double PRECO_ADICIONAL = 2.5;
	private final long TEMPO_MINIMO = 3;
	
	public List<Valet> consultarPatio() {
		List<Valet> valets = new ValetDAO().consultarPatio();
		
		if(valets.isEmpty()) {
			return null;
		} else {
			return valets;
		}
	}

	public void registrarVeiculo(Veiculo veiculo) {
		new ValetDAO().registrarEntrada(new Valet(veiculo, new Date()));
	}

	public Valet registrarSaida(Long id) {
		Valet v = new ValetDAO().registrarSaida(id);
		v.setPreco(this.calcularPagamento(v.getEntrada(), v.getSaida()));
		return v;
	}
	
	public double calcularPagamento(Date entrada, Date saida) {
		double preco = 0.0;
		
		long tempoPermanecia = (saida.getTime() - entrada.getTime()) / 1000 / 60;
		long horas = tempoPermanecia / 60;
		long minutos = tempoPermanecia % 60;
		
		if (this.temHorasAdicionais(this.qtdeHorasAdicionais(horas))) {
			preco = this.PRECO_BASE;
			preco = preco + this.qtdeHorasAdicionais(horas)  * this.PRECO_ADICIONAL;
			if (minutos > 0) {
				preco = preco + this.PRECO_ADICIONAL;
			}
		} else {
			preco = this.PRECO_BASE;			
		}
		
		return preco;
	}
	
	private long qtdeHorasAdicionais(long horas) {
		return horas - this.TEMPO_MINIMO;
	}
	
	private boolean temHorasAdicionais(long horasAdicionais) {
		return horasAdicionais > 0;
	}
}
