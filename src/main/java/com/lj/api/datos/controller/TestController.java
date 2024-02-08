package com.lj.api.datos.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String getAll(){
        return "all";
    }

    @PostMapping
    public String create(@RequestBody String test){
        return test;
    }
}
