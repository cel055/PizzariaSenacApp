package com.pedidospizzaria;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.dao.BebidaCardapioDAO;
import com.pedidospizzaria.vo.BebidaCardapio;
import com.pedidospizzaria.vo.BebidaPreparo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class PedidoBebida extends Activity {

	private Spinner spnBebida;
	private ArrayAdapter<String> arrayAdapterBebidas;
	private List<String> bebidas = new ArrayList<String>();
	private String bebidaSelecionadaString;
	private List<BebidaCardapio> bebidaCardapios;
	static BebidaCardapio bebidaCardapioSelecionada;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pedido_bebida);
		Log.e("daoBebida", "criou a classe");

		BebidaCardapioDAO bebidaCardapioDAO = new BebidaCardapioDAO(getBaseContext());
		bebidaCardapios = new ArrayList<BebidaCardapio>();
		bebidaCardapios = bebidaCardapioDAO.getAll();
		Log.e("daoBebida", "fez a pesquiza");

		bebidas.add("");
		for (BebidaCardapio bebidaCardapio : bebidaCardapios) {
			bebidas.add(bebidaCardapio.getNome());
		}

		spnBebida = (Spinner) findViewById(R.id.spnPedidoBebida);
		arrayAdapterBebidas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bebidas);
		arrayAdapterBebidas.setDropDownViewResource(android.R.layout.simple_spinner_item);

		spnBebida.setAdapter(arrayAdapterBebidas);

		spnBebida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						bebidaSelecionadaString = arg0.getItemAtPosition(arg2).toString();
						if (!bebidaSelecionadaString.equals("")) {
							Toast.makeText( PedidoBebida.this, "Bebida Selecionada: " + bebidaSelecionadaString, Toast.LENGTH_LONG).show();
							bebidaCardapioSelecionada = new BebidaCardapio();
							bebidaCardapioSelecionada = bebidaCardapios.get(arg2 - 1);
							startActivity(new Intent(getBaseContext(), ParticularidadesBebida.class));
						}
					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});
		
		findViewById(R.id.btPedidoBebidaVoltar).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				finish();
			}
		});

	}
}
