package org.example.hospitalmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testing {

    @GetMapping("/test")
    public String testReturn(){
        return "hello world";
    }
}
