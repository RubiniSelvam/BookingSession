package com.example.bookingtruck;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
private Context mCtx;
private final String DATABASE_TABLE="ruby_truck";
final String KEY_PHONENUMBER="Phonenumber";
final String KEY_EMAIL_ID="Username";
final String KEY_PASSWORD="Password";

SQLiteDatabase mDb;
DBHelper mDbHelper;
	
public DBAdapter(Context context){
	this.mCtx=context;
}

public DBAdapter open() throws SQLException
{
	mDbHelper=new DBHelper(mCtx);
	mDb=mDbHelper.getWritableDatabase();
	return this;
}
public void close()
{
	mDbHelper.close();
}

public boolean Login(String phonenumber,String password)throws SQLException
{
	Cursor mcursor = mDb.rawQuery("SELECT * FROM ruby_truck WHERE Phonenumber=? AND Password=? ",new String[]{phonenumber,password});
	System.out.println("cursor"+mcursor);
	if(mcursor !=null){
		if(mcursor.getCount()>0)
		{
			return true;
		}
	}
	return false;
}
public long register(String phnumber,String mail2,String password){
	ContentValues initialValues=new ContentValues();
	initialValues.put(KEY_PHONENUMBER, phnumber);
	initialValues.put(KEY_EMAIL_ID, mail2);
	initialValues.put(KEY_PASSWORD, password);
	return mDb.insert(DATABASE_TABLE, null, initialValues);
}
	
	
	
	
	
	
	
}

