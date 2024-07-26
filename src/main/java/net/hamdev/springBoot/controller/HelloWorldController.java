package net.hamdev.springBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // Http Get request
    // http://localhost:8080/hello-world

    @GetMapping("/hello-world")


    public String helloWord(){
        return "Hello world!";
    }
}
