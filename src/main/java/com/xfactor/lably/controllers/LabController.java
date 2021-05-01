package com.xfactor.lably.controllers;

import java.util.ArrayList;


import com.xfactor.lably.entity.Lab;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lab")
public class LabController {

    ArrayList<Lab> labs = new ArrayList<>();

    @GetMapping("/getLab")
    public ArrayList<Lab> getAdmin() {
        return labs;
    }

    @PostMapping("/addLab")
    public Lab addLab(@RequestBody Lab lab) {

        labs.add(lab);
        return lab;
    }

    @GetMapping("/search")
    public ArrayList<Lab> searchAdmin(@RequestParam String name){

        ArrayList<Lab> ad = new ArrayList<>();
        boolean f = false;

        for(Lab a: labs){
            if(a.getName().equals(name)){
                f = true;
                ad.add(a);
            }              
        }
        if(f==true) return ad;
        else return null;
    }

}