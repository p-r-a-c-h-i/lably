package com.xfactor.lably.controllers;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
import java.util.List;


import com.xfactor.lably.entity.Admin;
import com.xfactor.lably.repository.AdminRepository;


import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> admins = new ArrayList<>();


    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/getAdmin")
    public ArrayList<Admin> getAdmin() {
        return admins;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        //admins.add(admin);
        Admin persistedAdmin = adminRepository.save(admin);
        return persistedAdmin;
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAdmins(){
        List<Admin> persistedAdmins = adminRepository.findAll();
        return persistedAdmins;
    }

    @GetMapping("/search")
    public ArrayList<Admin> searchAdmin(@RequestParam String username){

        ArrayList<Admin> ad= new ArrayList<>();
        boolean f = false;

        for(Admin a: admins){
            if(a.getUsername().equals(username)){
                f = true;
                ad.add(a);
            }              
        }
        if(f==true) return ad;
        else return null;
    }

}