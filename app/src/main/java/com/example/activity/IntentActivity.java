package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class IntentActivity extends AppCompatActivity {

    private ArrayList<MataKuliah> mataKuliahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        // Inisialisasi data mata kuliah
        initMataKuliahData();

        // Inisialisasi komponen
        LinearLayout cardMataKuliah1 = findViewById(R.id.cardMataKuliah1);
        LinearLayout cardMataKuliah2 = findViewById(R.id.cardMataKuliah2);

        // Event click Mata Kuliah 1
        cardMataKuliah1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(mataKuliahList.get(0));
            }
        });

        // Event click Mata Kuliah 2
        cardMataKuliah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(mataKuliahList.get(1));
            }
        });
    }

    private void initMataKuliahData() {
        mataKuliahList = new ArrayList<>();

        // Mata Kuliah 1: Analisis dan Desain Sistem
        mataKuliahList.add(new MataKuliah(
                getString(R.string.mk1_nama),
                getString(R.string.mk1_pengampu),
                getString(R.string.mk1_kode),
                getString(R.string.mk1_deskripsi)
        ));

        // Mata Kuliah 2: Data Mining
        mataKuliahList.add(new MataKuliah(
                getString(R.string.mk2_nama),
                getString(R.string.mk2_pengampu),
                getString(R.string.mk2_kode),
                getString(R.string.mk2_deskripsi)
        ));
    }

    private void openDetailActivity(MataKuliah mataKuliah) {
        Intent intent = new Intent(IntentActivity.this, DetailMataKuliahActivity.class);
        intent.putExtra("nama_matakuliah", mataKuliah.getNamaMataKuliah());
        intent.putExtra("pengampu", mataKuliah.getPengampu());
        intent.putExtra("kode_matakuliah", mataKuliah.getKodeMataKuliah());
        intent.putExtra("deskripsi", mataKuliah.getDeskripsi());
        startActivity(intent);
    }
}
