package com.example.demo.controller;

import com.example.demo.dto.Dto;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class DemoController {


    @Autowired
    DemoService service;


    @RequestMapping(value = "test/{str1}/{str2}")
    public String hello(@PathVariable String str1,@PathVariable String str2){

        return service.testService(str1,str2);
    }

    @RequestMapping(value = "size/{str1}/{str2}/{str3}")
    public int getSize(@PathVariable String str1,@PathVariable String str2,@PathVariable String str3){

        return service.length(str1,str2,str3);
    }

    @GetMapping
    @RequestMapping(value = "/get")
    public String getMessage(){

        return "My Sample App Success - Trigger 2!!";
    }


    @PostMapping
    @RequestMapping(value = "print")
    public HashMap printInput(@RequestBody Dto dto){
       return service.print(dto);

    }

    @RequestMapping(value = "api")
    public HashMap invokeAPI(){
        return service.invokeAPI();
    }
}
