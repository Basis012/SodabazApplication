package com.sodabazapplication.Modelclasses;

public class Dashboard_Market_ModelClass {
    String title;
    String subtitle;
    String initialprice;
    String actualprice;
    String image;

    public Dashboard_Market_ModelClass(String title, String subtitle, String initialprice, String actualprice, String image) {
        this.title = title;
        this.subtitle = subtitle;
        this.initialprice = initialprice;
        this.actualprice = actualprice;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getInitialprice() {
        return initialprice;
    }

    public void setInitialprice(String initialprice) {
        this.initialprice = initialprice;
    }

    public String getActualprice() {
        return actualprice;
    }

    public void setActualprice(String actualprice) {
        this.actualprice = actualprice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
