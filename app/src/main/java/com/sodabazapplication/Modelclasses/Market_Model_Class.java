package com.sodabazapplication.Modelclasses;

public class Market_Model_Class {
    String title;
    String subtitle;
    String sellinitialprice;
    String sellactualprice;
    String buyinitialprice;
    String buyactualprice;
    String image;

    public Market_Model_Class(String title, String subtitle, String sellinitialprice, String sellactualprice, String buyinitialprice, String buyactualprice, String image) {
        this.title = title;
        this.subtitle = subtitle;
        this.sellinitialprice = sellinitialprice;
        this.sellactualprice = sellactualprice;
        this.buyinitialprice = buyinitialprice;
        this.buyactualprice = buyactualprice;
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

    public String getSellinitialprice() {
        return sellinitialprice;
    }

    public void setSellinitialprice(String sellinitialprice) {
        this.sellinitialprice = sellinitialprice;
    }

    public String getSellactualprice() {
        return sellactualprice;
    }

    public void setSellactualprice(String sellactualprice) {
        this.sellactualprice = sellactualprice;
    }

    public String getBuyinitialprice() {
        return buyinitialprice;
    }

    public void setBuyinitialprice(String buyinitialprice) {
        this.buyinitialprice = buyinitialprice;
    }

    public String getBuyactualprice() {
        return buyactualprice;
    }

    public void setBuyactualprice(String buyactualprice) {
        this.buyactualprice = buyactualprice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
