package com.example.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailBuahActivity extends AppCompatActivity {
    private TextView tvNamaBuah, tvDeskripsiBuah;
    private ImageView ivBuah;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);

        tvNamaBuah = findViewById(R.id.tvNamaBuah);
        tvDeskripsiBuah = findViewById(R.id.tvDeskripsiBuah);
        ivBuah = findViewById(R.id.ivBuah);
        btnKembali = findViewById(R.id.btnKembali);

        // Ambil data dari Intent
        String namaBuah = getIntent().getStringExtra("NAMA_BUAH");
        String deskripsi = getIntent().getStringExtra("DESKRIPSI");
        String warna = getIntent().getStringExtra("WARNA");

        // Set data ke views
        tvNamaBuah.setText(namaBuah);
        tvDeskripsiBuah.setText(deskripsi);

        if (warna != null) {
            tvNamaBuah.setTextColor(Color.parseColor(warna));
        }

        // Set gambar berdasarkan nama buah
        setGambarBuah(namaBuah);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setGambarBuah(String namaBuah) {
        // Set gambar drawable berdasarkan nama buah
        int drawableId = 0;

        switch (namaBuah) {
            case "Apel":
                drawableId = R.drawable.apel;
                break;
            case "Jeruk":
                drawableId = R.drawable.jeruk;
                break;
            case "Pisang":
                drawableId = R.drawable.pisang;
                break;
            case "Pear":
                drawableId = R.drawable.pear;
                break;
            case "Semangka":
                drawableId = R.drawable.semangka;
                break;
        }

        if (drawableId != 0) {
            ivBuah.setImageResource(drawableId);
        } else {
            // Jika gambar tidak ada, tampilkan placeholder
            ivBuah.setImageResource(android.R.drawable.ic_menu_gallery);
        }
    }
}