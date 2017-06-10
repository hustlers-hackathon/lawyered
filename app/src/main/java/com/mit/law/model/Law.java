package com.mit.law.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class Law implements Parcelable{
    private String lawId;
    private String title;
    private String shortDesc;
    private String fullDesc;
    private String quote;
    private List <String> tags;

    public Law(){

    }


    protected Law(Parcel in) {
        lawId = in.readString();
        title = in.readString();
        shortDesc = in.readString();
        fullDesc = in.readString();
        quote = in.readString();
        tags = in.createStringArrayList();
    }

    public static final Creator<Law> CREATOR = new Creator<Law>() {
        @Override
        public Law createFromParcel(Parcel in) {
            return new Law(in);
        }

        @Override
        public Law[] newArray(int size) {
            return new Law[size];
        }
    };

    public String getLawId() {
        return lawId;
    }

    public void setLawId(String lawId) {
        this.lawId = lawId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lawId);
        dest.writeString(title);
        dest.writeString(shortDesc);
        dest.writeString(fullDesc);
        dest.writeString(quote);
        dest.writeStringList(tags);
    }
}
