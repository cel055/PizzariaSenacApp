package com.pedidospizzaria;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.dao.IngredienteBebidaDao;
import com.pedidospizzaria.layout.MultiSpinner;
import com.pedidospizzaria.vo.BebidaPreparo;
import com.pedidospizzaria.vo.IngredienteBebida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ParticularidadesBebida extends Activity {
	
	private List<IngredienteBebida> acrescimos;
	private List<IngredienteBebida> decrescimos;
	private List<IngredienteBebida> acrescimosSelecionados;
	private List<IngredienteBebida> decrescimosSelecionados;
	
	private MultiSpinner acrescimosSpinner;
	private MultiSpinner decrescimosSpinner;
	
	private List<String> acrescimosString;
	private List<String> decrescimosString;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.particularidades_bebida);
		acrescimosSpinner = (MultiSpinner)findViewById(R.id.spnParticularidadesBebidaAcrescimo);
		decrescimosSpinner = (MultiSpinner)findViewById(R.id.spnParticularidadesBebidaDecrescimo);
		
		IngredienteBebidaDao ingredienteBebidaDao = new IngredienteBebidaDao(getBaseContext());
		acrescimos = ingredienteBebidaDao.getAcrescimos();
		decrescimos = PedidoBebida.bebidaCardapioSelecionada.getIngredienteBebidas();
		
		acrescimosString = new ArrayList<String>();
		for (IngredienteBebida ib : acrescimos) {
			acrescimosString.add(ib.getNome());
		}
		
		decrescimosString = new ArrayList<String>();
		for (IngredienteBebida ib : decrescimos) {
			decrescimosString.add(ib.getNome());
		}
		
		acrescimosSpinner.setItems(acrescimosString, "Acrescimos");
		decrescimosSpinner.setItems(decrescimosString, "Decrescimos");
		
		findViewById(R.id.btParticularidadesBebidaOk).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				acrescimosSelecionados = new ArrayList<IngredienteBebida>();
				decrescimosSelecionados = new ArrayList<IngredienteBebida>();
				
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
				
				BebidaPreparo bebidaPreparo = new BebidaPreparo(null, PedidoBebida.bebidaCardapioSelecionada, acrescimosSelecionados, decrescimosSelecionados);
				CadastroPedido.pedido.getBebidasPreparos().add(bebidaPreparo);
				startActivity(new Intent(getBaseContext(), PedidoBebida.class));
			}
		});
		
		findViewById(R.id.btParticularidadesBebidaVoltar).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent(getBaseContext(), PedidoBebida.class));
			}
		});
	}
}
