package com.pedidospizzaria;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.pedidospizzaria.dao.BebidaCardapioDAO;
import com.pedidospizzaria.dao.MesaDao;
import com.pedidospizzaria.dao.PedidoDAO;
import com.pedidospizzaria.vo.BebidaCardapio;
import com.pedidospizzaria.vo.BebidaPreparo;
import com.pedidospizzaria.vo.PratoPreparo;
import com.pedidospizzaria.vo.IngredienteBebida;
import com.pedidospizzaria.vo.Mesa;
import com.pedidospizzaria.vo.Pedido;
import com.pedidospizzaria.vo.Pizza;

public class CadastroPedido extends Activity{
	public static Pedido pedido;
	
	private Spinner spnMesa;
	private ArrayAdapter<String> arrayAdapterMesa;
	private List<String> listMesas;
	private List<Mesa> mesas;
	private Mesa mesa;;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_pedido);
        
        pedido = new Pedido();
        pedido.setBebidasPreparos(new ArrayList<BebidaPreparo>());
        pedido.setPratosPreparos(new ArrayList<PratoPreparo>());
        
        
        Button btnOk = (Button)findViewById(R.id.btCadPedidoEnviar);
        Button btnPizza = (Button)findViewById(R.id.btCadPedidoPizza);
        Button btnBebida = (Button)findViewById(R.id.btCadPedidoBebida);
        
        MesaDao mesaDao = new MesaDao(getBaseContext());
        mesas = new ArrayList<Mesa>();
        mesas = mesaDao.getAll();
        
        listMesas = new ArrayList<String>();
        listMesas.add("");
        for (Mesa m : mesas) {
			listMesas.add(m.getId().toString());
		}
        
        spnMesa = (Spinner) findViewById(R.id.spnPedidoMesa);
        arrayAdapterMesa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listMesas);
        arrayAdapterMesa.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnMesa.setAdapter(arrayAdapterMesa);
        
        spnMesa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

			public void onItemSelected(AdapterView<?> arg0, View arg1,	int arg2, long arg3) {
				if(!arg0.getItemAtPosition(arg2).toString().equals("")){
					Toast.makeText(CadastroPedido.this, "Mesa Selecionada: " + arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
					mesa = new Mesa(Integer.parseInt(arg0.getItemAtPosition(arg2).toString()));
					pedido.setMesa(mesa);
					Log.e("testPedido", "Adicionou mesa - " + pedido.getMesa().getId().toString());
				}
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        btnOk.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Pedido pedido = new Pedido();
				Pizza pizza = new Pizza();
				BebidaCardapio bebida = new BebidaCardapio();
				if(mesa == null){
					Toast.makeText(CadastroPedido.this, "Selecione uma mesa!", Toast.LENGTH_SHORT).show();
				}else{
					pedido.setMesa(mesa);
				}
//				if(!txtbebida.getText().toString().equals("")){
//					bebida.setId(Integer.parseInt(txtbebida.getText().toString()));
//				}
//				if(!txtpizza.getText().toString().equals("")){
//					pizza.setId(Integer.parseInt(txtpizza.getText().toString()));
//				}
//				pedido.setBebida(bebida);
//				pedido.setPizza(pizza);
//				PedidoDAO dao = new PedidoDAO(getBaseContext());
//				if(dao.salva(pedido)){Toast.makeText(
//						getBaseContext(), "sucesso!", Toast.LENGTH_SHORT).show();
//				}
				
			}
		});
        
		btnPizza.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),	PedidoPizza.class));

			}
		});
		
		btnBebida.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				startActivity(new Intent(getBaseContext(),	PedidoBebida.class));
			}
		});
    }
}
