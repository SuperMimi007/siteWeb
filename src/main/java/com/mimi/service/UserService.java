package com.mimi.service;

import com.mimi.config.LoginUserDetails;
import com.mimi.modele.User;
import com.mimi.repository.UserRepository;
import com.mimi.exception.UserNotFoundException;
import com.mimi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }



    //----------- LISTE USERS + RECHERCHE -----------//


    public List<User> listAll(String keyword){
        if(keyword != null){
            return userRepository.findAll(keyword);
        }
        return userRepository.findAll();
    }

   public String fonctionUserList(String titleName, Model model, ModelMap modelMap,@Param("keyword") String keyword) {
        List<User> listUsers = listAll(keyword);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("keyword",keyword);
        modelMap.put("titleName", titleName);
        return "admin/gestionUser";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

 /*   public String fonctionUserList(String titleName, Model model, ModelMap modelMap){
        model.addAttribute("listUsers", getAllUsers());
        modelMap.put("titleName", titleName);
        return "admin/gestionUser";
    }*/


    //----------- FORMULAIRE USER-----------//
    public String fonctionUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("formTitle", "Ajout d'un nouvel user");
        return "admin/userForm";
    }



    //----------- SAUVEGARDE-----------//



    public User saveUser(User user){


        return userRepository.save(user);
    }

    public String fonctionSaveUser(User user,Model model,  RedirectAttributes ra) {
        model.addAttribute("user", saveUser(user));
        ra.addFlashAttribute("message", "action effectuée avec succès.");
        return "redirect:/admin/gestionUser";
    }



    public User get(Integer  id) throws UserNotFoundException {
        Optional<User> getUser =userRepository.findById(id);

        if (getUser.isPresent()){
            return  getUser.get();
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
        Integer count = userRepository.countByUserId(userId);
        if (count == null || count == 0) {
            throw new UserNotFoundException("id introuvable" + userId);
        }
        userRepository.deleteById(userId);
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