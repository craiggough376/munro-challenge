package com.example.munrochallenge.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Munro {

    private String name;
    private String category;
    private Double height;
    private String gridReference;

    public Munro(String name, String category, Double height, String gridReference) {
        this.name = name;
        this.category = category;
        this.height = height;
        this.gridReference = gridReference;
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

    public String getGridReference() {
        return gridReference;
    }

    public void setGridReference(String gridReference) {
        this.gridReference = gridReference;
    }

    public static List<Munro> createMunroList(ArrayList<String> data){
        List<Munro> munros = new ArrayList<>();
        for(String row : data) {
            String[] rowList = row.split(",", -1);
            if(!rowList[0].isEmpty() && !rowList[25].isEmpty()){
                 String name = rowList[6];
                 String category = rowList[25];
                 Double height = Double.parseDouble(rowList[10]);
                 String gridReference = rowList[14];
                 Munro munro = new Munro(name, category, height, gridReference);
                 munros.add(munro);
            }
        }
        return munros;

    }

    public static List<Munro> sortByName(List<Munro> munros, Boolean ascending){

        Collections.sort(munros, new Comparator<Munro>() {
            @Override
            public int compare(Munro munro1, Munro munro2) {
                if(ascending) {
                    return munro1.getName().compareToIgnoreCase(munro2.getName());
                }else{
                    return munro2.getName().compareToIgnoreCase(munro1.getName());
                }
            }
        });
        return munros;
    }

}
