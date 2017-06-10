package com.mit.law.model;

import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class Law {
    private String lawId;
    private String title;
    private String shortDesc;
    private String fullDesc;
    private String quote;
    private List <String> tags;


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
}
