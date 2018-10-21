package com.example.yuhboi.skybuddy_v2_attendant;

public class Item {
    public String name;
    public Double price;

    public Item(){}

    public Item(String name) {
        this.name = name;
        this.price = -1d;
    }
    public Item(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String item) {
        this.name = item;
    }
}

