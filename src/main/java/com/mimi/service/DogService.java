package com.mimi.service;


import com.mimi.exception.UserNotFoundException;
import com.mimi.modele.Dog;
import com.mimi.modele.User;
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

    public List<Dog> listDogs(){
        return (List<Dog>) repo.findAll();
    }

    public String fonctionDogList(String titleName, Model model, ModelMap modelMap){
        modelMap.put("titleName",titleName);
        model.addAttribute("listDogs", listDogs());
        return "admin/gestionClient";
    }

    public String fonctionDogForm(Model model) {
        model.addAttribute("dog", new Dog());
        model.addAttribute("formTitle", "Ajout d'un nouveau compagnon");
        return "admin/dogForm";
    }

    //---------------------------------------------------//

    public void save(Dog dog) {
        repo.save(dog);
    }

    public String fonctionSaveDog(Dog dog, RedirectAttributes ra) {
        save(dog);
        ra.addFlashAttribute("message", "action effectuée avec succès.");
        return "redirect:/admin/gestionClient";
    }

    //---------------------------------------------------//

    public Dog get(Integer  id) throws UserNotFoundException {
        Optional<Dog> result =repo.findById(id);

        if (result.isPresent()){
            return  result.get();
        }
        throw new UserNotFoundException("id introuvable"+ id);
    }

    public String fonctionEditDog(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            model.addAttribute("dog", get(id));
            model.addAttribute("formTitle", "Modification d'un compagnon");
            model.addAttribute("message", "action effectuée avec succès.");
            return  "admin/dogForm";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/gestionClient";
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

    public String fonctionDeleteDog (@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            delete(id);
            ra.addFlashAttribute("message","action effectuée avec succès.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/gestionClient";
    }

    //---------------------------------------------------//



}
