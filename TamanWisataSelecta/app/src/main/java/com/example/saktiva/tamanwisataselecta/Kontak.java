package com.example.saktiva.tamanwisataselecta;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Kontak extends AppCompatActivity {

    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        ton1 = (Button) findViewById(R.id.btnSimpan);

        //ketika button kirim di klik, maka data akan dimasukan ke dalam database tepat nya di tabel kontak
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into kontak(no, nama, email, isi) values('" +
                        text1.getText().toString()+"','"+
                        text2.getText().toString() +"','" +
                        text3.getText().toString()+"','"+
                        text4.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
//                MainActivity.ma.RefreshList();
                finish();
            }
        });


        //intent button menuju ke list database
        ton2 = (Button) findViewById(R.id.btn_cekdatabase);
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Kontak.this, ListDatabase.class);
                startActivity(i);
            }
        });


    }

}
