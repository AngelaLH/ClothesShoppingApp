package com.example.clothesshopping;

public class ClothingItem {

    private String[] mImagefilenames; //each clothing item has 3 images
    private String mClotheName;
    private String mPrice;
    private String mDesc;
    private int mOrders;
    public ClothingItem(String[] Imagefilenames, String ClothesName, String Price, Integer Orders, String Desc) {
        mImagefilenames = Imagefilenames;
        mClotheName = ClothesName;
        mPrice = Price;
        mOrders = Orders;
        mDesc = Desc;
    }
    public String getImagefilename() {
        return mImagefilenames[0];
    }
    public String[] getImagefilenames() {
        return mImagefilenames;
    }
    public String getClothesName() { return mClotheName; }
    public String getPrice() {
        return mPrice;
    }
    public int getOrders() {
        return mOrders;
    }
    public String getDesc() {
        return mDesc;
    }
}
