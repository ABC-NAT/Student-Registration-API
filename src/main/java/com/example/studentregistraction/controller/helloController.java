package com.example.studentregistraction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
public class helloController {

    @GetMapping
    public String home() {
        return "hello world";
    } 

}
