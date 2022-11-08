package com.mimi.controller;

import com.mimi.modele.Dog;
import com.mimi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DogController {
    @Autowired DogService Dogservice;


    //----------- ENDPOINT CHIEN  LIST + PAGE GESTION CHIEN -----------//

    @GetMapping("/admin/gestionDog")
    public String dogList(@RequestParam(defaultValue = "Dog") String titleName, Model model, ModelMap modelMap) {
        return Dogservice.fonctionDogList(titleName, model, modelMap);
    }

    //----------- ENDPOINT FORMULAIRE CHIEN -----------//
    @GetMapping("/admin/gestionDog/new")
    public String dogForm(Model model) {
        return Dogservice.fonctionDogForm(model);
    }

    //----------- ENDPOINT SAUVEGARDE CHIEN -----------//

    @PostMapping("/admin/gestionDog/save")
    public String saveDog(Dog dog, RedirectAttributes ra) {
        return Dogservice.fonctionSaveDog(dog, ra);
    }

    //----------- ENDPOINT UPDATE CHIEN -----------//

    @GetMapping("/admin/gestionDog/edit/{dogId}")
    public String editDog(@PathVariable("dogId") Integer dogId, Model model, RedirectAttributes ra) {
        return Dogservice.fonctionEditDog(dogId, model, ra);
    }

    //----------- ENDPOINT DELETE CHIEN -----------//

    @GetMapping("/admin/gestionDog/delete/{dogId}")
    public String deleteDog(@PathVariable("dogId") Integer dogId, RedirectAttributes ra) {
        return Dogservice.fonctionDeleteDog(dogId, ra);
    }

}