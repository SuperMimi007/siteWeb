package com.mimi.service;

import com.mimi.exception.UserNotFoundException;
import com.mimi.modele.Dog;
import com.mimi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    @Autowired private DogRepository repo;


    //---------------------------------------------------//

    public List<Dog> listDogs(){return (List<Dog>) repo.findAll();
    }

    public String fonctionDogList(String titleName, Model model, ModelMap modelMap){
        modelMap.put("titleName",titleName);
        model.addAttribute("listDogs", listDogs());
        return "admin/gestionDog";
    }


    //----------- SAUVEGARDE CHIEN-----------//

    public void save(Dog dog) {
        repo.save(dog);
    }

    public String fonctionSaveDog(Dog dog, RedirectAttributes ra) {
        System.out.println("entrée sauvegarde  OK");
        save(dog);
        ra.addFlashAttribute("message", "action effectuée avec succès.");
        System.out.println("sortie sauvegarde");
        return "redirect:/admin/gestionDog";
    }

    //---------------------------------------------------//

    public Dog get(Integer  dogId) throws UserNotFoundException {
        Optional<Dog> result =repo.findById(dogId);

        if (result.isPresent()){
            return  result.get();
        }
        throw new UserNotFoundException("id introuvable"+ dogId);
    }

    public String fonctionEditDog(@PathVariable("id") Integer dogId, Model model, RedirectAttributes ra) {
        try {
            model.addAttribute("dog", get(dogId));
            model.addAttribute("formTitle", "Modification d'un compagnon");
            model.addAttribute("message", "action effectuée avec succès.");
            return  "admin/dogForm";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/gestionDog";
        }
    }

    //---------------------------------------------------//


    public void delete(Integer dogId) throws UserNotFoundException {
        Integer count = repo.countByDogId(dogId);
        if (count == null || count == 0) {
            throw new UserNotFoundException("id introuvable" + dogId);
        }
        repo.deleteById(dogId);
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