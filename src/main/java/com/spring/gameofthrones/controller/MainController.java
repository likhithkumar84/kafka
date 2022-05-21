package com.spring.gameofthrones.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("gameOfThrones")
    public String hello() {
        return "Welcome to Game of Thrones";
    }

}
