package com.example.administrator.textdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/12/14.
 */

public class People implements Parcelable{
    private String name;
    private String phone;

    protected People(Parcel in) {
        name = in.readString();
        phone = in.readString();
    }

    public People(String name,String phone) {
        this.name=name;
        this.phone=phone;
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
    }
}
