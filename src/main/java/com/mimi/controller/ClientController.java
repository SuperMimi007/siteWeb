package com.mimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ClientController {
    @RequestMapping("/gestionClient")
    public String gestionClientPage(){
        return"gestionClient";
    }

    @RequestMapping("/clientLogin")
    public String ClientLoginPage() {
        return "clientLogin";
    }
}
