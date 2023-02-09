package com.mimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @RequestMapping("/AmourChien93")
    public String homePage() {return "homePage";}

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
