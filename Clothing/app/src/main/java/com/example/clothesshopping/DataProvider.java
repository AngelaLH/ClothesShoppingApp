package com.example.clothesshopping;


import java.util.ArrayList;

public class DataProvider {

    //Data for bottoms
    public static Object[] generateBottoms() {
        ArrayList BottomNames = new ArrayList<String>();
        ArrayList BottomPrices = new ArrayList<String>();
        BottomNames.add("5XL High Waist Jeans");
        BottomPrices.add("15.99");
        BottomNames.add("Summer Floral Print Pants");
        BottomPrices.add("16.99");
        BottomNames.add("CamkKemsey Japanese Harauku Casual Pants");
        BottomPrices.add("20.99");
        BottomNames.add("Hip Hop High Waist Pants");
        BottomPrices.add("11.99");
        BottomNames.add("Embroidery Denim Pants");
        BottomPrices.add("12.99");
        BottomNames.add("High Waist Leisure");
        BottomPrices.add("13.99");
        BottomNames.add("Jierlur Shorts");
        BottomPrices.add("19.99");
        BottomNames.add("Vintage Leopard Print");
        BottomPrices.add("13.99");
        BottomNames.add("Black Elastic Waist Skirt");
        BottomPrices.add("15.99");
        BottomNames.add("Tangada Black Suit Pants");
        BottomPrices.add("30.99");

        return new Object[]{BottomNames, BottomPrices};
    }

    public static ArrayList<ClothingItem> getBottoms() {
        ArrayList BottomList = new ArrayList<ClothingItem>();
        ArrayList BottomsName;
        ArrayList BottomsPrice;
        Object[] Bottoms = generateBottoms();
        BottomsName = (ArrayList) Bottoms[0];
        BottomsPrice = (ArrayList) Bottoms[1];
        int index = 0;
        for (int i = 1; i < 30; i=i+3)
        {
            String[] images = new String[]{"bottom_" + String.valueOf(i), "bottom_" + String.valueOf(i+1), "bottom_" + String.valueOf(i+2)};
            String name = (String) BottomsName.get(index);
            String price = "$" +(String) BottomsPrice.get(index);
            ClothingItem c =new ClothingItem(images, name, price);
            BottomList.add(c);
            index++;
        }
        return BottomList;
    }

    //Data for tops
    public static Object[] generateTops() {
        ArrayList TopNames = new ArrayList<String>();
        ArrayList TopPrices = new ArrayList<String>();
        TopNames.add("Deep V Neck Sweater");
        TopPrices.add("20.99");
        TopNames.add("Black Blouse");
        TopPrices.add("21.99");
        TopNames.add("White Pink Long Sleeve Turtleneck Sweater");
        TopPrices.add("22.99");
        TopNames.add("Dingaozlz Ruffles Lace Blouse");
        TopPrices.add("25.99");
        TopNames.add("Elegant Embroidery Long Sleeve");
        TopPrices.add("18.99");
        TopNames.add("Korean Fashion - Short Sleeve Pink Lacey Blouse");
        TopPrices.add("40.99");
        TopNames.add("Casual Office Shirt");
        TopPrices.add("30.99");
        TopNames.add("Autumn Fashion Off Shoulder Lace Top");
        TopPrices.add("35.99");
        TopNames.add("Autumn Winter Korwan Kawaii Cute Lace");
        TopPrices.add("12.99");
        TopNames.add("V Neck, Short-Sleeve, Knitted Slim Top");
        TopPrices.add("11.99");

        return new Object[]{TopNames, TopPrices};
    }

    public static ArrayList<ClothingItem> getTops() {
        ArrayList TopList = new ArrayList<ClothingItem>();
        ArrayList TopNames;
        ArrayList TopPrices;
        Object[] Tops = generateTops();
        TopNames = (ArrayList) Tops[0];
        TopPrices = (ArrayList) Tops[1];

        int index = 0;
        for (int i = 1; i < 30; i=i+3)
        {
            String[] images = new String[]{"top_" + String.valueOf(i), "top_" + String.valueOf(i+1), "top_" + String.valueOf(i+2)};
            String name = (String) TopNames.get(index);
            String price = "$" + (String) TopPrices.get(index);
            ClothingItem c =new ClothingItem(images, name, price);
            TopList.add(c);
            index++;
        }
        return TopList;
    }

    //Data for dresses
    public static Object[] generateDresses() {
        ArrayList DressNames = new ArrayList<String>();
        ArrayList DressPrices = new ArrayList<String>();
        DressNames.add("Summer Shirt Style Black Dress");
        DressPrices.add("18.99");
        DressNames.add("Floral Print Vintage Dress");
        DressPrices.add("19.99");
        DressNames.add("Mini Casual Shirt Dress");
        DressPrices.add("10.99");
        DressNames.add("Sweet Lace White Dress");
        DressPrices.add("11.99");
        DressNames.add("Off Shoulder High Waist V neck Casual Dress");
        DressPrices.add("18.99");
        DressNames.add("White Mini Chiffon Dress");
        DressPrices.add("25.99");
        DressNames.add("Summer Beach Polka Dot Dress");
        DressPrices.add("30.99");
        DressNames.add("Summer Beach Casual Slim Dress");
        DressPrices.add("25.99");
        DressNames.add("Korean Autumn Floral Long Sleeve Print Dress");
        DressPrices.add("22.99");
        DressNames.add("Off Shoulder Floral Print Chiffon Dress");
        DressPrices.add("23.99");

        return new Object[]{DressNames, DressPrices};
    }

    public static ArrayList<ClothingItem> getDresses() {
        ArrayList DressList = new ArrayList<ClothingItem>();
        ArrayList DressNames;
        ArrayList DressPrices;
        Object[] Dress = generateDresses();
        DressNames = (ArrayList) Dress[0];
        DressPrices = (ArrayList) Dress[1];
        int index = 0;
        for (int i = 1; i < 30; i=i+3)
        {
            String[] images = new String[]{"dress_" + String.valueOf(i), "dress_" + String.valueOf(i+1), "dress_" + String.valueOf(i+2)};
            String name = (String) DressNames.get(index);
            String price = "$" + (String) DressPrices.get(index);
            ClothingItem c =new ClothingItem(images, name, price);
            DressList.add(c);
            index++;
        }
        return DressList;
    }


}
