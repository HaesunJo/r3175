package com.example.grouppj_login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    final static  String TABLE_NAME = "users";

    final static String T1COL_1 = "PId";
    final static String T1COL_2 = "PName";
    final static String T1COL_3 = "PEmail";
    final static String T1COL_4 = "PostalCode";
    final static String T1COL_5 = "PPw";

     public DBHelper(Context context) {
         super(context, DBNAME, null, 1);
         SQLiteDatabase MyDB = this.getWritableDatabase();

         System.out.println("sql");
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

         MyDB.execSQL("create Table "+ TABLE_NAME + "(" + T1COL_1 + " INTERGER PRIMARY KEY, " + T1COL_2 +
                 " TEXT, " + T1COL_3 + " TEXT, " + T1COL_4 + " TEXT, " + T1COL_5 + " TEXT "+ ")" );

         System.out.println("dbCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
         MyDB.execSQL("drop Table if exists " + TABLE_NAME);
         onCreate(MyDB);

        System.out.println("dbUpgrade");

    }

    public boolean insertData(String name, String email, String postalcode, String pswd){
        SQLiteDatabase MyBD = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T1COL_2, name);
        contentValues.put(T1COL_3, email);
        contentValues.put(T1COL_4, postalcode);
        contentValues.put(T1COL_5, pswd);

        long result = 0;
        try {
            result = MyBD.insert(TABLE_NAME, null, contentValues);
        }
        catch(Exception ex) {
            System.out.println("[ERROR 002]" + ex.getMessage());
            throw ex;
        }

        if (result == -1) return false;

        return true;
    }

    public Boolean checkusername(String username){
         SQLiteDatabase MyDB = this.getWritableDatabase();
         String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + T1COL_3 + " = ?";
         Cursor cursor;

         try {
             cursor = MyDB.rawQuery(query, new String[] {username});
         }
         catch (Exception ex) {
             System.out.println("[ERROR 000] " + ex.getMessage());
             throw ex;
         }

        //System.out.println("username");

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
         SQLiteDatabase MyDB = this.getWritableDatabase();
         String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + T1COL_3 + " AND " + T1COL_5;
         Cursor cursor = MyDB.rawQuery(query, new String[] {username, password});

         if(cursor.getCount()>0)
             return true;
         else
             return false;
    }
}
