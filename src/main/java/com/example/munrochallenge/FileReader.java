package com.example.munrochallenge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileReader {

    public static ArrayList<String> readCSV(String location){

        ArrayList<String> dataList = new ArrayList<>();


    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(location),"utf-8"))){
        br.readLine();
        String trackingLine = br.readLine();

            while(trackingLine != null){
                dataList.add(trackingLine);
                trackingLine = br.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return dataList;
    }


}

