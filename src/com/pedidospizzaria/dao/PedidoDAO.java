package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;


import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.Pedido;
import com.pedidospizzaria.vo.Pizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PedidoDAO {
	private static String table_name = "pedido";
	private Context ctx;
	
	public PedidoDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public boolean salva(Pedido vo){
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		ContentValues ctv = new ContentValues();		
		return db.insert(table_name, null, ctv)>0;
	}
	
	public List<Pedido> getAll() {
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();		
		Cursor rs = db.rawQuery("SELECT * FROM pedido", null);		
		List<Pedido> lista = new ArrayList<Pedido>();		
		while(rs.moveToNext()){
			
			
		}		
		return lista;
	}
}