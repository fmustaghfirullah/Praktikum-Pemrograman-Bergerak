package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LuasBangunDatarActivity extends AppCompatActivity {
    private Spinner spinnerBangun;
    private EditText etInput1, etInput2;
    private TextView tvLabel1, tvLabel2, tvHasil, tvRumus;
    private Button btnHitung;
    private LinearLayout layoutInput;

    private String[] bangunDatar;
    private String selectedBangun = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_bangun_datar);

        spinnerBangun = findViewById(R.id.spinnerBangun);
        etInput1 = findViewById(R.id.etInput1);
        etInput2 = findViewById(R.id.etInput2);
        tvLabel1 = findViewById(R.id.tvLabel1);
        tvLabel2 = findViewById(R.id.tvLabel2);
        tvHasil = findViewById(R.id.tvHasil);
        tvRumus = findViewById(R.id.tvRumus);
        btnHitung = findViewById(R.id.btnHitung);
        layoutInput = findViewById(R.id.layoutInput);

        // Inisialisasi array bangun datar dari string resources
        bangunDatar = new String[]{
                getString(R.string.persegi),
                getString(R.string.persegi_panjang),
                getString(R.string.segitiga),
                getString(R.string.lingkaran),
                getString(R.string.trapesium),
                getString(R.string.jajar_genjang)
        };

        // Setup Spinner dengan layout kustom untuk item yang dipilih
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.custom_spinner_item, bangunDatar);
        // Gunakan layout default untuk dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBangun.setAdapter(adapter);

        spinnerBangun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBangun = bangunDatar[position];
                updateInputFields();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuas();
            }
        });
    }

    private void updateInputFields() {
        etInput1.setText("");
        etInput2.setText("");
        tvHasil.setText("-");
        tvRumus.setText("");

        String persegi = getString(R.string.persegi);
        String persegiPanjang = getString(R.string.persegi_panjang);
        String segitiga = getString(R.string.segitiga);
        String lingkaran = getString(R.string.lingkaran);
        String trapesium = getString(R.string.trapesium);
        String jajarGenjang = getString(R.string.jajar_genjang);

        if (selectedBangun.equals(persegi)) {
            tvLabel1.setText(R.string.sisi);
            tvLabel2.setVisibility(View.GONE);
            etInput2.setVisibility(View.GONE);
        } else if (selectedBangun.equals(persegiPanjang)) {
            tvLabel1.setText(R.string.panjang);
            tvLabel2.setText(R.string.lebar);
            tvLabel2.setVisibility(View.VISIBLE);
            etInput2.setVisibility(View.VISIBLE);
        } else if (selectedBangun.equals(segitiga)) {
            tvLabel1.setText(R.string.alas);
            tvLabel2.setText(R.string.tinggi);
            tvLabel2.setVisibility(View.VISIBLE);
            etInput2.setVisibility(View.VISIBLE);
        } else if (selectedBangun.equals(lingkaran)) {
            tvLabel1.setText(R.string.jari_jari);
            tvLabel2.setVisibility(View.GONE);
            etInput2.setVisibility(View.GONE);
        } else if (selectedBangun.equals(trapesium)) {
            tvLabel1.setText(R.string.sisi_atas);
            tvLabel2.setText(R.string.sisi_bawah_tinggi);
            tvLabel2.setVisibility(View.VISIBLE);
            etInput2.setVisibility(View.VISIBLE);
        } else if (selectedBangun.equals(jajarGenjang)) {
            tvLabel1.setText(R.string.alas);
            tvLabel2.setText(R.string.tinggi);
            tvLabel2.setVisibility(View.VISIBLE);
            etInput2.setVisibility(View.VISIBLE);
        }
    }

    private void hitungLuas() {
        String input1 = etInput1.getText().toString().trim();
        String input2 = etInput2.getText().toString().trim();

        if (input1.isEmpty()) {
            Toast.makeText(this, R.string.isi_semua_input, Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double nilai1 = Double.parseDouble(input1);
            double hasil = 0;
            String rumus = "";

            String persegi = getString(R.string.persegi);
            String persegiPanjang = getString(R.string.persegi_panjang);
            String segitiga = getString(R.string.segitiga);
            String lingkaran = getString(R.string.lingkaran);
            String trapesium = getString(R.string.trapesium);
            String jajarGenjang = getString(R.string.jajar_genjang);

            if (selectedBangun.equals(persegi)) {
                hasil = nilai1 * nilai1;
                rumus = "Rumus: sisi × sisi = " + nilai1 + " × " + nilai1;

            } else if (selectedBangun.equals(persegiPanjang)) {
                if (input2.isEmpty()) {
                    Toast.makeText(this, R.string.isi_lebar, Toast.LENGTH_SHORT).show();
                    return;
                }
                double nilai2 = Double.parseDouble(input2);
                hasil = nilai1 * nilai2;
                rumus = "Rumus: panjang × lebar = " + nilai1 + " × " + nilai2;

            } else if (selectedBangun.equals(segitiga)) {
                if (input2.isEmpty()) {
                    Toast.makeText(this, R.string.isi_tinggi, Toast.LENGTH_SHORT).show();
                    return;
                }
                double nilai2 = Double.parseDouble(input2);
                hasil = 0.5 * nilai1 * nilai2;
                rumus = "Rumus: ½ × alas × tinggi = ½ × " + nilai1 + " × " + nilai2;

            } else if (selectedBangun.equals(lingkaran)) {
                hasil = Math.PI * nilai1 * nilai1;
                rumus = "Rumus: π × r² = 3.14 × " + nilai1 + "²";

            } else if (selectedBangun.equals(trapesium)) {
                if (input2.isEmpty()) {
                    Toast.makeText(this, "Mohon isi sisi bawah dan tinggi (pisahkan dengan koma)!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String[] values = input2.split(",");
                if (values.length != 2) {
                    Toast.makeText(this, R.string.format_trapesium, Toast.LENGTH_SHORT).show();
                    return;
                }
                double sisiBawah = Double.parseDouble(values[0].trim());
                double tinggi = Double.parseDouble(values[1].trim());
                hasil = 0.5 * (nilai1 + sisiBawah) * tinggi;
                rumus = "Rumus: ½ × (a+b) × t = ½ × (" + nilai1 + "+" + sisiBawah + ") × " + tinggi;

            } else if (selectedBangun.equals(jajarGenjang)) {
                if (input2.isEmpty()) {
                    Toast.makeText(this, R.string.isi_tinggi, Toast.LENGTH_SHORT).show();
                    return;
                }
                double nilai2 = Double.parseDouble(input2);
                hasil = nilai1 * nilai2;
                rumus = "Rumus: alas × tinggi = " + nilai1 + " × " + nilai2;
            }

            tvHasil.setText(String.format("%.2f", hasil));
            tvRumus.setText(rumus);

        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.input_tidak_valid, Toast.LENGTH_SHORT).show();
        }
    }
}