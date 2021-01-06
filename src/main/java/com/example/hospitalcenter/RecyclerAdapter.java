package com.example.hospitalcenter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private  ArrayList<Datahospital> arrayList = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(ArrayList<Datahospital> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(arrayList.get(position).getGambar()).into(holder.gambar);
        holder.name_hospital.setText(arrayList.get(position).getName_hospital());
        holder.alamat.setText(arrayList.get(position).getAlamat());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, arrayList.get(position).getName_hospital(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, Detailhospital.class);

                intent.putExtra("gambar", arrayList.get(position).getGambar());
                intent.putExtra("name_hospital", arrayList.get(position).getName_hospital());
                intent.putExtra("lokasi", arrayList.get(position).getLokasi());
                intent.putExtra("alamat", arrayList.get(position).getAlamat());

                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        ImageView gambar;
        TextView name_hospital, alamat;
        LinearLayout linearLayout;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = (ImageView) itemView.findViewById(R.id.imageView);
            name_hospital = (TextView) itemView.findViewById(R.id.textViewhospital);
            alamat = (TextView) itemView.findViewById(R.id.textviewalamat);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}

