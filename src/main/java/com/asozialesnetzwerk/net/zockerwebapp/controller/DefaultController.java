package com.asozialesnetzwerk.net.zockerwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String greeting() {
        return "Greetings from Spring Boot!";
    }
}
