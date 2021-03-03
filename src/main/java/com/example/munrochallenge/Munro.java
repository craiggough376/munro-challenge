package com.example.munrochallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Munro {

    private String name;
    private String category;
    private Double height;

    public Munro(String name, String category, Double height) {
        this.name = name;
        this.category = category;
        this.height = height;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public static List<Munro> createMunroList(ArrayList<String> data){
        List<Munro> munros = new ArrayList<>();
        String name = "";
        String category = "";
        Double height = 0.0;
        for(String row : data) {
            String[] rowList = row.split(",", -1);
            if(!rowList[0].isEmpty()){
                 name = rowList[6];
                 category = rowList[25];
                 height = Double.parseDouble(rowList[10]);
            }
            Munro munro = new Munro(name, category, height);
            munros.add(munro);
        }
        return munros;

    }

}
