package com.mimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @RequestMapping("/AmourChien93")
    public String homePage() {
        return "homePage";}

    @RequestMapping("/page/propos")
    public String ProposPage() {
        return "/page/propos";
    }

    @RequestMapping("/page/conseils")
    public String ConseilsPage() {
        return "page/conseils";
    }

    @RequestMapping("/page/cours")
    public String CoursPage() {
        return "page/cours";
    }

    @RequestMapping("/page/balades")
    public String BaladesPage() {
        return "page/balades";
    }

    @RequestMapping("/page/coaching")
    public String CoachingPage() {
        return "page/coaching";
    }




}
