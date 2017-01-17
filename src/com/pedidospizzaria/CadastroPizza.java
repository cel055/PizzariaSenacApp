package com.pedidospizzaria;



import com.pedidospizzaria.dao.PizzaDAO;
import com.pedidospizzaria.vo.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPizza extends Activity{
	private EditText txtNome;
	private EditText txtDesc;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_pizza);
        
        Button btnOk = (Button)findViewById(R.id.btCadPizza);
        
        txtNome = (EditText)findViewById(R.id.inputNomePizza);
        txtDesc = (EditText)findViewById(R.id.inputPizzaDesc);
        
        
        btnOk.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Pizza vo = new Pizza();
				vo.setNome(txtNome.getText().toString());
				
				PizzaDAO dao = new PizzaDAO(getBaseContext());
				if(dao.insert(vo)){
					Toast.makeText(getBaseContext(), "sucesso!", Toast.LENGTH_SHORT).show();
				finish();
				}				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
