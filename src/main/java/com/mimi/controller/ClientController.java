package com.mimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ClientController {
    @RequestMapping("/client/pageClient")
    public String gestionClientPage(){
        return"client/pageClient";
    }

    @RequestMapping("/client/login")
    public String ClientLoginPage() {
        return "client/clientLogin";
    }
}
