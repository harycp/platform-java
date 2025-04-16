package com.example.utspraktikum;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan implements Parcelable {
    private String nama;
    private String asal;
    private double harga;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.asal);
        dest.writeDouble(this.harga);
    }

    public Makanan() {
    }

    protected Makanan(Parcel in) {
        this.nama = in.readString();
        this.asal = in.readString();
        this.harga = in.readDouble();
    }

    public static final Parcelable.Creator<Makanan> CREATOR = new Parcelable.Creator<Makanan>() {
        @Override
        public Makanan createFromParcel(Parcel source) {
            return new Makanan(source);
        }

        @Override
        public Makanan[] newArray(int size) {
            return new Makanan[size];
        }
    };
}
