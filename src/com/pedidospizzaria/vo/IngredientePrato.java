package com.pedidospizzaria.vo;

public class IngredientePrato {
	
	private Integer id;
	private String nome;
	private Float preco;
	
	public IngredientePrato() {
		
	}

	public IngredientePrato(Integer id, String nome, Float preco) {
		super();
		this.id = id;
		this.nome = nome;
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

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	
}
