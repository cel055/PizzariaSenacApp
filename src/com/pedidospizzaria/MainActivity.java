package com.pedidospizzaria;






import com.pedidospizzaria.vo.BebidaCardapio;
import com.pedidospizzaria.vo.Pedido;
import com.pedidospizzaria.vo.Pizza;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
public static Pizza pizza;
public static BebidaCardapio bebida;
public static Pedido pedido;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btMainCadPizza).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),CadastroPizza.class));
				
			}
			
		});
        findViewById(R.id.btMainCadBebida).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),CadastroBebida.class));
				
			}
			
		});
        findViewById(R.id.btMainCadPedido).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),CadastroPedido.class));
				
			}
			
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
