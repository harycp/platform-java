package com.example.profileharycapri;

import android.os.Parcel;
import android.os.Parcelable;

public class Schedule implements Parcelable {
    private String courseName;
    private String day;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.courseName);
        dest.writeString(this.day);
    }

    public Schedule(String courseName, String day) {
        this.courseName = courseName;
        this.day = day;
    }

    protected Schedule(Parcel in) {
        this.courseName = in.readString();
        this.day = in.readString();
    }

    public static final Parcelable.Creator<Schedule> CREATOR = new Parcelable.Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel source) {
            return new Schedule(source);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };
}
