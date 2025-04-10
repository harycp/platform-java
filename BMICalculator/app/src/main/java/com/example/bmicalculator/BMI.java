package com.example.bmicalculator;

import android.os.Parcel;
import android.os.Parcelable;

public class BMI implements Parcelable {

    private double height;
    private double weight;
    private double result;
    private String status;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.height);
        dest.writeDouble(this.weight);
        dest.writeDouble(this.result);
        dest.writeString(this.status);
    }

    public BMI(double height, double weight, double result, String status) {
        this.height = height;
        this.weight = weight;
        this.result = result;
        this.status = status;
    }

    protected BMI(Parcel in) {
        this.height = in.readDouble();
        this.weight = in.readDouble();
        this.result = in.readDouble();
        this.status = in.readString();
    }

    public static final Creator<BMI> CREATOR = new Creator<BMI>() {
        @Override
        public BMI createFromParcel(Parcel source) {
            return new BMI(source);
        }

        @Override
        public BMI[] newArray(int size) {
            return new BMI[size];
        }
    };
}
