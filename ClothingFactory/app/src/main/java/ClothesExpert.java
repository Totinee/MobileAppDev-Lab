package com.example.clothingfactory;

import java.util.ArrayList;
import java.util.List;

public class ClothesExpert {
    List<String> getGender(String gender) {
        List<String > Clothes = new ArrayList<>();
        if (gender.equals("Male")) {
            Clothes.add("Shirt");
            Clothes.add("Jeans Pant");
            Clothes.add("Panjabi");
        }
        else if (gender.equals("Female")) {
            Clothes.add("Saree");
            Clothes.add("Salwar Kameez");
            Clothes.add("Jeans Pant");
        }
        else {
            Clothes.add("Frock");
            Clothes.add("Shirt-Pant Set");
            Clothes.add("Skirt");
        }
        return Clothes;
    }

}
