package com.pedidospizzaria.dao;

import java.util.ArrayList;
import java.util.List;

import com.pedidospizzaria.DB;
import com.pedidospizzaria.vo.Mesa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MesaDao {
	private static String table_name = "mesa";
	private Context ctx;
	private static String[] columns = {"id"};
	
	public MesaDao() {
		
	}
	
	public MesaDao(Context ctx){
		this.ctx = ctx;
	}
	
	public List<Mesa> getAll() {
		Mesa mesa;
		List<Mesa> mesas = new ArrayList<Mesa>();
		SQLiteDatabase db = new DB(ctx).getReadableDatabase();
		Cursor rs = db.rawQuery("SELECT * FROM mesa", null);
		while(rs.moveToNext()){
			mesa = new Mesa(rs.getInt(0));
			mesas.add(mesa);
		}
		return mesas;
	}
}
