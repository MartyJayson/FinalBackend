package com.example.MidtermJavaFramework.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value ="/")
@CrossOrigin(origins = "http://localhost:3000")
class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
