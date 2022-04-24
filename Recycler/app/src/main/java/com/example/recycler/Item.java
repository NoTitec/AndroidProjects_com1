package com.example.recycler;
//Linear layout layout_height속성 주의!!!!!!!!!!!!!
public class Item {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(String name) {
        this.name = name;
    }
}
