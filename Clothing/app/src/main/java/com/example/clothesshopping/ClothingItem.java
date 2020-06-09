package com.example.clothesshopping;

public class ClothingItem {
    private String mImage;
    private String mName;
    private String mPrice;
    public ClothingItem(String imageUrl, String creator, String likes) {
        mImage = imageUrl;
        mName = creator;
        mPrice = likes;
    }
    public String getImageUrl() {
        return mImage;
    }
    public String getCreator() { return mName; }
    public String getLikeCount() {
        return mPrice;
    }
}
