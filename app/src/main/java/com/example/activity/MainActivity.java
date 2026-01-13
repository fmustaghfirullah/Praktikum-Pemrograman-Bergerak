package com.example.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. Deklarasikan variabel untuk semua tombol
    private Button btnKalkulator, btnLuasBangunDatar, btnIdentitas, btnView, btnViewGroup, btnSoundEffect, btnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKalkulator = findViewById(R.id.btnKalkulator);
        btnLuasBangunDatar = findViewById(R.id.btnLuasBangunDatar);
        btnIdentitas = findViewById(R.id.btnIdentitas);
        btnView = findViewById(R.id.btnView);
        btnViewGroup = findViewById(R.id.btnViewGroup);
        // 2. Inisialisasi tombol SoundEffect dari layout
        btnSoundEffect = findViewById(R.id.btnSoundEffect);
        btnIntent = findViewById(R.id.btnIntent);




        btnKalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        btnLuasBangunDatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LuasBangunDatarActivity.class);
                startActivity(intent);
            }
        });

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentActivity.class);
                startActivity(intent);
            }
        });

        btnIdentitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IdentitasActivity.class);
                startActivity(intent);
            }
        });

        // 3. OnClickListener untuk tombol view
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk pindah ke ViewActivity
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });

        // 4. OnClickListener untuk tombol view group
        btnViewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk pindah ke ViewGroupActivity
                Intent intent = new Intent(MainActivity.this, ViewGroupActivity.class);
                startActivity(intent);
            }
        });

        // 5. [BARU] Tambahkan OnClickListener untuk tombol Sound Effect
        btnSoundEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat Intent untuk pindah ke SoundEffectActivity
                Intent intent = new Intent(MainActivity.this, SoundEffectActivity.class);
                startActivity(intent);
            }
        });
    }
}
