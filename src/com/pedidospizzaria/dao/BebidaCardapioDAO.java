package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.BebidaCardapio;
import com.pedidospizzaria.vo.IngredienteBebida;
import com.pedidospizzaria.vo.Pizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BebidaCardapioDAO {
	private static String table_name = "bebida_cardapio";
	private Context ctx;
	private static String[] columns = {"id","nome"};
	
	public BebidaCardapioDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public BebidaCardapioDAO(){
		
	}
	
	public boolean insert(BebidaCardapio vo){
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		
		ContentValues ctv = new ContentValues();
		ctv.put("nome"    , vo.getNome());
		
		
		return db.insert(table_name, null, ctv) > 0 ;
	}
	
	public List<BebidaCardapio> getAll(){
		Log.e("daoBebida", "metodo dao getall");
		BebidaCardapio bebida;
		List<IngredienteBebida> ingredienteBebidas;
		IngredienteBebidaDao ingredienteBebidaDao = new IngredienteBebidaDao(ctx);
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Log.e("daoBebida", "criou o db");
		Cursor rs = db.rawQuery("SELECT * FROM bebida_cardapio", null);
		Log.e("daoBebida", "fez a pesquiza");
		List<BebidaCardapio> bebidas = new ArrayList<BebidaCardapio>();
		while(rs.moveToNext()){
			bebida = new BebidaCardapio(rs.getInt(0),rs.getString(1));
			Log.e("daoBebida", "criou a bebida");
			ingredienteBebidas = new ArrayList<IngredienteBebida>();
			ingredienteBebidas = ingredienteBebidaDao.getByBebidaCardapio(bebida.getId());
			bebida.setIngredienteBebidas(ingredienteBebidas);
			bebidas.add(bebida);
		}
		return bebidas;
	}
	
}
