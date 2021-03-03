package com.example.munrochallenge.controllers;

import com.example.munrochallenge.helpers.FileReader;
import com.example.munrochallenge.models.Munro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class MunroController {


    @GetMapping("/munros")
    public ResponseEntity<List<Munro>> getAllMunros(@RequestParam(required = false) String category){
        FileReader fileReader = new FileReader();
        ArrayList<String> data = fileReader.readCSV("src/main/resources/data/munrotab_v6.2.csv");
        List<Munro> munros = Munro.createMunroList(data);
        Munro.sortByName(munros, false);
        return new ResponseEntity<>(munros, HttpStatus.OK);
    }



}
