package com.example.pc.socialnet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;

public class Handler_sqlite extends SQLiteOpenHelper{
    public Handler_sqlite(Context ctx) {
        super(ctx, "Mi Base", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query= "CREATE TABLE contactos(" +_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT,last_mess TEXT );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version_ant, int version_nue) {
        db.execSQL("DROP TABLE IF EXIST contactos");
        onCreate(db);
    }

    public void insertarReg(String nom, String msj){
        ContentValues valores= new ContentValues();
        valores.put("nombre",nom);
        valores.put("last_mess",msj);
        this.getWritableDatabase().insert("contactos",null,valores);
    }

    public String leer(){
        String result="";
        String columnas[]={"nombre","last_mess"};
        Cursor c= this.getReadableDatabase().query("contactos",columnas,null,null,null,null,null);

        int in,il;
        in=c.getColumnIndex("nombre");
        il=c.getColumnIndex("last:mess");
        c.moveToLast();
        result=c.getString(in)+" "+c.getString(il)+"\n";
        return result;
    }


    public void abrir(){
        this.getWritableDatabase();
    }
}
