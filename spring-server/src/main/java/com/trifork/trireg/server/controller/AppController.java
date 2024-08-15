package com.trifork.trireg.server.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AppController {

    @RequestMapping("/")
    public String welcome() {
        return "forward:/index.html";
    }

    @RequestMapping("/app/**")
    public String app() {
        return "forward:/index.html";
    }
}
