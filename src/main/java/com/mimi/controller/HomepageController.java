package com.mimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
    @RequestMapping("/home")
    public String homePage() {
        return "homePage";
    }

    @RequestMapping("/propos")
    public String showProposPage() {
        return "propos";
    }


    @RequestMapping("/conseils")
    public String showConseilsPage() {
        return "conseils";
    }


    @RequestMapping("/cours")
    public String showCoursPage() {
        return "cours";
    }


    @RequestMapping("/balades")
    public String showBaladesPage() {
        return "balades";
    }

    @RequestMapping("/coaching")
    public String showCoachingPage() {
        return "coaching";
    }

}


