package com.mit.law.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ASUS on 6/10/2017.
 */

public class Notification implements Parcelable {
    private String nid;
    private String desc;
    private String type;
    private String lbid;
    private String userId;
    private int status;
    private String lawBrokenDesc;
    private String lawShortDesc;
    private String lawyerID;

    public Notification(){

    }


    protected Notification(Parcel in) {
        nid = in.readString();
        desc = in.readString();
        type = in.readString();
        lbid = in.readString();
        userId = in.readString();
        status = in.readInt();
        lawBrokenDesc = in.readString();
        lawShortDesc = in.readString();
        lawyerID = in.readString();
    }

    public static final Creator<Notification> CREATOR = new Creator<Notification>() {
        @Override
        public Notification createFromParcel(Parcel in) {
            return new Notification(in);
        }

        @Override
        public Notification[] newArray(int size) {
            return new Notification[size];
        }
    };

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLbid() {
        return lbid;
    }

    public void setLbid(String lbid) {
        this.lbid = lbid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLawBrokenDesc() {
        return lawBrokenDesc;
    }

    public void setLawBrokenDesc(String lawBrokenDesc) {
        this.lawBrokenDesc = lawBrokenDesc;
    }

    public String getLawShortDesc() {
        return lawShortDesc;
    }

    public void setLawShortDesc(String lawShortDesc) {
        this.lawShortDesc = lawShortDesc;
    }

    public String getLawyerID() {
        return lawyerID;
    }

    public void setLawyerID(String lawyerID) {
        this.lawyerID = lawyerID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nid);
        dest.writeString(desc);
        dest.writeString(type);
        dest.writeString(lbid);
        dest.writeString(userId);
        dest.writeInt(status);
        dest.writeString(lawBrokenDesc);
        dest.writeString(lawShortDesc);
        dest.writeString(lawyerID);
    }
}
