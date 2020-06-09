package com.example.clothesshopping;

import java.util.ArrayList;

public class ClothingItem {

    //private ArrayList<String> mImagefilename_temp; //each clothing item has 3 images
    private String mImagefilename;
    private String mClotheName;
    private String mPrice;
    public ClothingItem(String Imagefilename, String ClotheName, String Price) {
        mImagefilename = Imagefilename;
        mClotheName = ClotheName;
        mPrice = Price;
    }
    public String getImagefilename() {
        return mImagefilename;
    }
    public String getClotheName() { return mClotheName; }
    public String getPrice() {
        return mPrice;
    }
}
