package com.example.saktiva.tamanwisataselecta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Restaurant extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    //adapter digunakan untuk menghubungkan data dengan recycleview
    //adapter menyiapkan dan menampilkan data dgn view holder,
    //ketika data berubah adapter akan memperbarui data secara otomatis

    private RecyclerView.LayoutManager layoutManager;
    //layout manager untuk menangani susunan layoutnya

    //array listnya
    private ArrayList<String> judul;
    private ArrayList<Integer> foto;

    //Daftar Judul
    private String[] Judul = {"Restaurant Asri", "Restaurant Cantik", "Restaurant Bahagia"};

    //Daftar Gambar
    private int[] Gambar = {R.drawable.resto1,R.drawable.resto2, R.drawable.resto3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        judul = new ArrayList<>();
        foto = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        //memanggila method daftar item
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //buat adapter dan berikan data untuk tampilan
        adapter = new RecyclerViewAdapter(judul, foto);

        //mengubungkan Adapter dgn RecyclerView
        recyclerView.setAdapter(adapter);
    }

    private void DaftarItem() {
        for (int w=0; w<Judul.length; w++){
            foto.add(Gambar[w]);
            judul.add(Judul[w]);
        }
    }
}
