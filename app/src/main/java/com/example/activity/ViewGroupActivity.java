package com.example.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewGroupActivity extends AppCompatActivity {

    private TextView btnCart, badgeCart;
    private TextView catElektronik, catFashion, catMakanan, catOlahraga;
    private LinearLayout product1, product2, product3, product4;
    private Button btnBeli, btnKeranjang;
    private int cartCount = 3;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group);

        // Inisialisasi komponen
        initViews();

        // Setup event listeners
        setupEventListeners();
    }

    private void showToast(String message, int duration) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, message, duration);
        mToast.show();
    }

    private void initViews() {
        // Header
        btnCart = findViewById(R.id.btnCart);
        badgeCart = findViewById(R.id.badgeCart);

        // Kategori
        catElektronik = findViewById(R.id.catElektronik);
        catFashion = findViewById(R.id.catFashion);
        catMakanan = findViewById(R.id.catMakanan);
        catOlahraga = findViewById(R.id.catOlahraga);

        // Produk
        product1 = findViewById(R.id.product1);
        product2 = findViewById(R.id.product2);
        product3 = findViewById(R.id.product3);
        product4 = findViewById(R.id.product4);

        // Buttons
        btnBeli = findViewById(R.id.btnBeli);
        btnKeranjang = findViewById(R.id.btnKeranjang);
    }
    private void setupEventListeners() {
        // Cart Button
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Keranjang berisi " + cartCount + " item", Toast.LENGTH_SHORT);
            }
        });
        // Kategori Buttons
        catElektronik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Kategori: Elektronik", Toast.LENGTH_SHORT);
            }
        });

        catFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Kategori: Fashion", Toast.LENGTH_SHORT);
            }
        });
        catMakanan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showToast("Kategori: Makanan", Toast.LENGTH_SHORT);
            }
        });
        catOlahraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Kategori: Olahraga", Toast.LENGTH_SHORT);
            }
        });

        // Product Cards
        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Produk: Laptop Gaming - Rp 8.500.000", Toast.LENGTH_SHORT);
            }
        });

        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Produk: Smartphone Pro - Rp 5.200.000", Toast.LENGTH_SHORT);
            }
        });

        product3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Produk: Headphone Wireless - Rp 850.000", Toast.LENGTH_SHORT);
            }
        });

        product4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Produk: Smart Watch - Rp 1.200.000", Toast.LENGTH_SHORT);
            }
        });

        // Action Buttons
        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Proses pembelian dimulai...", Toast.LENGTH_LONG);
            }
        });

        btnKeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartCount++;
                badgeCart.setText(String.valueOf(cartCount));
                showToast("Ditambahkan ke keranjang! Total: " + cartCount + " item", Toast.LENGTH_SHORT);
            }
        });
    }
}
