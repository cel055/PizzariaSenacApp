package com.pedidospizzaria.vo;

import java.util.List;

public class Sabor {
	
	private Integer id;
	private List<IngredientePrato> acrescimos;
	private List<IngredientePrato> decrescimos;
	private Pizza pizza;
	
	public Sabor() {
		
	}

	public Sabor(Integer id, List<IngredientePrato> acrescimos, List<IngredientePrato> decrescimos, Pizza pizza) {
		super();
		this.id = id;
		this.acrescimos = acrescimos;
		this.decrescimos = decrescimos;
		this.pizza = pizza;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<IngredientePrato> getAcrescimos() {
		return acrescimos;
	}

	public void setAcrescimos(List<IngredientePrato> acrescimos) {
		this.acrescimos = acrescimos;
	}

	public List<IngredientePrato> getDecrescimos() {
		return decrescimos;
	}

	public void setDecrescimos(List<IngredientePrato> decrescimos) {
		this.decrescimos = decrescimos;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
}
