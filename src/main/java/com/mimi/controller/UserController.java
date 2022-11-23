package com.mimi.controller;

import com.mimi.config.LoginUserDetails;
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
    @Autowired private UserService service;



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
    public String userList(@Param("keyword") String keyword,String titleName, Model model, ModelMap modelMap) {
        return service.fonctionUserList(titleName, model, modelMap,keyword);
    }

    //----------- ENDPOINT FORMULAIRE  USER -----------//
    @GetMapping("/admin/gestionUser/new")
    public String userForm(Model model) {
        return service.fonctionUserForm(model);
    }

    //----------- ENDPOINT UPDATE USER -----------//
    @PostMapping("/admin/gestionUser/save")
    public String saveUser(User user, Model model,RedirectAttributes ra) {
        return service.fonctionSaveUser(user, model,ra);
    }

    @GetMapping("/admin/gestionUser/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        return service.fonctionEditUser(id, model, ra);
    }

    //----------- ENDPOINT DELETE USER -----------//

    @GetMapping("/admin/gestionUser/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        return service.fonctionDeleteUser(id, ra);
    }
}