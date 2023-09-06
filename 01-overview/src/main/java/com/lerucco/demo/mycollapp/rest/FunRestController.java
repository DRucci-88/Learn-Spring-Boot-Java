package com.lerucco.demo.mycollapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FunRestController {

    @Value("${couch.name}")
    private String couchName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/team-info")
    public String teamInfo() {
        return "Couch :" + couchName + ", Team Name : " + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/workout")
    public String workout() {
        return "Run 1000 km";
    }

    @GetMapping("/fortune")
    public String fortune() {
        return "Get a cookies";
    }
}