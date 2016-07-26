package com.example.databasedemo;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Userhelper helper;
SQLiteDatabase db;
EditText ed1,ed2,ed3,ed4,ed5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper =new Userhelper(getApplicationContext());
        db=helper.getWritableDatabase();
        ed1=(EditText)findViewById(R.id.editText1);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed4=(EditText)findViewById(R.id.editText4);
        ed5=(EditText)findViewById(R.id.editText5);
    }

    
    public void adduser(View V)
    {String u=ed1.getText().toString();
    
    String p=ed2.getText().toString();
    
    long i=helper.adduser(u, p);
    if(i>0)
    {Toast.makeText(getApplicationContext(),i+"record inserted", Toast.LENGTH_LONG).show();}
    else
    {Toast.makeText(getApplicationContext(),i+"No record inserted", Toast.LENGTH_LONG).show();}	
    }
    
    
    public void signin(View V)
    {String u=ed1.getText().toString();
    
    String p=ed2.getText().toString();
    Cursor cr=helper.signin(u,p);
   
    if(cr.getCount()>0)
    {Toast.makeText(getApplicationContext(),"correct", Toast.LENGTH_LONG).show();}
    else
    {Toast.makeText(getApplicationContext(),"incorrect", Toast.LENGTH_LONG).show();}	
    }
     
    
    public void viewusers(View v)
    {
    	Cursor cr=helper.viewusers();
    	while(cr.moveToNext())
    	{
    		
    		
    		String n=cr.getString(0);
    		String p=cr.getString(1);
    		{Toast.makeText(getApplicationContext(),n+""+p, Toast.LENGTH_LONG).show();}
    	}
    	
    	
    }
    
    public void updateuser(View v)
    {
    	String u=ed3.getText().toString();
     	String op=ed4.getText().toString();
     	String np=ed3.getText().toString();
    	
    	int i=helper.updateuser(u,op,np);
    	if(i>0)
    	{Toast.makeText(getApplicationContext(),"updated", Toast.LENGTH_LONG).show();}
    	else
    	{Toast.makeText(getApplicationContext(),"not updated", Toast.LENGTH_LONG).show();}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
