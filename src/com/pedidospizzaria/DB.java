package com.pedidospizzaria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper{

	private static String dbNome = "pedidoPizzaria.db";
	
	private static String sqlMesa = "CREATE TABLE [mesa] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE);";
	
	private static String sqlPedido = "CREATE TABLE [pedido] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[id_mesa] INTERGER, " +
			"FOREIGN KEY(id_mesa) REFERENCES mesa(id));";
	
	private static String sqlPizza = "CREATE TABLE [pizza] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[nome] varchar(30), " +
			"[preço] FLOAT);";
	
	private static String sqlBorda = "CREATE TABLE [borda] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[nome] varchar(30), " +
			"[preço] FLOAT);";
	
	private static String sqlPratoPreparo = "CREATE TABLE [prato_preparo] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[id_pedido] INTEGER, " +
			"[id_borda] INTEGER, " +
			"FOREIGN KEY(id_borda) REFERENCES borda(id), " +
			"FOREIGN KEY(id_pedido) REFERENCES pedido(id));";
			
	
	private static String sqlIngredientePrato = "CREATE TABLE [ingrediente_prato] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[nome] varchar(30)," +
			"[preco]FLOAT);";
	
	private static String sqlSabor = "CREATE TABLE [sabor] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[id_prato_preparo] INTEGER, " +
			"[id_pizza] INTEGER ," +
			"FOREIGN KEY(id_pizza) REFERENCES pizza(id)" +
			"FOREIGN KEY(id_prato_preparo) REFERENCES prato_preparo(id));";
	
	private static String sqlIngredientePizza = "CREATE TABLE [ingrediente_pizza] " +
			"([id_pizza] INTEGER, " +
			"[id_ingrediente] INTEGER, " +
			"FOREIGN KEY(id_ingrediente) REFERENCES ingrediente_prato(id), " +
			"FOREIGN KEY(id_pizza) REFERENCES pizza(id));";
	
	
	private static String sqlDecrescimoPrato = "CREATE TABLE [decrescimo_prato] " +
			"([id_sabor] INTEGER, " +
			"[id_ingrediente] INTEGER, " +
			"FOREIGN KEY(id_sabor) REFERENCES sabor(id), " +
			"FOREIGN KEY(id_ingrediente) REFERENCES ingrediente_prato(id));";
	
	private static String sqlAcrescimoPrato = "CREATE TABLE [acrescimo_prato] " +
			"([id_ingrediente] INTEGER, " +
			"FOREIGN KEY(id_ingrediente) REFERENCES ingrediente_prato(id));";
	
	private static String sqlSaborAcrescimo = "CREATE TABLE [sabor_has_acrescimo] " +
			"([id_sabor] INTEGER, " +
			"[id_acrescimo] INTEGER, " +
			"FOREIGN KEY(id_sabor) REFERENCES sabor(id), " +
			"FOREIGN KEY(id_acrescimo) REFERENCES acrescimo_prato(id_ingrediente));";
	
	
	private static String sqlUsuario = "CREATE TABLE [usuario] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[id_mesa] INTEGER, " +
			"[id_login] INTEGER, " +
			"FOREIGN KEY(id_mesa) REFERENCES mesa(id));";
	
	private static String sqlBebidaCardapio = "CREATE TABLE [bebida_cardapio] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[nome] varchar(30), " +
			"[preço] FLOAT);";
	
	
	private static String sqlBebidaPreparo = "CREATE TABLE [bebida_preparo] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[id_pedido] INTEGER, " +
			"[id_bebida_cardapio] INTEGER, " +
			"FOREIGN KEY(id_bebida_cardapio) REFERENCES bebida_cardapio(id), " +
			"FOREIGN KEY(id_pedido) REFERENCES pedido(id)); ";
			
	
	private static String sqlIngredienteBebida = "CREATE TABLE [ingrediente_bebida] " +
			"([id] INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
			"[nome] varchar(30), " +
			"[preco] FLOAT, " +
			"[volume] varchar(10));";
	
	private static String sqlIngredienteBebidaCardapio = "CREATE TABLE [ingrediente_bebida_cardapio] " +
			"([id_bebida_cardapio] INTEGER, " +
			"[id_ingrediente_bebida] INTEGER, " +
			"FOREIGN KEY(id_bebida_cardapio) REFERENCES bebida_cardapio(id), " +
			"FOREIGN KEY(id_ingrediente_bebida) REFERENCES ingrediente_bebida(id));";
	
	private static String sqlDecrescimoBebida = "CREATE TABLE [decrescimo_bebida] " +
			"([id_bebida_preparo] INTEGER, " +
			"[id_ingrediente_bebida] INTEGER, " +
			"FOREIGN KEY(id_bebida_preparo) REFERENCES bebida_preparo(id), " +
			"FOREIGN KEY(id_ingrediente_bebida) REFERENCES ingrediente_bebida(id));";
				
	private static String sqlAcrescimoBebida = "CREATE TABLE [acrescimo_bebida] " +
			"([id_ingrediente_bebida] INTEGER, " +
			"FOREIGN KEY(id_ingrediente_bebida) REFERENCES ingrediente_bebida(id));";
	
	private static String sqlBebidaPreparoHasAcrescimo = "CREATE TABLE [bebida_preparo_has_acrescimo] " +
			"([id_bebida_preparo] INTEGER, " +
			"[id_acrescimo_bebida] INTEGER, " +
			"FOREIGN KEY(id_bebida_preparo) REFERENCES bebida_preparo(id), " +
			"FOREIGN KEY(id_acrescimo_bebida) REFERENCES acrescimo_bebida(id_ingrediente_bebida));";
	
	private static int version = 1;
	

	public DB(Context context) {
		super(context, dbNome, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlMesa);
		db.execSQL(sqlPedido);
		db.execSQL(sqlPizza);
		db.execSQL(sqlBorda);
		db.execSQL(sqlPratoPreparo);		
		db.execSQL(sqlIngredientePrato);
		db.execSQL(sqlSabor);
		db.execSQL(sqlIngredientePizza);		
		db.execSQL(sqlDecrescimoPrato);
		db.execSQL(sqlAcrescimoPrato);
		db.execSQL(sqlSaborAcrescimo);
		db.execSQL(sqlBebidaCardapio);
		db.execSQL(sqlIngredienteBebida);
		db.execSQL(sqlBebidaPreparo);		
		db.execSQL(sqlIngredienteBebidaCardapio);
		db.execSQL(sqlDecrescimoBebida);
		db.execSQL(sqlAcrescimoBebida);
		db.execSQL(sqlBebidaPreparoHasAcrescimo);
		db.execSQL(sqlUsuario);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
