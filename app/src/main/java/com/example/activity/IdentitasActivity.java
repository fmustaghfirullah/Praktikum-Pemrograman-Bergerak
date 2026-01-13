package com.example.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class IdentitasActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas);

        Button btnApel = findViewById(R.id.btnApel);
        Button btnJeruk = findViewById(R.id.btnJeruk);
        Button btnPisang = findViewById(R.id.btnPisang);
        Button btnPear = findViewById(R.id.btnPear);
        Button btnSemangka = findViewById(R.id.btnSemangka);

        btnApel.setOnClickListener(this);
        btnJeruk.setOnClickListener(this);
        btnPisang.setOnClickListener(this);
        btnPear.setOnClickListener(this);
        btnSemangka.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(IdentitasActivity.this, DetailBuahActivity.class);

        int id = v.getId();

        if (id == R.id.btnApel) {
            intent.putExtra("NAMA_BUAH", "Apel");
            intent.putExtra("DESKRIPSI", "Apel adalah buah yang kaya akan vitamin dan serat. Rasanya manis dan segar, cocok untuk dikonsumsi langsung atau dijadikan jus.");
            intent.putExtra("WARNA", "#E91E63");
        } else if (id == R.id.btnJeruk) {
            intent.putExtra("NAMA_BUAH", "Jeruk");
            intent.putExtra("DESKRIPSI", "Jeruk merupakan sumber vitamin C yang tinggi. Buah ini memiliki rasa asam manis yang menyegarkan dan baik untuk kesehatan.");
            intent.putExtra("WARNA", "#FF9800");
        } else if (id == R.id.btnPisang) {
            intent.putExtra("NAMA_BUAH", "Pisang");
            intent.putExtra("DESKRIPSI", "Pisang mengandung kalium tinggi yang baik untuk jantung. Rasanya manis dan teksturnya lembut, mudah dicerna oleh tubuh.");
            intent.putExtra("WARNA", "#FFC107");
        } else if (id == R.id.btnPear) {
            intent.putExtra("NAMA_BUAH", "Pear");
            intent.putExtra("DESKRIPSI", "Pear kaya akan antioksidan yang baik untuk kesehatan. Buah mungil ini memiliki rasa manis dan sedikit asam yang unik.");
            intent.putExtra("WARNA", "#9C27B0");
        } else if (id == R.id.btnSemangka) {
            intent.putExtra("NAMA_BUAH", "Semangka");
            intent.putExtra("DESKRIPSI", "Semangka mengandung banyak air yang menyegarkan. Buah ini sangat cocok dikonsumsi saat cuaca panas dan kaya akan vitamin A dan C.");
            intent.putExtra("WARNA", "#4CAF50");
        }

        startActivity(intent);
    }
}