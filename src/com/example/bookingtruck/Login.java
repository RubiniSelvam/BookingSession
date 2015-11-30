package com.example.bookingtruck;





 


import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	DBAdapter dbAdapter;
 
String phnumber,password;
private EditText t1,t2;
   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                dbAdapter=new DBAdapter(this);
                dbAdapter.open();

        t1=(EditText)findViewById(R.id.editText1);
        t2=(EditText)findViewById(R.id.editText2);
        
       
   }
   
public void login_data(View v)
{
	phnumber=t1.getText().toString();
	password=t2.getText().toString();
 





 if((!Pattern.matches("[a-zA-Z]+", phnumber))||(Pattern.matches("[a-zA-Z0-9]+", password)))
    {    
        if((phnumber.length() >10)||(phnumber.length() <10))
        {
             Toast.makeText(getApplicationContext(), "phno. is not valid...", Toast.LENGTH_LONG).show();
         
        } else if((password.length() >6)||(password.length() <6)){
        	 Toast.makeText(getApplicationContext(), "Password should be 6 characters...", Toast.LENGTH_LONG).show();
        }else
        {
        if(dbAdapter.Login(phnumber,password))
        {    
        
        	Toast.makeText(getApplicationContext(), "processing",Toast.LENGTH_LONG).show();
            Intent i=new Intent(Login.this,Booking.class);
            startActivity(i);
      }
        else
        {
        	Toast.makeText(getApplicationContext(), "Invalid mobilenumber or password",Toast.LENGTH_LONG).show();
        }
        }
        }
    

}
 public void register_data(View v)
{
	Intent i=new Intent(Login.this,Register.class);
	startActivity(i);  
}

 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
