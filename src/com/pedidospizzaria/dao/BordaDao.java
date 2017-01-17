package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.Borda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BordaDao {
	
	private static String table_name = "borda";
	private Context ctx;
	private static String[] columns = {"id", "nome", "valor"};
	
	public BordaDao() {
		
	}
	
	public BordaDao(Context ctx){
		this.ctx = ctx;
	}
	
	public List<Borda> getAll() {
		Borda borda;
		List<Borda> bordas = new ArrayList<Borda>();
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT * FROM borda", null);
		while(rs.moveToNext()){
			borda = new Borda(rs.getInt(0), rs.getString(1), rs.getFloat(2));
			bordas.add(borda);
		}
		return bordas;
	}
}
