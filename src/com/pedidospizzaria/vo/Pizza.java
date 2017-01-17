package com.pedidospizzaria.vo;

import java.util.List;

public class Pizza {

	private Integer id;
	private String nome;
	private List<IngredientePrato> ingredientePratos;
	
	public Pizza() {
		
	}
	
	public Pizza(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Pizza(Integer id, String nome,
			List<IngredientePrato> ingredientePratos) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingredientePratos = ingredientePratos;
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

	public List<IngredientePrato> getIngredientePratos() {
		return ingredientePratos;
	}

	public void setIngredientePratos(List<IngredientePrato> ingredientePratos) {
		this.ingredientePratos = ingredientePratos;
	}

}
