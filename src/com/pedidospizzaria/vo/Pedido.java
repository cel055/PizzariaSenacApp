package com.pedidospizzaria.vo;

import java.util.List;

public class Pedido {
	
	private Integer id;
	private Mesa mesa;
	private List<PratoPreparo> pratosPreparos;
	private List<BebidaPreparo> bebidasPreparos;
	
	public Pedido() {
		
	}

	public Pedido(Integer id, Mesa mesa, List<PratoPreparo> pratosPreparos,
			List<BebidaPreparo> bebidasPreparos) {
		super();
		this.id = id;
		this.mesa = mesa;
		this.pratosPreparos = pratosPreparos;
		this.bebidasPreparos = bebidasPreparos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public List<PratoPreparo> getPratosPreparos() {
		return pratosPreparos;
	}

	public void setPratosPreparos(List<PratoPreparo> pratosPreparos) {
		this.pratosPreparos = pratosPreparos;
	}

	public List<BebidaPreparo> getBebidasPreparos() {
		return bebidasPreparos;
	}

	public void setBebidasPreparos(List<BebidaPreparo> bebidasPreparos) {
		this.bebidasPreparos = bebidasPreparos;
	}
}
