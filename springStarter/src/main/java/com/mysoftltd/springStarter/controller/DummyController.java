package com.mysoftltd.springStarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RunWith(MockitoJUnitRunner.class)
public class DummyController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }
}