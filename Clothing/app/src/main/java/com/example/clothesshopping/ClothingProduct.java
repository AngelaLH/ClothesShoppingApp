package com.example.clothesshopping;

public class ClothingProduct {
    String name;
    double price;
    String category;
    String datePosted;
    //imageslist
    boolean topPick;
    //productDesc

    public ClothingProduct(String name,double price,String category,String datePosted,boolean topPick;) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.datePosted = datePosted;
        this.topPick = topPick;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public boolean isTopPick() {
        return topPick;
    }
}

