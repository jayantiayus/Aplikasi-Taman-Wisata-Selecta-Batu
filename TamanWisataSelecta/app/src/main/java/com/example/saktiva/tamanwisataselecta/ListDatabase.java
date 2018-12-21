package com.example.saktiva.tamanwisataselecta;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDatabase extends AppCompatActivity {

    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    //cursor digunakan untuk merepresentasikan hasil query yang dieksekusi pada baris atau kolom tertentu
    DataHelper dbcenter;
    public static ListDatabase ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_database);
        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        //membaca database
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        //merepresentasikan query, lalu menampilkan semua isi tabel kontak
        cursor = db.rawQuery("SELECT * FROM kontak",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = (ListView)findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);

    }
}
