package br.com.fiap.quadro.notas.model.entities;

public class Aluno {
	
	private long id;
	private String nome;
	private double p1;
	private double p2;
	
	public Aluno(String nome, double p1, double p2) {
		super();
		this.nome = nome;
		this.p1 = p1;
		this.p2 = p2;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getP1() {
		return p1;
	}
	
	public void setP1(double p1) {
		this.p1 = p1;
	}
	
	public double getP2() {
		return p2;
	}
	
	public void setP2(double p2) {
		this.p2 = p2;
	}

}
