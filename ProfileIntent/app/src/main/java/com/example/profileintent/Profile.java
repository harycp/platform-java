package com.example.profileintent;


import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable {

    private  String fullName;
    private String name;
    private long nim;
    private String address;
    private String hobby;
    private String ideal;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIdeal() {
        return ideal;
    }

    public void setIdeal(String ideal) {
        this.ideal = ideal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullName);
        dest.writeString(this.name);
        dest.writeLong(this.nim);
        dest.writeString(this.address);
        dest.writeString(this.hobby);
        dest.writeString(this.ideal);
    }

    public Profile() {
    }

    protected Profile(Parcel in) {
        this.fullName = in.readString();
        this.name = in.readString();
        this.nim = in.readLong();
        this.address = in.readString();
        this.hobby = in.readString();
        this.ideal = in.readString();
    }

    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
