package com.mit.law.model;

/**
 * Created by ASUS on 6/10/2017.
 */

public class Notification {
    private String nid;
    private String desc;
    private String type;
    private String lbid;
    private String userId;
    private int status;
    private String lawBrokenDesc;
    private String lawShortDesc;
    private String lawyerID;


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
}
