package com.example.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailMataKuliahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mata_kuliah);

        // Inisialisasi komponen
        Button btnBack = findViewById(R.id.btnBack);
        TextView txtNamaMataKuliah = findViewById(R.id.txtNamaMataKuliah);
        TextView txtPengampu = findViewById(R.id.txtPengampu);
        TextView txtKodeMataKuliah = findViewById(R.id.txtKodeMataKuliah);
        TextView txtDeskripsi = findViewById(R.id.txtDeskripsi);

        // Ambil data dari intent
        String namaMataKuliah = getIntent().getStringExtra("nama_matakuliah");
        String pengampu = getIntent().getStringExtra("pengampu");
        String kodeMataKuliah = getIntent().getStringExtra("kode_matakuliah");
        String deskripsi = getIntent().getStringExtra("deskripsi");

        // Set data ke komponen
        txtNamaMataKuliah.setText(namaMataKuliah);
        txtPengampu.setText(pengampu);
        txtKodeMataKuliah.setText(kodeMataKuliah);
        txtDeskripsi.setText(deskripsi);

        // Event click Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}