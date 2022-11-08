package com.mimi.service;


import com.mimi.modele.User;
import com.mimi.repository.UserRepository;
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
    @Autowired private UserRepository repo;


    //----------- LISTE USERS + RECHERCHE -----------//



    public String fonctionUserList(String titleName, Model model, ModelMap modelMap,String keyword) {
        modelMap.put("titleName", titleName);
        List<User> listUsers = repo.findAll();
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("findByKeyword",keyword);
        return "admin/gestionUser";
    }


    public List<User> findByKeyword(String keyword) {
        if (keyword != null){
            return repo.findByKeyword(keyword);
        }
        return repo.findAll();
    }


    //----------- FORMULAIRE USER-----------//
    public String fonctionUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("formTitle", "Ajout d'un nouvel user");
        return "admin/userForm";
    }



    //----------- SAUVEGARDE-----------//

    public void save(User user) {
        repo.save(user);
    }

    public String fonctionSaveUser(User user, RedirectAttributes ra) {
        save(user);
        ra.addFlashAttribute("message", "action effectuée avec succès.");
        return "redirect:/admin/gestionUser";
    }

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

    //----------- DELETE-----------//


    public void delete(Integer userId) throws UserNotFoundException {
        Integer count = repo.countByUserId(userId);
        if (count == null || count == 0) {
            throw new UserNotFoundException("id introuvable" + userId);
        }
        repo.deleteById(userId);
    }

    public String fonctionDeleteUser (@PathVariable("userId") Integer userId, RedirectAttributes ra) {
        try {
            delete(userId);
            ra.addFlashAttribute("message","action effectuée avec succès.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/gestionUser";
    }

}