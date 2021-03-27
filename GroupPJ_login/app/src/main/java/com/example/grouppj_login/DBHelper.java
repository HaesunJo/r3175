package com.example.grouppj_login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

     public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

         MyDB.execSQL("create Table users(userid TEXT primary key, password TEXT, postalcode TEXT, useremail TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
         MyDB.execSQL("drop Table if exists users");
    }

    public boolean insertData(String userid, String password, String postalcode, String username){
         SQLiteDatabase MyBD = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userid", userid);
        contentValues.put("password", password);
        contentValues.put("postalcode", postalcode);
        contentValues.put("username", username);

        long result = MyBD.insert("users", null, contentValues);

        if(result == -1)
            return false;
        else
            return true;

    }

    public Boolean checkusername(String username){
         SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where userid =? ", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
         SQLiteDatabase MyDB = this.getWritableDatabase();
         Cursor cursor = MyDB.rawQuery("Select * from users where userid=? and password=?", new String[] {username, password});
         if(cursor.getCount()>0)
             return true;
         else
             return false;
    }
}
