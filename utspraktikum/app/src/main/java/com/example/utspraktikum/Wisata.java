package com.example.utspraktikum;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Wisata implements Parcelable {
    private String nama;
    private String lokasi;
    private ArrayList<String> keunikan;
    private String deskripsi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public ArrayList<String> getKeunikan() {
        return keunikan;
    }

    public void setKeunikan(ArrayList<String> keunikan) {
        this.keunikan = keunikan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.lokasi);
        dest.writeStringList(this.keunikan);
        dest.writeString(this.deskripsi);
    }

    public Wisata() {
    }

    protected Wisata(Parcel in) {
        this.nama = in.readString();
        this.lokasi = in.readString();
        this.keunikan = in.createStringArrayList();
        this.deskripsi = in.readString();
    }

    public static final Creator<Wisata> CREATOR = new Creator<Wisata>() {
        @Override
        public Wisata createFromParcel(Parcel source) {
            return new Wisata(source);
        }

        @Override
        public Wisata[] newArray(int size) {
            return new Wisata[size];
        }
    };
}
