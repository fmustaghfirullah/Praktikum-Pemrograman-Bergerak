package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    // Deklarasi komponen View
    private EditText edtNama, edtNim, edtEmail;
    private RadioGroup radioGroupGender;
    private Spinner spinnerProdi;
    private Button btnSubmit, btnReset;
    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        // Inisialisasi komponen View
        initViews();

        // Setup Spinner
        setupSpinner();

        // Event Listeners
        setupEventListeners();
    }

    private void initViews() {
        // EditText
        edtNama = findViewById(R.id.edtNama);
        edtNim = findViewById(R.id.edtNim);
        edtEmail = findViewById(R.id.edtEmail);

        // RadioGroup
        radioGroupGender = findViewById(R.id.radioGroupGender);

        // Spinner
        spinnerProdi = findViewById(R.id.spinnerProdi);

        // Button
        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        // TextView
        txtInfo = findViewById(R.id.txtInfo);
    }

    private void setupSpinner() {
        // Ambil data dari strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.prodi_list,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProdi.setAdapter(adapter);
    }

    private void setupEventListeners() {
        // Event Submit Button
        btnSubmit.setOnClickListener(v -> {
            if (validateForm()) {
                submitForm();
            }
        });

        // Event Reset Button
        btnReset.setOnClickListener(v -> resetForm());
    }

    private boolean validateForm() {
        // Validasi Nama
        String nama = edtNama.getText().toString().trim();
        if (nama.isEmpty()) {
            edtNama.setError("Nama tidak boleh kosong!");
            edtNama.requestFocus();
            return false;
        }

        // Validasi NIM
        String nim = edtNim.getText().toString().trim();
        if (nim.isEmpty()) {
            edtNim.setError("NIM tidak boleh kosong!");
            edtNim.requestFocus();
            return false;
        }

        // Validasi Email
        String email = edtEmail.getText().toString().trim();
        if (email.isEmpty()) {
            edtEmail.setError("Email tidak boleh kosong!");
            edtEmail.requestFocus();
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Format email tidak valid!");
            edtEmail.requestFocus();
            return false;
        }

        // Validasi Jenis Kelamin
        if (radioGroupGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validasi Program Studi
        if (spinnerProdi.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "Pilih program studi!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void submitForm() {
        // Ambil data dari form
        String nama = edtNama.getText().toString().trim();
        String nim = edtNim.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();

        // Ambil jenis kelamin
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedRadio = findViewById(selectedGenderId);
        String jenisKelamin = selectedRadio.getText().toString();

        // Ambil program studi
        String prodi = spinnerProdi.getSelectedItem().toString();

        // Tampilkan hasil
        String hasil = "DATA PENDAFTARAN:\n\n" +
                "Nama: " + nama + "\n" +
                "NIM: " + nim + "\n" +
                "Email: " + email + "\n" +
                "Jenis Kelamin: " + jenisKelamin + "\n" +
                "Program Studi: " + prodi + "\n";

        // Update TextView Info
        txtInfo.setText(hasil);
        txtInfo.setTextSize(14);
        txtInfo.setTextColor(getResources().getColor(R.color.green));

        // Toast sukses
        Toast.makeText(this, "Pendaftaran Berhasil!", Toast.LENGTH_LONG).show();
    }

    private void resetForm() {
        // Reset EditText
        edtNama.setText("");
        edtNim.setText("");
        edtEmail.setText("");

        // Reset RadioButton
        radioGroupGender.clearCheck();

        // Reset Spinner
        spinnerProdi.setSelection(0);


        // Reset TextView Info
        txtInfo.setText("Silakan isi form di atas dengan lengkap");
        txtInfo.setTextSize(12);
        txtInfo.setTextColor(getResources().getColor(R.color.gray));

        // Toast
        Toast.makeText(this, "Form berhasil direset", Toast.LENGTH_SHORT).show();
    }
}
