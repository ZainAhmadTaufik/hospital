package com.example.hospitalcenter;

public class Datahospital {

    private String gambar, name_hospital, alamat, lokasi;

    public Datahospital(String gambar, String name_hospital, String alamat, String lokasi) {
        this.gambar = gambar;
        this.name_hospital = name_hospital;
        this.alamat = alamat;
        this.lokasi = lokasi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getName_hospital() {
        return name_hospital;
    }

    public void setName_hospital(String name_hospital) {
        this.name_hospital = name_hospital;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
