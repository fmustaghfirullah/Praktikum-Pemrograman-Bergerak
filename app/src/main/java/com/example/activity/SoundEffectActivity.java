package com.example.activity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SoundEffectActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int soundId;
    private boolean isSoundLoaded = false;
    private Button btnPlaySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_effect);

        // Inisialisasi Tombol
        btnPlaySound = findViewById(R.id.btn_play_sound);

        // 1. Konfigurasi dan inisialisasi SoundPool
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME) // Cocok untuk game atau efek UI
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(1) // Jumlah stream maksimum yang bisa diputar bersamaan
                .setAudioAttributes(audioAttributes)
                .build();

        // 2. Muat file suara dari res/raw
        // Ganti 'R.raw.sound_effect' dengan nama file suara Anda
        soundId = soundPool.load(this, R.raw.sound_effect, 1);

        // 3. Set listener untuk mengetahui kapan suara selesai dimuat
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool sp, int sampleId, int status) {
                if (status == 0) {
                    // status 0 berarti pemuatan berhasil
                    isSoundLoaded = true;
                }
            }
        });

        // 4. Set OnClickListener untuk tombol
        btnPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
            }
        });
    }

    private void playSound() {
        // Hanya putar suara jika sudah berhasil dimuat
        if (isSoundLoaded) {
            // parameter: soundID, leftVolume, rightVolume, priority, loop, rate
            soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 5. Rilis resource SoundPool saat activity dihancurkan
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }
}
