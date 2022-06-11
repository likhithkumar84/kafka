package com.spring.gameofthrones.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main Controller
 */
@RestController
public class MainController {

    @GetMapping("gameOfThrones")
    public ResponseEntity<String> gameOfThrones(){

        return ResponseEntity.ok("Welcome to Game of Thrones");
    }
}
