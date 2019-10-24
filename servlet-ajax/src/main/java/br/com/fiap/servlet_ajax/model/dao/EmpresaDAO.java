package br.com.fiap.servlet_ajax.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.servlet_ajax.model.entities.Empresa;


/**
 * Classe que simula um banco de dados de cadastro de empresas
 *
 */
public class EmpresaDAO {
	private final static Map<Long, Empresa> EMPRESAS = new HashMap<>();
	static {
		geraIdEAdiciona(new Empresa("Twitter"));
		geraIdEAdiciona(new Empresa("IBM"));
		geraIdEAdiciona(new Empresa("Facebook"));
		geraIdEAdiciona(new Empresa("Google"));
		geraIdEAdiciona(new Empresa("Microsoft"));
		geraIdEAdiciona(new Empresa("Apple"));
	}

	/**
	 * Realiza uma busca por similaridade de palavras, com base em uma
	 * entrada recebida. Caso seja nulo essa entrada, retorna todas
	 * empresas cadastradas.
	 * 
	 * @param String
	 * @return Collection<Empresa>
	 */
	public List<Empresa> buscaPorSimilaridade(String nome) {
		List<Empresa> similares = new ArrayList<>();
		if (nome == null)
			for (Empresa empresa : EMPRESAS.values()) {
					similares.add(empresa);
			}
		else
			for (Empresa empresa : EMPRESAS.values()) {
				if (empresa.getNome().toLowerCase().contains(nome.toLowerCase()))
					similares.add(empresa);
			}
		return similares;
	}

	/**
	 * Adiciona uma empresa no banco de dados.
	 * 
	 * @param Empresa
	 */
	public void adiciona(Empresa empresa) {
		geraIdEAdiciona(empresa);
	}

	/**
	 * Cria um id para empresa recem cadastrada.
	 * 
	 * @param Empresa
	 */
	private static void geraIdEAdiciona(Empresa empresa) {
		long id = EMPRESAS.size() + 1l;
		empresa.setId(id);
		EMPRESAS.put(id, empresa);
	}

}

