package com.pedidospizzaria.vo;

import java.util.List;

public class BebidaPreparo {
	private Integer id;
	private BebidaCardapio bebidaCardapio;
	private List<IngredienteBebida> acrescimos;
	private List<IngredienteBebida> decrescimos;
	
	public BebidaPreparo() {
		
	}

	public BebidaPreparo(Integer id, BebidaCardapio bebidaCardapio, List<IngredienteBebida> acrescimos, List<IngredienteBebida> decrescimos) {
		super();
		this.id = id;
		this.bebidaCardapio = bebidaCardapio;
		this.acrescimos = acrescimos;
		this.decrescimos = decrescimos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BebidaCardapio getBebidaCardapio() {
		return bebidaCardapio;
	}

	public void setBebidaCardapio(BebidaCardapio bebidaCardapio) {
		this.bebidaCardapio = bebidaCardapio;
	}

	public List<IngredienteBebida> getAcrescimos() {
		return acrescimos;
	}

	public void setAcrescimos(List<IngredienteBebida> acrescimos) {
		this.acrescimos = acrescimos;
	}

	public List<IngredienteBebida> getDecrescimos() {
		return decrescimos;
	}

	public void setDecrescimos(List<IngredienteBebida> decrescimos) {
		this.decrescimos = decrescimos;
	}
}
