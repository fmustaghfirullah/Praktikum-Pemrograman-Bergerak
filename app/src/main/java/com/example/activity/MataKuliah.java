package com.example.activity;

public class MataKuliah {
    private String namaMataKuliah;
    private String pengampu;
    private String kodeMataKuliah;
    private String deskripsi;

    public MataKuliah(String namaMataKuliah, String pengampu, String kodeMataKuliah, String deskripsi) {
        this.namaMataKuliah = namaMataKuliah;
        this.pengampu = pengampu;
        this.kodeMataKuliah = kodeMataKuliah;
        this.deskripsi = deskripsi;
    }

    // Getters
    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }

    public String getPengampu() {
        return pengampu;
    }

    public String getKodeMataKuliah() {
        return kodeMataKuliah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
