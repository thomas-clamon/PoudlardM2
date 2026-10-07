package com.example.poudlarm10710.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("test")
public class TestController {

    @GetMapping("hello")
    public String hello (){
        return "ça marche";
    }
}
