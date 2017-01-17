package com.pedidospizzaria.vo;

public class Borda {
	
	private Integer id;
	private String nome;
	private Float valor;
	
	public Borda() {
		
	}
	
	public Borda(Integer id, String nome, Float valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	
}
