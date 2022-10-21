package com.mimi.service;

import com.mimi.modele.User;
import com.mimi.repository.AdminRepository;
import com.mimi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private AdminRepository repo;

    //---------------------------------------------------//

    public List<User> listUsers(){
        return (List<User>) repo.findAll();
    }

    public String fonctionUserList(String titleName, Model model, ModelMap modelMap){
        modelMap.put("titleName",titleName);
        model.addAttribute("listUsers", listUsers());
        return "admin/gestionUser";
    }

    public String fonctionNewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("formTitle", "Ajout d'un nouvel user");
        return "admin/userForm";
    }

    //---------------------------------------------------//

    public void save(User user) {
        repo.save(user);
    }

    public String fonctionSaveUser(User user, RedirectAttributes ra) {
        save(user);
        ra.addFlashAttribute("message", "action effectuée avec succès.");
        return "redirect:/admin/gestionUser";
    }

    //---------------------------------------------------//

    public User get(Integer  id) throws UserNotFoundException {
        Optional<User> result =repo.findById(id);

        if (result.isPresent()){
            return  result.get();
        }
        throw new UserNotFoundException("id introuvable"+ id);
    }

    public String fonctionEditUser(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            model.addAttribute("user", get(id));
            model.addAttribute("formTitle", "Modification d'un user");
            model.addAttribute("message", "action effectuée avec succès.");
            return  "admin/userForm";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/gestionUser";
        }
    }

    //---------------------------------------------------//


    public void delete(Integer id) throws UserNotFoundException {
        Integer count = repo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("id introuvable" + id);
        }
        repo.deleteById(id);
    }

  public String fonctionDeleteUser (@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            delete(id);
            ra.addFlashAttribute("message","action effectuée avec succès.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/gestionUser";
    }

    //---------------------------------------------------//



}
