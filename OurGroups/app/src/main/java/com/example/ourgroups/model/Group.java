package com.example.ourgroups.model;

import java.io.Serializable;

public class Group implements Serializable {
    private int id;
    private String name, nim, email, kelompok, aplikasi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKelompok() {
        return kelompok;
    }

    public void setKelompok(String kelompok) {
        this.kelompok = kelompok;
    }

    public String getAplikasi() {
        return aplikasi;
    }

    public void setAplikasi(String aplikasi) {
        this.aplikasi = aplikasi;
    }
}
