package com.example.munrochallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Munro {

    private String name;
    private String category;

    public Munro(String name, String category) {
        this.name = name;
        this.category = category;
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



    public static List<Munro> createMunroList(ArrayList<HashMap> data){
        List<Munro> munros = new ArrayList<>();
        for(HashMap<String, String> row : data){
            String name = row.get("Name");
            String category = row.get("Post 1997");
           Munro munro = new Munro(name, category);
            munros.add(munro);
        }
        return munros;

    }

}
