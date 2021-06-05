package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.List;


import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.repository.LabRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/lab")
public class LabController {

    ArrayList<Lab> labs = new ArrayList<>();

    @Autowired
    LabRepository labRepository;

    @GetMapping("/getLab")
    public ArrayList<Lab> getLab() {
        return labs;
    }

    @PostMapping("/addLab")
    public Lab addLab(@RequestBody Lab lab) {

        Lab persistedLab = labRepository.save(lab);
        return persistedLab;
    }

    @GetMapping("/getAllLabs")
    public List<Lab> getLabs(){
        List<Lab> persistedLabs = labRepository.findAll();
        return persistedLabs;
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