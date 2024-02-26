package com.mziuri.AddClasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class AddClass {
    private ArrayList<Product> arrayList;
    private String pass;
    @JsonCreator
    public AddClass(
            @JsonProperty("products")ArrayList<Product> arrayList,
            @JsonProperty("password")String pass) {
        this.arrayList = arrayList;
        this.pass = pass;
    }

    public AddClass() {
    }

    public ArrayList<Product> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Product> arrayList) {
        this.arrayList = arrayList;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
