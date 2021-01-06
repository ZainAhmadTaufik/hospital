package com.example.hospitalcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.LinkedList;
import java.util.Queue;

public class Detailhospital extends AppCompatActivity {

    ImageView viewgambar;
    TextView textnama_hospital, textlokasi, textalamat;
    TextView jblantrian,Totalantrian;
    Button ablantrian;

    Queue<Object> antrian = new LinkedList<>();
    int nomor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailhospital);

        viewgambar = findViewById(R.id.imageView);
        textnama_hospital = findViewById(R.id.textViewhospital);
        textlokasi = findViewById(R.id.textViewlokasi);
        textalamat = findViewById(R.id.textviewalamat);

        getIncomingExtra();

    }

    private void getIncomingExtra(){
        if(getIntent().hasExtra("gambar") && getIntent().hasExtra("name_hospital") && getIntent().hasExtra("lokasi") && getIntent().hasExtra("alamat")){

            String gambar = getIntent().getStringExtra("gambar");
            String name_hospital = getIntent().getStringExtra("name_hospital");
            Log.d("nama", name_hospital);
            String lokasi = getIntent().getStringExtra("lokasi");
            String alamat = getIntent().getStringExtra("alamat");

            setDataActivity(gambar,name_hospital, lokasi, alamat);
        }
    }

    private void setDataActivity(String gambar ,String name_hospital, String lokasi, String alamat){

        Glide.with(this).asBitmap().load(gambar).into(viewgambar);
        textnama_hospital.setText(name_hospital);
        textlokasi.setText(lokasi);
        textalamat.setText(alamat);


        jblantrian = findViewById(R.id.jumlahantrian);
        Totalantrian = findViewById(R.id.totalantrian);
        ablantrian = findViewById(R.id.buttonantrian);

        jblantrian.setText("0");
        Totalantrian.setText("0");

        ablantrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahAntrian();
            }
        });
    }

    private void tambahAntrian(){
        nomor++;
        String antr = "Antrian "+nomor;
        antrian.add(antr);
        String cvt = String.valueOf(antrian.size());
        jblantrian.setText(cvt);
        Totalantrian.setText(""+nomor);

        Toast.makeText(this,"Nomor Antrian " + " "+nomor , Toast.LENGTH_LONG).show();
        Toast.makeText(this,"Silahkan menunggu " + cvt + " Antrian lagi ", Toast.LENGTH_LONG).show();
        Toast.makeText(this,"Mohon untuk bersabar"  , Toast.LENGTH_LONG).show();
    }
}