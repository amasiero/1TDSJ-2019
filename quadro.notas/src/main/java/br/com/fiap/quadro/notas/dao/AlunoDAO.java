package br.com.fiap.quadro.notas.dao;

import java.util.ArrayList;

import br.com.fiap.quadro.notas.model.entities.Aluno;

public class AlunoDAO {
	
	private static ArrayList<Aluno> ALUNOS = new ArrayList<Aluno>();
	
	public void adicionar(Aluno a) {
		gerarIDeAdicionar(a);
	}
	
	public ArrayList<Aluno> consultarTodos() {
		return ALUNOS;
	}
	
	public Aluno consultarPorNome(String nome) {
		for(Aluno a : ALUNOS) {
			if(a.getNome().equals(nome)) {
				return a;
			}
		}
		return null;
	}
	
	private static void gerarIDeAdicionar(Aluno a) {
		long id = ALUNOS.size() + 1l;
		a.setId(id);
		ALUNOS.add(a);
	}

}



