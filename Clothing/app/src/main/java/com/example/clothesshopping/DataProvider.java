package com.example.clothesshopping;


import java.util.ArrayList;
import java.util.Random;

public class DataProvider {

    //Data for bottoms
    public static ArrayList<String> generateBottomNames() {
        ArrayList BottomNames = new ArrayList<String>();
        BottomNames.add("5XL High Waist Jeans");
        BottomNames.add("Summer Floral Print Pants");
        BottomNames.add("CamkKemsey Japanese Harauku Casual Pants");
        BottomNames.add("Hip Hop High Waist Pants");
        BottomNames.add("Embroidery Denim Pants");
        BottomNames.add("High Waist Leisure");
        BottomNames.add("Jierlur Shorts");
        BottomNames.add("Vintage Leopard Print");
        BottomNames.add("Black Elastic Waist Skirt");
        BottomNames.add("Tangada Black Suit Pants");

        return BottomNames;
    }

    public static ArrayList<ClothingItem> getBottoms() {
        ArrayList BottomList = new ArrayList<ClothingItem>();
        ArrayList <String> BottomsName = generateBottomNames();
        for (int i = 0; i < 10; i++)
        {
            String image = "bottom_"+String.valueOf((i+1)*3);
            String name = BottomsName.get(i);
            Random r = new Random();
            //max 60.99 min 20.99
            String price = String.valueOf(r.nextInt(61 - 20) + 20)+".99";
            ClothingItem c =new ClothingItem(image, name, price);
            BottomList.add(c);
        }
        return BottomList;
    }

    //Data for tops
    public static ArrayList<String> generateTopNames() {
        ArrayList TopNames = new ArrayList<String>();
        TopNames.add("Deep V Neck Sweater");
        TopNames.add("Black Blouse");
        TopNames.add("White Pink Long Sleeve Turtleneck Sweater");
        TopNames.add("Dingaozlz Ruffles Lace Blouse");
        TopNames.add("Elegant Embroidery Long Sleeve");
        TopNames.add("Korean Fashion - Short Sleeve Pink Lacey Blouse");
        TopNames.add("Casual Office Shirt");
        TopNames.add("Autumn Fashion Off Shoulder Lace Top");
        TopNames.add("Autumn Winter Korwan Kawaii Cute Lace");
        TopNames.add("V Neck, Short-Sleeve, Knitted Slim Top");

        return TopNames;
    }

    public static ArrayList<ClothingItem> getTops() {
        ArrayList TopList = new ArrayList<ClothingItem>();
        ArrayList <String> TopNames = generateTopNames();
        for (int i = 0; i < 10; i++)
        {
            String image = "top_"+String.valueOf((i+1)*3);
            String name = TopNames.get(i);
            Random r = new Random();
            //max 60.99 min 20.99
            String price = String.valueOf(r.nextInt(61 - 20) + 20)+".99";
            ClothingItem c =new ClothingItem(image, name, price);
            TopList.add(c);
        }
        return TopList;
    }

    //Data for dresses
    public static ArrayList<String> generateDressNames() {
        ArrayList DressNames = new ArrayList<String>();
        DressNames.add("Summer Shirt Style Black Dress");
        DressNames.add("Floral Print Vintage Dress");
        DressNames.add("Mini Casual Shirt Dress");
        DressNames.add("Sweet Lace White Dress");
        DressNames.add("Off Shoulder High Waist V neck Casual Dress");
        DressNames.add("White Mini Chiffon Dress");
        DressNames.add("Summer Beach Polka Dot Dress");
        DressNames.add("Summer Beach Casual Slim Dress");
        DressNames.add("Korean Autumn Floral Long Sleeve Print Dress");
        DressNames.add("Off Shoulder Floral Print Chiffon Dress");

        return DressNames;
    }

    public static ArrayList<ClothingItem> getDresses() {
        ArrayList DressList = new ArrayList<ClothingItem>();
        ArrayList <String> DressNames = generateDressNames();
        for (int i = 0; i < 10; i++)
        {
            String image = "dress_"+String.valueOf((i+1)*3);
            String name = DressNames.get(i);
            Random r = new Random();
            //max 60.99 min 20.99
            String price = String.valueOf(r.nextInt(61 - 20) + 20)+".99";
            ClothingItem c =new ClothingItem(image, name, price);
            DressList.add(c);
        }
        return DressList;
    }


}
