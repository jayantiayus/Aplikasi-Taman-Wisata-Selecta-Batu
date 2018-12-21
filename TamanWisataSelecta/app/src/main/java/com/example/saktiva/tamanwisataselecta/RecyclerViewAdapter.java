package com.example.saktiva.tamanwisataselecta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saktiva on 12/12/2018.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> arrayList; //Digunakan untuk Judul
    private ArrayList<Integer> restoList; //Digunakan untuk Image/Gambar

    public RecyclerViewAdapter(ArrayList<String> arrayList, ArrayList<Integer> restoList) {
        this.arrayList = arrayList;
        this.restoList = restoList;
    }

    //ViewHolder berisi tampilan informasi untuk menampilkan satu item dari layout item
    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView judul, ket;
        private ImageView foto;
        private RelativeLayout ItemList;
        private Context context;

        ViewHolder(View itemView) {
            super(itemView);

            //Untuk Menghubungkan dan Mendapakan Context dari MainActivity
            context = itemView.getContext();

            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            judul = (TextView) itemView.findViewById(R.id.judul);
            ket = (TextView) itemView.findViewById(R.id.ket);

            foto = (ImageView) itemView.findViewById(R.id.foto);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }

    //onBindViewHolder untuk menghubungkan data dengan view holder pada posisi yang
    //ditentukan dalam recycleview
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Memasukan Nilai/Value Pada View-View Yang Telah Dibuat
        final String Nama = arrayList.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan
        holder.judul.setText(Nama);
        holder.ket.setText("resto ke:"+position);
        holder.foto.setImageResource(restoList.get(position)); // Mengambil gambar sesuai posisi yang telah ditentukan
    }


    @Override
    public int getItemCount() {
        //Menghitung Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return arrayList.size();
    }

}
