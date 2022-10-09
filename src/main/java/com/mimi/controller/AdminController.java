package com.mimi.controller;
import com.mimi.service.Admin;
import com.mimi.service.AdminNotFoundException;
import com.mimi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService service;

    @RequestMapping("/gestionAdmin")
    public String showgestionAdminPage(){
        return"gestionAdmin";
    }

    @GetMapping("/gestionAdmin")
    public String showAdminList(@RequestParam(defaultValue = "Admin") String titleName, Model model, ModelMap modelMap) {
        modelMap.put("titleName",titleName);
        List<Admin> listAdmins = service.listAll();
        model.addAttribute("listAdmins", listAdmins);
        return "gestionAdmin";
    }

    @GetMapping("/gestionAdmin/new")
    public String showNewForm(Model model) {
        model.addAttribute("admin", new Admin());
        model.addAttribute("pageTitle", "Ajout d'un nouvel admin");
        return "admin_form";
    }

    @PostMapping("/gestionAdmin/save")
    public String saveAdmin(Admin admin, RedirectAttributes ra) {
        service.save(admin);
        ra.addFlashAttribute("message", "Admin ajouté avec succès");
        return "redirect:/gestionAdmin";
    }

    @GetMapping("/gestionAdmin/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Admin admin = service.get(id);
            model.addAttribute("admin", admin);
            model.addAttribute("pageTitle", "Admin modifié avec succès");
            return  "admin_form";
        } catch (AdminNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/gestionAdmin";
        }
    }

    @GetMapping("/gestionAdmin/delete/{id}")
    public String deleteAdmin (@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message","Admin"+"supprimé avec succès");
        } catch (AdminNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/gestionAdmin";
    }
}
