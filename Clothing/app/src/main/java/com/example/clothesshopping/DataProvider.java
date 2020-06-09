package com.example.clothesshopping;


import java.util.ArrayList;
import java.util.Random;

public class DataProvider {
    public static ArrayList<String> generateClotheNames() {

        return null;
    }


    public static ArrayList<ClothingItem> getClothes() {
        ArrayList ClothingList = new ArrayList<ClothingItem>();
        for (int i = 0; i <=30; i++)
        {
            String image = "cloth"+String.valueOf(i);
            String name = "random";
            Random r = new Random();
            String price = String.valueOf(r.nextInt(100 - 20) + 20)+".99";
            ClothingItem c =new ClothingItem(image, name, price);
            ClothingList.add(c);
        }
        return ClothingList;
    }
}
