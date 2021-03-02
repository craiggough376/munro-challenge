package com.example.munrochallenge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileReader {

    public ArrayList<HashMap> readCSV(String location){
        Path pathToCSVFIle = Paths.get(location);

        ArrayList<HashMap> dataList = new ArrayList<>();


//        try (BufferedReader br = Files.newBufferedReader(pathToCSVFIle, StandardCharsets.ISO_8859_1)){
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(location),"utf-8"))){

        String headingsLine = br.readLine();
            String[] keys = headingsLine.split(",");

            String trackingLine = br.readLine();


            while(trackingLine != null){

                HashMap<String, String> data = new HashMap<>();

                String[] values = trackingLine.split(",", -1);
                for(int i = 0; i < keys.length; i++){
                    data.put(keys[i], values[i]);
                }
                dataList.add(data);
                trackingLine = br.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return dataList;
    }


}

