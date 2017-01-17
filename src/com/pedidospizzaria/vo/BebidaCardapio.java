package com.pedidospizzaria.vo;

import java.util.List;

public class BebidaCardapio {
	private Integer id;
	private String nome;
	private List<IngredienteBebida>ingredienteBebidas;
	
	public BebidaCardapio() {
		
	}

	public BebidaCardapio(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public BebidaCardapio(Integer id, String nome, List<IngredienteBebida>ingredienteBebidas) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingredienteBebidas = ingredienteBebidas;
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

	public List<IngredienteBebida> getIngredienteBebidas() {
		return ingredienteBebidas;
	}

	public void setIngredienteBebidas(List<IngredienteBebida> ingredienteBebidas) {
		this.ingredienteBebidas = ingredienteBebidas;
	}

	
}
