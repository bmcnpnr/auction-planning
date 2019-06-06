package com.check24.task.model;

import java.util.ArrayList;
import java.util.List;

public class Advertisement {
    private Integer advertisementId;
    private String title;
    private String description;
    private String hyperLink;
    private Integer budget;
    private Integer revenue;
    private Integer pricePerClick;
    private List<String> keywords = new ArrayList<>();

    public Advertisement(String title, String description, String hyperLink) {
        this.title = title;
        this.description = description;
        this.hyperLink = hyperLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }

    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getPricePerClick() {
        return pricePerClick;
    }

    public void setPricePerClick(Integer pricePerClick) {
        this.pricePerClick = pricePerClick;
    }

    public List<String> getKeywords() {
        return keywords;
    }
}
