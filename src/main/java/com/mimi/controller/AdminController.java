package com.mimi.controller;
import com.mimi.modele.Admin;
import com.mimi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AdminController {

    @Autowired AdminService  service;


    @RequestMapping("/admin/gestionAdmin")
    public String gestionAdminPage(){
        return"admin/gestionAdmin";
    }


    @GetMapping("/admin/gestionAdmin")
    public String adminList(@RequestParam(defaultValue = "Admin") String titleName, Model model, ModelMap modelMap) {
        return service.fonctionAdminList(titleName, model, modelMap);
    }

    @GetMapping("/admin/gestionAdmin/new")
    public String newForm(Model model) {
       return service.fonctionNewForm(model);
    }

    @PostMapping("/admin/gestionAdmin/save")
    public String saveAdmin(Admin admin, RedirectAttributes ra) {
        return service.fonctionSaveAdmin(admin,ra);
    }

    @GetMapping("/admin/gestionAdmin/edit/{id}")
    public String EditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        return service.fonctionEditForm(id,model,ra);
    }

    @GetMapping("/admin/gestionAdmin/delete/{id}")
    public String deleteAdmin (@PathVariable("id") Integer id, RedirectAttributes ra) {
        return service.fonctionDeleteAdmin(id,ra);
    }

    @RequestMapping("/admin/login")
    public String AdminLoginPage() {
        return "admin/adminLogin";
    }

}
