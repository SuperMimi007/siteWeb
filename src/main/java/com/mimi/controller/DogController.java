package com.mimi.controller;

import com.mimi.exception.UserNotFoundException;
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
    @Autowired DogService service;

    //----------- ENDPOINT CHIEN  LIST + PAGE GESTION CHIEN -----------//

    @GetMapping("/admin/gestionDog")
    public String dogList(@RequestParam(defaultValue = "Dog") String titleName, Model model, ModelMap modelMap) {
        return service.fonctionDogList(titleName, model, modelMap);
    }



    @PostMapping("/admin/gestionDog/save")
    public String saveDog(Dog dog, RedirectAttributes ra) {
        System.out.println("sauvegardeChien");
        return service.fonctionSaveDog(dog, ra);
    }

    @GetMapping("/admin/gestionDog/edit/{id}")
    public String editDog(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        return service.fonctionEditDog(id, model, ra);
    }

    @GetMapping("/admin/gestionDog/delete/{id}")
    public String deleteDog(@PathVariable("id") Integer id, RedirectAttributes ra) {
        return service.fonctionDeleteDog(id, ra);
    }

}