package com.example.clothesshopping;


import java.util.ArrayList;
import java.util.Random;

public class DataProvider {
    public static ArrayList<String> generateClotheNames() {
        ArrayList ClothesName = new ArrayList<String>();
        ClothesName.add("5XL High Waist Jeans");
        ClothesName.add("Summer Floral Print Pants");
        ClothesName.add("CamkKemsey Japanese Harauku Casual Pants");
        ClothesName.add("Hip Hop High Waist Pants");
        ClothesName.add("Embroidery Denim Pants");
        ClothesName.add("High Waist Leisure");
        ClothesName.add("Jierlur Shorts");
        ClothesName.add("Vintage Leopard Print");
        ClothesName.add("Black Elastic Waist Skirt");
        ClothesName.add("Tangada Black Suit Pants");

        return ClothesName;
    }


    public static ArrayList<ClothingItem> getBottoms() {
        ArrayList ClothingList = new ArrayList<ClothingItem>();
        ArrayList <String> ClothesName = generateClotheNames();
        for (int i = 0; i < 10; i++)
        {
            String image = "bottom_"+String.valueOf((i+1)*3);
            String name = ClothesName.get(i);
            Random r = new Random();
            //max 60.99 min 20.99
            String price = String.valueOf(r.nextInt(61 - 20) + 20)+".99";
            ClothingItem c =new ClothingItem(image, name, price);
            ClothingList.add(c);
        }
        return ClothingList;
    }
}
