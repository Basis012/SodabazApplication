package com.sodabazapplication;

public class MyModel {
    String name;
    Integer id;
    String item;
    String number;
    String title;
    String utils;
    Integer formid;

    public MyModel(String name, Integer id, String item, String number, String title, String utils, Integer formid) {
        this.name = name;
        this.id = id;
        this.item = item;
        this.number = number;
        this.title = title;
        this.utils = utils;
        this.formid = formid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUtils() {
        return utils;
    }

    public void setUtils(String utils) {
        this.utils = utils;
    }

    public Integer getFormid() {
        return formid;
    }

    public void setFormid(Integer formid) {
        this.formid = formid;
    }
}
