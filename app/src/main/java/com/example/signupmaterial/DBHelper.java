package com.example.signupmaterial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public  DBHelper( Context context){
        super(context,"Usersdata.db",null,1);
    }
    @Override
    public  void onCreate(SQLiteDatabase DB){
        DB.execSQL("create Table studentdetails(name TEXT primary key, regno INT,email TEXT,username TEXT,password TEXT NOT NULL)");
        DB.execSQL(" CREATE TABLE admin(email TEXT primary key UNIQUE NOT NULL,name TEXT,password TEXT NOT NULL)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1){
        DB.execSQL("drop Table if exists studentdetails");
        DB.execSQL("drop Table if exists admin");


    }

    public Boolean RegisterAdmin(String email,String name, String password)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name",name);
        contentValues.put("assword",password);
        long result=DB.insert("admin",null,contentValues);
        if(result==-1) {
            return false;
        }else{
            return true;
        }

    }
    public Boolean SignUpForm(String name,String regno, String email, String username, String password)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("regno",regno);
        contentValues.put("email",email);
        contentValues.put("username",username);
        contentValues.put("password",password);



        long result=DB.insert("studentdetails",null,contentValues);
        if(result==-1) {
            return false;
        }else{
            return true;
        }

    }



    public Boolean checkAdminName(String name) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM admin WHERE name = ? ", new String[] {name} );
        if(cursor.getCount()>0){
            return  true;
        }
        else{
            return false;
        }

    }

    public Boolean checkAminEmail(String email) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM admin WHERE email = ? ", new String[] {email} );
        if(cursor.getCount()>0){
            return  true;
        }
        else{
            return false;
        }

    }

    public Boolean checkAdminAuth(String email,String password) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM admin WHERE email = ? AND password =?", new String[] {email,password} );
        if(cursor.getCount()>0){
            return  true;
        }
        else{
            return false;
        }

    }
    }







//    public Boolean updateuserdata(String name,String contact, String dob)
//    {
//        SQLiteDatabase DB=this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("contact",contact);
//        contentValues.put("dob",dob);
//        Cursor cursor = DB.rawQuery("select * from Userdetails where name=?",new String[] {name});
//        if(cursor.getCount()>0) {
//            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }else
//        {
//            return  false;
//        }
//
//    }
//

//    public Boolean deletedata(String name)
//    {
//        SQLiteDatabase DB=this.getWritableDatabase();
//        Cursor cursor = DB.rawQuery("select * from Userdetails where name=?",new String[] {name});
//        if(cursor.getCount()>0) {
//            long result = DB.delete("Userdetails", "name=?", new String[]{name});
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }else
//        {
//            return  false;
//        }
//
//    }
//
//
//
//    public Cursor getdata()
//    {
//        SQLiteDatabase DB=this.getWritableDatabase();
//        Cursor cursor = DB.rawQuery("select * from Userdetails", null);
//        return cursor;







