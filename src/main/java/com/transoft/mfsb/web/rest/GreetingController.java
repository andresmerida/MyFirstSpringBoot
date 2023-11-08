package com.transoft.mfsb.web.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingController {

    @GetMapping
    public ResponseEntity<String> getGreeting() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Custom Value Header");
        return new ResponseEntity<>("Hello World from Spring Boot", headers, HttpStatus.OK);
    }
}
