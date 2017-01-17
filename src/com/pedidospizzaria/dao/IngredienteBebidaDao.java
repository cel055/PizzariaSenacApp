package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.IngredienteBebida;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class IngredienteBebidaDao {
	private static String table_name = "ingrediente_bebida";
	private Context ctx;
	private static String[] columns = {"id","nome","preco","volume"};
	
	public IngredienteBebidaDao() {
	
	}
	
	public IngredienteBebidaDao(Context ctx){
		this.ctx = ctx;
	}
	
	public List<IngredienteBebida> getAll() {
		IngredienteBebida ingredienteBebida;
		List<IngredienteBebida> ingredienteBebidas = new ArrayList<IngredienteBebida>();
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT * FROM ingrediente_bebida", null);
		while(rs.moveToNext()){
			ingredienteBebida = new IngredienteBebida(rs.getInt(0), rs.getString(1), rs.getString(3), rs.getFloat(2));
			ingredienteBebidas.add(ingredienteBebida);
		}
		return ingredienteBebidas;
	}
	
	public List<IngredienteBebida> getByBebidaCardapio(Integer idBebida) {
		Log.e("daoBebida", "metodo getByBebidaCardapio");
		IngredienteBebida ingredienteBebida;
		List<IngredienteBebida> ingredienteBebidas = new ArrayList<IngredienteBebida>();
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Log.e("daoBebida", "vai fazer a pesquiza ingrediente");
		Cursor rs = db.rawQuery("select [ingrediente_bebida].[id], [ingrediente_bebida].[nome], " +
				"[ingrediente_bebida].[preco], [ingrediente_bebida].[volume] " +
				"from [ingrediente_bebida_cardapio] " +
				"inner join [ingrediente_bebida] on " +
				"[ingrediente_bebida_cardapio].[id_ingrediente_bebida] = [ingrediente_bebida].[id] " +
				"where [ingrediente_bebida_cardapio].[id_bebida_cardapio] = " + idBebida + ";", null);
		Log.e("daoBebida", "fez a pesquiza ingrediente");
		while(rs.moveToNext()){
			ingredienteBebida = new IngredienteBebida(rs.getInt(0), rs.getString(1), rs.getString(3), rs.getFloat(2));
			Log.e("daoBebida", "criou o ingrediente");
			ingredienteBebidas.add(ingredienteBebida);
		}
		return ingredienteBebidas;
	}
	
	public List<IngredienteBebida> getAcrescimos() {
		IngredienteBebida ingredienteBebida;
		List<IngredienteBebida> acrescimos = new ArrayList<IngredienteBebida>();
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT [ingrediente_bebida].[id], [ingrediente_bebida].[nome], " +
				"[ingrediente_bebida].[preco], [ingrediente_bebida].[volume] " +
				"FROM [acrescimo_bebida] " +
				"INNER JOIN [ingrediente_bebida] ON " +
				"[acrescimo_bebida].[id_ingrediente_bebida] = [ingrediente_bebida].[id];", null);
		while (rs.moveToNext()) {
			ingredienteBebida = new IngredienteBebida(rs.getInt(0), rs.getString(1), rs.getString(3), rs.getFloat(2));
			acrescimos.add(ingredienteBebida);
		}
		return acrescimos;
	}
}
