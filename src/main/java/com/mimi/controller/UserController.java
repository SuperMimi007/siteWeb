package com.mimi.controller;

import com.mimi.modele.User;
import com.mimi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    UserService service;



    @RequestMapping("/admin/gestionUser")
    public String gestionUserPage() {
        return "admin/gestionUser";
    }


    @GetMapping("/admin/gestionUser")
    public String userList(@RequestParam(defaultValue = "User") String titleName, Model model, ModelMap modelMap) {
        return service.fonctionUserList(titleName, model, modelMap);
    }

    @GetMapping("/admin/gestionUser/new")
    public String newForm(Model model) {
        return service.fonctionNewForm(model);
    }

    @PostMapping("/admin/gestionUser/save")
    public String saveUser(User user, RedirectAttributes ra) {
        return service.fonctionSaveUser(user, ra);
    }

    @GetMapping("/admin/gestionUser/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        return service.fonctionEditUser(id, model, ra);
    }

   @GetMapping("/admin/gestionUser/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        return service.fonctionDeleteUser(id, ra);
    }

    @RequestMapping("/admin/login")
    public String UserLoginPage() {
        return "admin/adminLogin";
    }


    @RequestMapping("/admin/gestionClient")
    public String gestionClientPage() {
        return "admin/gestionClient";
    }

}