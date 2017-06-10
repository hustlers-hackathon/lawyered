package com.mit.law.model;

import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class ThirdParties {
    private String tpid;
    private String mobile;
    private String office;
    private String desc;
    private String revenueType;
    private double reviewAvg;
    private long rateCount;
    private List<String> tags;


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
}
