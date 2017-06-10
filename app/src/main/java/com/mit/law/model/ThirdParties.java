package com.mit.law.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class ThirdParties implements Parcelable {
    private String tpid;
    private String name;
    private String mobile;
    private String office;
    private String desc;
    private String revenueType;
    private double reviewAvg;
    private long rateCount;
    private List<String> tags;

    public ThirdParties(){

    }

    protected ThirdParties(Parcel in) {
        tpid = in.readString();
        name = in.readString();
        mobile = in.readString();
        office = in.readString();
        desc = in.readString();
        revenueType = in.readString();
        reviewAvg = in.readDouble();
        rateCount = in.readLong();
        tags = in.createStringArrayList();
    }

    public static final Creator<ThirdParties> CREATOR = new Creator<ThirdParties>() {
        @Override
        public ThirdParties createFromParcel(Parcel in) {
            return new ThirdParties(in);
        }

        @Override
        public ThirdParties[] newArray(int size) {
            return new ThirdParties[size];
        }
    };

    public String getTpid() {
        return tpid;
    }

    public void setTpid(String tpid) {
        this.tpid = tpid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public double getReviewAvg() {
        return reviewAvg;
    }

    public void setReviewAvg(double reviewAvg) {
        this.reviewAvg = reviewAvg;
    }

    public long getRateCount() {
        return rateCount;
    }

    public void setRateCount(long rateCount) {
        this.rateCount = rateCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tpid);
        dest.writeString(name);
        dest.writeString(mobile);
        dest.writeString(office);
        dest.writeString(desc);
        dest.writeString(revenueType);
        dest.writeDouble(reviewAvg);
        dest.writeLong(rateCount);
        dest.writeStringList(tags);
    }
}
