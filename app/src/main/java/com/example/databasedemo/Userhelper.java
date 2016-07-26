package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Userhelper extends SQLiteOpenHelper{
static String Database_Name="User Database";
static String ID="id";
static String Table_Name="Usertable";
static String Username="UserName"; 
static String Password="password";

static String Create_Table="Create Table "+ Userhelper.Table_Name+"("+Userhelper.ID+" Integer Primary Key Autoincrement,"+Userhelper.Username+" varChar2(30),"+Userhelper.Password+" VarChar2(50));"; 
Context con;
static int Database_version=3;
SQLiteDatabase db;
	public Userhelper(Context context) {
		super(context, Userhelper.Database_Name, null,Userhelper.Database_version);
		con=context;
		Toast.makeText(con, "con called", Toast.LENGTH_LONG).show();
		db=getWritableDatabase();
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(Userhelper.Create_Table);
		Toast.makeText(con, "create table", Toast.LENGTH_LONG).show();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		Toast.makeText(con, "upgrade called "+" old version"+ arg1+" "+"new version"+arg2, Toast.LENGTH_LONG).show();
		// TODO Auto-generated method stub
		
	}
	public long adduser(String u,String p)
    {
		ContentValues cv=new ContentValues();
		cv.put(Userhelper.Username, u);
		cv.put(Userhelper.Password, p);
		long i=db.insert(Userhelper.Table_Name, null, cv);
		return i;
		
		
    }
	
	public Cursor viewusers()
	{
		String cols[]={Username,Password};
		Cursor cr=db.query(Table_Name, cols, null, null, null,null, null);
		return cr;
		
		
		
	}
	
	
	
	
	
	public int  updateuser(String u,String op,String np)
	{
		
		
		
		String arg[]={u,op};
		ContentValues cv=new ContentValues();
		cv.put(Password,np);
		int i=db.update(Table_Name,cv, Username+" =?"+" and "+ Password +" =?", arg);
		return i;
		
		
	}
	
	public Cursor signin(String u,String p)
    {
		String Cols[]={Username,Password};
		String args[]={u,p};
	Cursor q=db.query(Table_Name,Cols, Username +"=?"+"and"+Password+"=?", args, null, null, null);
		
		return q;
    }

}
