package com.pedidospizzaria.vo;

public class IngredienteBebida {
	private Integer id;
	private String nome;
	private String volume;
	private Float preco;
	
	public IngredienteBebida() {
	}
	
	public IngredienteBebida(Integer id, String nome, String volume, Float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.volume = volume;
		this.preco = preco;
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

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
}
