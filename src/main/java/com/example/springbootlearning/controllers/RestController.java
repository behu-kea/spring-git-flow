package com.example.springbootlearning.controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("welcome")
    public String welcome() {
        return "Velkommen til 2. semester";
    }

    @GetMapping("number")
    public int number() {
        return 2;
    }
}
