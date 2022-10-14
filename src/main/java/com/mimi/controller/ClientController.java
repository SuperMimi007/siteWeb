package com.mimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class ClientController {
    @RequestMapping("/gestionClient")
    public String gestionClientPage(){
        return"gestionClient";
    }

    @RequestMapping("/client/login")
    public String ClientLoginPage() {
        return "client/clientLogin";
    }
}
