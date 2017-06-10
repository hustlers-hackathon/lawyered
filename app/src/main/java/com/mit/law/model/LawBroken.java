package com.mit.law.model;

/**
 * Created by ASUS on 6/10/2017.
 */

public class LawBroken {
    private String lbId;
    private String userId;
    private String lawId;
    private String description;


    public String getLbId() {
        return lbId;
    }

    public void setLbId(String lbId) {
        this.lbId = lbId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLawId() {
        return lawId;
    }

    public void setLawId(String lawId) {
        this.lawId = lawId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
