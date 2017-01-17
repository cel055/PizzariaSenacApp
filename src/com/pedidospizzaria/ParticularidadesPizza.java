package com.pedidospizzaria;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.dao.IngredientePratoDao;
import com.pedidospizzaria.layout.MultiSpinner;
import com.pedidospizzaria.vo.IngredientePrato;
import com.pedidospizzaria.vo.PratoPreparo;
import com.pedidospizzaria.vo.Sabor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ParticularidadesPizza extends Activity {
	
	private List<IngredientePrato> acrescimos;
	private List<IngredientePrato> decrescimos;
	private List<IngredientePrato> acrescimosSelecionados;
	private List<IngredientePrato> decrescimosSelecionados;
	
	private MultiSpinner acrescimosSpinner;
	private MultiSpinner decrescimosSpinner;
	
	private List<String> acrescimosString;
	private List<String> decrescimosString;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.particularidades_pizza);
		acrescimosSpinner = (MultiSpinner)findViewById(R.id.particularidadesPizzaAcrescimos);
		decrescimosSpinner = (MultiSpinner)findViewById(R.id.particularidadesPizzaDecrescimos);
		
		IngredientePratoDao ingredientePratoDao = new IngredientePratoDao(getBaseContext());
		acrescimos = ingredientePratoDao.getAcrescimos();
		decrescimos = PedidoPizza.pizza.getIngredientePratos();
		
		acrescimosString = new ArrayList<String>();
		for (IngredientePrato ip : acrescimos) {
			acrescimosString.add(ip.getNome());
		}
		
		decrescimosString = new ArrayList<String>();
		for (IngredientePrato ip : decrescimos) {
			decrescimosString.add(ip.getNome());
		}
		
		acrescimosSpinner.setItems(acrescimosString, "Acrescimos");
		decrescimosSpinner.setItems(decrescimosString, "Decrescimos");
		
		findViewById(R.id.BtParticularidadesPizzaEnviarLista).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				
				acrescimosSelecionados = new ArrayList<IngredientePrato>();
				decrescimosSelecionados = new ArrayList<IngredientePrato>();
				
				for (int i = 0; i < acrescimosSpinner.getSelected().length; i++) {
					if(acrescimosSpinner.getSelected()[i]){
						acrescimosSelecionados.add(acrescimos.get(i));
						Log.e("teste", "Selecionou: " + acrescimosString.get(i));
					}
				}
				
				for (int i = 0; i < decrescimosSpinner.getSelected().length; i++) {
					if(decrescimosSpinner.getSelected()[i]){
						decrescimosSelecionados.add(decrescimos.get(i));
						Log.e("teste", "Selecionou: " + decrescimosString.get(i));
					}
				}
				
				Sabor sabor = new Sabor();
				sabor.setPizza(PedidoPizza.pizza);
				sabor.setAcrescimos(acrescimosSelecionados);
				sabor.setDecrescimos(decrescimosSelecionados);
				if(PedidoPizza.spnSelecionado == 1){
					PedidoPizza.spnSabor1.setEnabled(false);
				}else if (PedidoPizza.spnSelecionado == 2) {
					PedidoPizza.spnSabor2.setEnabled(false);
				}else if (PedidoPizza.spnSelecionado == 3) {
					PedidoPizza.spnSabor3.setEnabled(false);
				}
				PedidoPizza.spnTamanho.setEnabled(false);
				PedidoPizza.pratoPreparo.getSabores().add(sabor);
				finish();
			}
		});
	}
};
