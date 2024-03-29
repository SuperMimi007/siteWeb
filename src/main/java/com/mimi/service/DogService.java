package com.mimi.service;

import com.mimi.exception.UserNotFoundException;
import com.mimi.modele.Dog;
import com.mimi.modele.User;
import com.mimi.repository.DogRepository;
import com.mimi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    @Autowired private DogRepository dogRepo;
    @Autowired private UserRepository userRepo;


    //----------- LISTE USERS + RECHERCHE/FILTRE -----------//

    public List<Dog> listAll(String keyword){
        if(keyword != null){
            return dogRepo.findAll(keyword);
        }
        return dogRepo.findAll();
    }
        public String fonctionDogList(String titleName, Model model, ModelMap modelMap,@Param("keyword") String keyword){
        List<Dog> listDogs=listAll(keyword);
        modelMap.put("titleName",titleName);
        model.addAttribute("listDogs", listDogs);
        model.addAttribute("keyword",keyword);
        return "admin/gestionDog";
    }

    //----------- FORMULAIRE----------//


    public String fonctionDogForm(Model model) {
            List<User> usersName = userRepo.findAll();
            model.addAttribute("dog", new Dog());
            model.addAttribute("usersName",usersName);
            model.addAttribute("formTitle", "Ajout d'un nouveau compagnon");
        return "admin/dogForm";
    }

    //----------- SAVE-----------//

        public String fonctionSaveDog(Dog dog, RedirectAttributes ra) {
        dogRepo.save(dog);
        ra.addFlashAttribute("message", "action effectuée avec succès.");
        return "redirect:/admin/gestionDog";
    }

    //----------- EDIT-----------//

    public Dog get(Integer dogId) throws UserNotFoundException {
        Optional<Dog> result =dogRepo.findById(dogId);

        if (result.isPresent()){
            return  result.get();
        }
        throw new UserNotFoundException("id introuvable"+ dogId);
    }

    public String fonctionEditDog(@PathVariable("dogId") Integer dogId, Model model, RedirectAttributes ra) {
        try {
            List<User> usersName = userRepo.findAll();
            model.addAttribute("usersName",usersName);
            model.addAttribute("dog", get(dogId));
            model.addAttribute("formTitle", "Modification d'un compagnon");
            model.addAttribute("message", "action effectuée avec succès.");
            return  "admin/dogForm";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/gestionDog";
        }
    }

    //----------- DELETE-----------//


    public void delete(Integer dogId) throws UserNotFoundException {
        Integer count = dogRepo.countByDogId(dogId);
        if (count == null || count == 0) {
            throw new UserNotFoundException("id introuvable" + dogId);
        }
        dogRepo.deleteById(dogId);
    }

    public String fonctionDeleteDog (@PathVariable("dogId") Integer dogId, RedirectAttributes ra) {
        try {
            delete(dogId);
            ra.addFlashAttribute("message","action effectuée avec succès.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/gestionDog";
    }

    //---------------------------------------------------//



}