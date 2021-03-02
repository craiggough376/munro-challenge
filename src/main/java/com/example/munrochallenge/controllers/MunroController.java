package com.example.munrochallenge.controllers;

import com.example.munrochallenge.FileReader;
import com.example.munrochallenge.Munro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MunroController {




    @GetMapping("/munros")
    public ResponseEntity<List<Munro>> getAllMunros(){
        FileReader fileReader = new FileReader();
        ArrayList<HashMap> data = fileReader.readCSV("src/main/resources/data/munrotab_v6.2.csv");
        List<Munro> munros = Munro.createMunroList(data);
        return new ResponseEntity<>(munros, HttpStatus.OK);
    }



}
