package com.mimi.controller;


import com.mimi.exception.UserNotFoundException;
import com.mimi.modele.User;
import com.mimi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
    @Autowired
    private UserService service;


    //----------- ENDPOINT CONNEXION -----------//

    @GetMapping("/admin/login")
    public String UserLoginPage() {
        return "admin/adminLogin";
    }

    @GetMapping("/client/login")
    public String ClientLoginPage() {
        return "client/clientLogin";
    }



    //----------- ENDPOINT USER  LIST + PAGE GESTION USER -----------//


    @GetMapping("/admin/gestionUser")
    public String userList(@Param("keyword") String keyword, String titleName, Model model, ModelMap modelMap) {
        return service.fonctionUserList(titleName, model, modelMap, keyword);
    }


    //----------- ENDPOINT FORMULAIRE  USER -----------//
    @GetMapping("/admin/gestionUser/new")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("formTitle", "Ajout d'un nouvel user");
        return "admin/userForm";
    }

    //----------- ENDPOINT SAVE USER -----------//


    @PostMapping("/admin/gestionUser/save")
    public String saveUser(User user, Model model, RedirectAttributes ra) {
        model.addAttribute("user", service.saveUser(user));
        ra.addFlashAttribute("message", "action effectuée avec succès.");
        return "redirect:/admin/gestionUser";
    }

    //----------- ENDPOINT UPDATE USER -----------//

    @GetMapping("/admin/gestionUser/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            model.addAttribute("user", service.getUser(id));
            model.addAttribute("formTitle", "Modification d'un user");
            model.addAttribute("message", "action effectuée avec succès.");
            return "admin/userForm";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/gestionUser";
        }
    }

    //----------- ENDPOINT DELETE USER -----------//

    @GetMapping("/admin/gestionUser/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.deleteUser(id);
            ra.addFlashAttribute("message", "action effectuée avec succès.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/gestionUser";
    }


}

