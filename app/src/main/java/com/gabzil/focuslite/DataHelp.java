package com.gabzil.focuslite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelp {
	SQLiteDatabase db;
	Context context;

	public DataHelp(Context con)
	{
		this.context = con;
		SQLiteOpenHelper myHelper = new MyOpenHelper(this.context);
		this.db = myHelper.getWritableDatabase();
	}

	public void LoginSbmt(String Email,String Pass)
	{
		ContentValues conV = new ContentValues();
		conV.put("UserName",Email);
		conV.put("Password",Pass);

		db.insert(MyOpenHelper.TABLE_NAME,null,conV);
	}

	public void dbClose(SQLiteDatabase db)
	{
		db.close();
	}
}
