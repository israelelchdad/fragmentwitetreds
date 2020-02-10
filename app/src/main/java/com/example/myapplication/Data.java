package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    private String  title;
    private String  text;
    private int picture;
    private String  link;


    public Data(String title, String text, int picture, String link) {
        this.title = title;
        this.text = text;
        this.picture = picture;
        this.link = link;
    }


    protected Data(Parcel in) {
        title = in.readString();
        text = in.readString();
        picture = in.readInt();
        link = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(text);
        dest.writeInt(picture);
        dest.writeString(link);
    }
}
