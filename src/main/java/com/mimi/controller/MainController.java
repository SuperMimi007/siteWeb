package com.mimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String homePage() {
        return "homePage";
    }

    @RequestMapping("/propos")
    public String ProposPage() {
        return "propos";
    }

    @RequestMapping("/conseils")
    public String ConseilsPage() {
        return "conseils";
    }

    @RequestMapping("/cours")
    public String CoursPage() {
        return "cours";
    }

    @RequestMapping("/balades")
    public String BaladesPage() {
        return "balades";
    }

    @RequestMapping("/coaching")
    public String CoachingPage() {
        return "coaching";
    }




}
