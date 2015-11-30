package com.example.bookingtruck;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
 
import android.widget.EditText;

public class Booking extends Activity{
  String pickadd,dropadd,date,time;
  private EditText t1,t2,t3,t4;
  

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        t1=(EditText)findViewById(R.id.editText1);
	        t2=(EditText)findViewById(R.id.editText2);
	        t3=(EditText)findViewById(R.id.editText3);
	        t4=(EditText)findViewById(R.id.editText4);
	         
	 }
	
	 public void getfare_data(View v){
		 
		pickadd=t1.getText().toString();
		dropadd=t2.getText().toString();
		date=t3.getText().toString();
		time=t4.getText().toString(); 
	 }
	 
 
	
}

