package com.example.grouppj_login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "UserInformation.db";
    final static int DATABASE_VERSION = 1;
    final static String TABLE1_NAME = "Patients";
    //final static String TABLE2_NAME = "Doctor";
    //final static String TABLE3_NAME = "Cashier";
    //final static String TABLE4_NAME = "Admin";

    final static String T1COL_1 = "PId";
    final static String T1COL_2 = "PName";
    final static String T1COL_3 = "PEmail";
    final static String T1COL_4 = "PostalCode";
    final static String T1COL_5 = "PPw";

    public  DatabaseHelper (@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase db){
            String query = "CREATE TABLE " + TABLE1_NAME + " (" + T1COL_1 + "INTERGER PRIMARY KEY, "
                    + T1COL_2 + " TEXT, " + T1COL_3 + " TEXT, " + T1COL_4 + " TEXT, " + T1COL_5 + " TEXT)";
            db.execSQL(query);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
            onCreate(db);
        }

        public boolean addRecord(String name, String email, String post, String pw) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(T1COL_2, name);
            values.put(T1COL_3, email);
            values.put(T1COL_4, post);
            values.put(T1COL_5, pw);

            long result = sqLiteDatabase.insert(TABLE1_NAME, null, values);
            if(result > 0)
                return true;
            else
                return false;

        }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE1_NAME;
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        return c;
    }


}


