package com.pedidospizzaria.vo;

import java.util.List;

public class PratoPreparo {

		private Integer id;
		private List<Sabor> sabores;
		private Borda borda;
		private String tamanho;
		
		public PratoPreparo() {
			
		}

		public PratoPreparo(Integer id, List<Sabor> sabores, Borda borda,
				String tamanho) {
			super();
			this.id = id;
			this.sabores = sabores;
			this.borda = borda;
			this.tamanho = tamanho;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public List<Sabor> getSabores() {
			return sabores;
		}

		public void setSabores(List<Sabor> sabores) {
			this.sabores = sabores;
		}

		public Borda getBorda() {
			return borda;
		}

		public void setBorda(Borda borda) {
			this.borda = borda;
		}

		public String getTamanho() {
			return tamanho;
		}

		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
		}
		
		
}
