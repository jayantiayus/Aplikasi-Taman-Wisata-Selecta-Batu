package com.example.saktiva.tamanwisataselecta;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "taman_wisata.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE kontak(no integer primary key, nama text null, email int null, isi text null);";
        Log.d("data", "onCreate : " +sql);
        db.execSQL(sql);
        sql = "INSERT INTO kontak(no, nama, email, isi) VALUES('10001', 'baba', 'babagmail', 'opoae');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
    }
}