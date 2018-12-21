package com.example.saktiva.tamanwisataselecta;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    //variabel global -> bisa di panggil disemua method
    private ViewFlipper viewFlipper;
    private Animation fadeIn, fadeOut;
    ImageButton ib_profile, ib_resto, ib_wahana, ib_harga, ib_maps, ib_kontak;
    TextView tv_selengkapnya1, tv_selengkapnya2;
    ImageView fotopicasso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //variabel lokal
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //digunakan untuk membuat objek viewflipper dari elemen viewflipper dalam xml yang mempunyai id="ViewFlippe"
        viewFlipper = (ViewFlipper) findViewById(R.id.ViewFlipper);
        //menginisiasikan method fade in fade out yang di load dari xml fade in fadeout di folder anim
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        //menyetting viewflipper dengan animation fade in, dan fade out
        viewFlipper.setAnimation(fadeIn);
        viewFlipper.setAnimation(fadeOut);
        //gambar otomatis flipp sendiri
        viewFlipper.setAutoStart(true);
        //waktu yang dibutuhkan untuk menampilkan gambar ke slide berikutnya
        viewFlipper.setFlipInterval(5000);
        //memulai pengatur waktu untuk melakukan flip
        viewFlipper.startFlipping();


        //menghubungkan class java dengan widget image button
        //btn about us//
        ib_profile = (ImageButton) findViewById(R.id.ib_profile);
        ib_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Profile.class);
                startActivity(i);
            }
        });

        //btn restoran//
        ib_resto = (ImageButton) findViewById(R.id.ib_resto);
        ib_resto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Restaurant.class);
                startActivity(i);
            }
        });

        //btn wahana//
        ib_wahana = (ImageButton) findViewById(R.id.ib_wahana);
        ib_wahana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Wahana.class);
                startActivity(i);
            }
        });

        //btn list harga//
        ib_harga = (ImageButton) findViewById(R.id.ib_harga);
        ib_harga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DaftarHarga.class);
                startActivity(i);
            }
        });

        //btn menuju ke maps
        ib_maps = (ImageButton) findViewById(R.id.ib_maps);
        ib_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

        //btn kontak//
        ib_kontak = (ImageButton) findViewById(R.id.ib_kontak);
        ib_kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Kontak.class);
                startActivity(i);
            }
        });

        //teks view selengkapnya//mengarah ke list harga//
        tv_selengkapnya1 = (TextView) findViewById(R.id.tv_selengkapnya1);
        tv_selengkapnya1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DaftarHarga.class);
                startActivity(i);
            }
        });


        //text view selengkapnya//mengarah ke kontak//
        tv_selengkapnya2 = (TextView) findViewById(R.id.tv_selengkapnya2);
        tv_selengkapnya2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Kontak.class);
                startActivity(i);
            }
        });

        /////////////PICASSO////////////

        //Picasso adalah library untuk image cache di Android//

        //menghubungkan class java dengan widget image view
        fotopicasso = (ImageView) findViewById(R.id.fotopicasso);

        //url gambar, Uri link gambar yg di ambil dari internet
        String imageUri = "https://services.sportourism.id/fileload/selectajpg-X5j3.jpg?q=75";

        //picasso digunakan di class ini
        //untuk mengatur size gambar
        Picasso.with(this).load(imageUri).resize(450,300).into(fotopicasso);
    }


}
