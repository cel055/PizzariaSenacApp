package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.IngredientePrato;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class IngredientePratoDao {
	
	private static String table_name = "ingrediente_prato";
	private static String[] columns = {"id", "nome", "preco"};
	private Context ctx;
	
	public IngredientePratoDao() {
		
	}

	public IngredientePratoDao(Context ctx) {
		super();
		this.ctx = ctx;
	}
	
	public List<IngredientePrato> getAll() {
		IngredientePrato ingredientePrato;
		List<IngredientePrato> ingredientePratos = new ArrayList<IngredientePrato>();
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT * FROM ingrediente_prato", null);
		while(rs.moveToNext()){
			ingredientePrato = new IngredientePrato(rs.getInt(0), rs.getString(1), rs.getFloat(3));
			ingredientePratos.add(ingredientePrato);
		}
		return ingredientePratos;
	}
	
	public List<IngredientePrato> getByPizza(Integer idPizza) {
		IngredientePrato ingredientePrato;
		List<IngredientePrato> ingredientePratos = new ArrayList<IngredientePrato>();
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT [ingrediente_prato].[id], [ingrediente_prato].[nome], [ingrediente_prato].[preco] " +
				"FROM [ingrediente_pizza] " +
				"inner join [ingrediente_prato] on " +
				"[ingrediente_pizza].[id_ingrediente] = [ingrediente_prato].[id] " +
				"WHERE [ingrediente_pizza].[id_pizza] = " + idPizza + ";", null);
		while(rs.moveToNext()){
			ingredientePrato = new IngredientePrato(rs.getInt(0), rs.getString(1), rs.getFloat(2));
			ingredientePratos.add(ingredientePrato);
		}
		return ingredientePratos;
	}
	
	public List<IngredientePrato> getAcrescimos() {
		IngredientePrato ingredientePrato;
		List<IngredientePrato> acrescimos = new ArrayList<IngredientePrato>();
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT [ingrediente_prato].[id], [ingrediente_prato].[nome], [ingrediente_prato].[preco] " +
				"FROM [acrescimo_prato] " +
				"INNER JOIN [ingrediente_prato] ON " +
				"[acrescimo_prato].[id_ingrediente] = [ingrediente_prato].[id];", null);
		while(rs.moveToNext()){
			ingredientePrato = new IngredientePrato(rs.getInt(0), rs.getString(1), rs.getFloat(2));
			acrescimos.add(ingredientePrato);
		}
		return acrescimos;
	}
}
