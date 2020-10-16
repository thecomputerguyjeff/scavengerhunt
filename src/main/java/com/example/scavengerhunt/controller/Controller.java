package com.example.scavengerhunt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class Controller {

    @GetMapping("/start")
    public String start() {
        return "Hey, you are early. Try again later";
    }
}
