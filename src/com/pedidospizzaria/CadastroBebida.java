package com.pedidospizzaria;

import com.pedidospizzaria.dao.BebidaCardapioDAO;
import com.pedidospizzaria.vo.BebidaCardapio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroBebida extends Activity{
	private EditText txtNome;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_bebida);
        
        Button btnOk = (Button)findViewById(R.id.btCadBebida);
        
        txtNome = (EditText)findViewById(R.id.inputNomeBebida);
        
        
        btnOk.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				BebidaCardapio vo = new BebidaCardapio();
				vo.setNome(txtNome.getText().toString());
				
				
				BebidaCardapioDAO dao = new BebidaCardapioDAO(getBaseContext());
				if(dao.insert(vo)){Toast.makeText(
						getBaseContext(), "sucesso!", Toast.LENGTH_SHORT).show();
				finish();
				}
				
			}
		});
    }
}
