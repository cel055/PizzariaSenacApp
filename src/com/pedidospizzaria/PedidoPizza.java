package com.pedidospizzaria;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.dao.BordaDao;
import com.pedidospizzaria.dao.PizzaDAO;
import com.pedidospizzaria.vo.Borda;
import com.pedidospizzaria.vo.Pizza;
import com.pedidospizzaria.vo.PratoPreparo;
import com.pedidospizzaria.vo.Sabor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Spinner;
import android.widget.Toast;
import android.util.Log;
import android.view.View;

public class PedidoPizza extends Activity {

	static Spinner spnTamanho;
	private Spinner spnBorda;
	static Spinner spnSabor1;
	static Spinner spnSabor2;
	static Spinner spnSabor3;
	static int spnSelecionado;
	
	private List<String> tamanho;
	private List<String> bordasString;
	private List<String> pizzasString;
	private List<Borda> bordas;
	private List<Pizza> pizzas;
	
	private ArrayAdapter<String> arrayAdapterTamanho;
	private ArrayAdapter<String> arrayAdapterBorda;
	private ArrayAdapter<String> arrayAdapterSabor1;
	private ArrayAdapter<String> arrayAdapterSabor2;
	private ArrayAdapter<String> arrayAdapterSabor3;
	
	private String nome = "";
	private Borda borda;
	static Pizza pizza;
	static PratoPreparo pratoPreparo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pedido_pizza);
		
		pratoPreparo = new PratoPreparo();
		List<Sabor> sabores = new ArrayList<Sabor>();
		pratoPreparo.setSabores(sabores);
		
		
		spnSelecionado = 0;
		spnTamanho = (Spinner) findViewById(R.id.pedidoPizzaListTamanho);
		spnBorda = (Spinner) findViewById(R.id.pedidoPizzaListBorda);
		spnSabor1 = (Spinner) findViewById(R.id.pedidoPizzaListSabor1);
		spnSabor2 = (Spinner) findViewById(R.id.pedidoPizzaListSabor2);
		spnSabor3 = (Spinner) findViewById(R.id.pedidoPizzaListSabor3);

		Log.e("teste", "criou a classe");
		tamanho = new ArrayList<String>();
		tamanho.add("");
		tamanho.add("PEQUENA");
		tamanho.add("MÉDIA");
		tamanho.add("GRANDE");

		BordaDao bordaDao = new BordaDao(getBaseContext());
		bordas = bordaDao.getAll();
		bordasString = new ArrayList<String>();
		bordasString.add("");
		for (Borda b : bordas) {
			bordasString.add(b.getNome().toString());
		}

		PizzaDAO pizzaDAO = new PizzaDAO(getBaseContext());
		pizzas = pizzaDAO.getAll();
		pizzasString = new ArrayList<String>();
		pizzasString.add("");
		for (Pizza p : pizzas) {
			pizzasString.add(p.getNome());
		}
		Log.e("teste", "fez a pesquiza das pizzas");

		// Cria um ArrayAdapter usando um padrão de layout da classe R do
		// android, passando o ArrayList nomes
		arrayAdapterTamanho = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, tamanho);
		arrayAdapterTamanho
				.setDropDownViewResource(android.R.layout.simple_spinner_item);

		spnTamanho.setAdapter(arrayAdapterTamanho);

		// Método do Spinner para capturar o item selecionado
		spnTamanho
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {

						// pega nome pela posição
						nome = arg0.getItemAtPosition(arg2).toString();
						pratoPreparo.setTamanho(arg0.getItemAtPosition(arg2).toString());
						if (nome.equals("PEQUENA")) {
							spnSabor1.setEnabled(true);
							spnSabor2.setEnabled(false);
							spnSabor3.setEnabled(false);

						} else if (nome.equals("MÉDIA")) {
							spnSabor1.setEnabled(true);
							spnSabor2.setEnabled(true);
							spnSabor3.setEnabled(false);

						} else if (nome.equals("GRANDE")) {
							spnSabor1.setEnabled(true);
							spnSabor2.setEnabled(true);
							spnSabor3.setEnabled(true);
						} else {
							spnSabor1.setEnabled(false);
							spnSabor2.setEnabled(false);
							spnSabor3.setEnabled(false);
						}
						if (!nome.equals("")) {
							Toast.makeText(PedidoPizza.this,
									"Tamanho Selecionado: " + nome,
									Toast.LENGTH_LONG).show();
							nome = "";
						}
					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		// Cria um ArrayAdapter usando um padrão de layout da classe R do
		// android, passando o ArrayList nomes
		arrayAdapterBorda = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, bordasString);
		arrayAdapterBorda
				.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spnBorda.setAdapter(arrayAdapterBorda);
		spnBorda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				nome = arg0.getItemAtPosition(arg2).toString();
				if (!nome.equals("")) {
					borda = bordas.get(arg2 - 1);
					Toast.makeText(PedidoPizza.this,
							"Borda Selecionada: " + borda.getNome(), Toast.LENGTH_LONG)
							.show();
					nome = "";
				}
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		// Cria um ArrayAdapter usando um padrão de layout da classe R do
		// android, passando o ArrayList nomes
		arrayAdapterSabor1 = new ArrayAdapter<String>(this,	android.R.layout.simple_spinner_dropdown_item, pizzasString);
		arrayAdapterSabor1.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spnSabor1.setAdapter(arrayAdapterSabor1);
		spnSabor1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						nome = arg0.getItemAtPosition(arg2).toString();
						spnSelecionado = 1;
						if (!nome.equals("")) {
							getPizza(arg2, pizzas);
						}
					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		// Cria um ArrayAdapter usando um padrão de layout da classe R do
		// android, passando o ArrayList nomes
		arrayAdapterSabor2 = new ArrayAdapter<String>(this,	android.R.layout.simple_spinner_dropdown_item, pizzasString);
		arrayAdapterSabor2.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spnSabor2.setAdapter(arrayAdapterSabor2);
		spnSabor2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						nome = arg0.getItemAtPosition(arg2).toString();
						spnSelecionado = 2;
						if (!nome.equals("")) {
							getPizza(arg2, pizzas);
						}
					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}

				});

		// Cria um ArrayAdapter usando um padrão de layout da classe R do
		// android, passando o ArrayList nomes
		arrayAdapterSabor3 = new ArrayAdapter<String>(this,	android.R.layout.simple_spinner_dropdown_item, pizzasString);
		arrayAdapterSabor3.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spnSabor3.setAdapter(arrayAdapterSabor3);
		spnSabor3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
						nome = arg0.getItemAtPosition(arg2).toString();
						spnSelecionado = 3;
						if (!nome.equals("")) {
							getPizza(arg2, pizzas);
						}
					}

					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});
		
		findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				if(borda != null){
					pratoPreparo.setBorda(borda);
				}
				if (pratoPreparo.getSabores().size() == 0) {
					Toast.makeText(PedidoPizza.this,"Nenhum sabor selecionado",Toast.LENGTH_LONG).show();
				}else{
					CadastroPedido.pedido.getPratosPreparos().add(pratoPreparo);
					finish();
				}
			}
		});
		
		findViewById(R.id.btPedidoPizzaAdicionarPedido).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				if(borda != null){
					pratoPreparo.setBorda(borda);
				}
				if (pratoPreparo.getSabores().size() == 0) {
					Toast.makeText(PedidoPizza.this,"Nenhum sabor selecionado",Toast.LENGTH_LONG).show();
				}else{
					CadastroPedido.pedido.getPratosPreparos().add(pratoPreparo);
					startActivity(new Intent(getBaseContext(), PedidoPizza.class));
				}
			}
		});
		
		findViewById(R.id.btPedidoPizzaReiniciarPrato).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent(getBaseContext(), PedidoPizza.class));
			}
		});
		
		findViewById(R.id.btPedidoPizzaCancelar).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	public void getPizza(int position, List<Pizza> pizzas){
		Toast.makeText(PedidoPizza.this,"Pizza Selecionada: " + nome,Toast.LENGTH_LONG).show();
		PedidoPizza.pizza = pizzas.get(position - 1);
		nome = "";
		startActivity(new Intent(getBaseContext(),ParticularidadesPizza.class));
	}
}
