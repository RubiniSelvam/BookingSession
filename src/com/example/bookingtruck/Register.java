package com.example.bookingtruck;



import java.util.regex.Matcher;


import java.util.regex.Pattern;
import android.app.Activity;
import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity{
	String phonenumber,username,password;
	private EditText phno,mail,pass;
	DBAdapter dbAdapter;
	

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	  dbAdapter=new DBAdapter(this);
	  dbAdapter.open();
	        setContentView(R.layout.register);
	        phno=(EditText)findViewById(R.id.editText1);
	        mail=(EditText)findViewById(R.id.editText2);
	        pass=(EditText)findViewById(R.id.editText3);
	          
	 }
	 
	 public void register_data(View v)
	 {
		 phonenumber=phno.getText().toString();
		 username=mail.getText().toString();
		 password=pass.getText().toString();
		 boolean check=false;
		 
		 	 

			
		Pattern p;
		   Matcher m;
	   
		  String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		    p = Pattern.compile(EMAIL_STRING);

		    m = p.matcher(username);
		    check = m.matches();

		   
		    
			 if((!Pattern.matches("[a-zA-Z]+", phonenumber))||(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", username))||(Pattern.matches("[a-zA-Z0-9]+", password)))
			    {   
			        if((phonenumber.length() >10)||(phonenumber.length() <10))
			        {
			             Toast.makeText(getApplicationContext(), "phno. is not valid...", Toast.LENGTH_LONG).show();
			         
			        }else if(check == false){
			        	 Toast.makeText(getApplicationContext(), "Email. is not valid...", Toast.LENGTH_LONG).show();
			        }else if((password.length() >6)||(password.length() <6)){
			        	 Toast.makeText(getApplicationContext(), "Password should be 6 characters...", Toast.LENGTH_LONG).show();
			        }else
			        {
			            check = true;
			            long l=dbAdapter.register(phonenumber, username, password);
			            if(l!=-1)
			            
			        	Toast.makeText(getApplicationContext(), "Account Created",Toast.LENGTH_LONG).show();
			            Intent i=new Intent(Register.this,Booking.class);
			            startActivity(i);
			        }
			    
			    }
			   else 
			    {
			        check=false;
			        
			    }

	 }
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
