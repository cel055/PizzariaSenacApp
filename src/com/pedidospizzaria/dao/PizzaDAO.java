package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;



import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.IngredientePrato;
import com.pedidospizzaria.vo.Pizza;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PizzaDAO {
	private static String table_name = "pizza";
	private Context ctx;
	private static String[] columns = {"id","nome"};
	
	
	
	
	public PizzaDAO() {
		super();
	}

	public PizzaDAO(Context ctx){
		this.ctx = ctx;
	}
	
	public boolean insert(Pizza vo) {
		SQLiteDatabase db = new DB(ctx).getWritableDatabase();
		ContentValues ctv = new ContentValues();
		ctv.put("nome", vo.getNome());
		return db.insert(table_name, null, ctv) > 0 ;
	}
	
	public List<Pizza> getAll() {
		Pizza pizza;
		List<IngredientePrato> ingredientePratos;
		IngredientePratoDao ingredientePratoDao = new IngredientePratoDao(ctx);
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT * FROM pizza", null);
		List<Pizza> pizzas = new ArrayList<Pizza>();		
		while(rs.moveToNext()){
			pizza = new Pizza(rs.getInt(0), rs.getString(1));
			ingredientePratos = new ArrayList<IngredientePrato>();
			ingredientePratos = ingredientePratoDao.getByPizza(pizza.getId());
			pizza.setIngredientePratos(ingredientePratos);
			pizzas.add(pizza);
		}		
		return pizzas;
	}
}
