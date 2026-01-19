package com.eazybytes.accounts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class hellowrld {

    @ResponseBody
    @GetMapping("/start")
    public String helloworld(){
        return "hellowworld.html";
    }

}
