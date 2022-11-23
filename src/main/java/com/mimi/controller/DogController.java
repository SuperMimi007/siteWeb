package com.mimi.controller;

import com.mimi.modele.Dog;
import com.mimi.repository.DogRepository;
import com.mimi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class DogController {
    @Autowired DogService dogService;
    @Autowired DogRepository dogRepo;


    //----------- ENDPOINT CHIEN  LIST + PAGE GESTION CHIEN -----------//

    @GetMapping("/admin/gestionDog")
    public String dogList(@Param("keyword") String keyword,String titleName, Model model, ModelMap modelMap) {
        return dogService.fonctionDogList(titleName, model, modelMap,keyword);
    }

    //----------- ENDPOINT FORMULAIRE CHIEN -----------//
    @GetMapping("/admin/gestionDog/new")
    public String dogForm(Model model) {
        return dogService.fonctionDogForm(model);
    }

    //----------- ENDPOINT SAUVEGARDE CHIEN -----------//

    @PostMapping("/admin/gestionDog/save")
    public String saveDog(Dog dog, RedirectAttributes ra) {
        return dogService.fonctionSaveDog(dog, ra);
    }

    //----------- ENDPOINT UPDATE CHIEN -----------//

    @GetMapping("/admin/gestionDog/edit/{dogId}")
    public String editDog(@PathVariable("dogId") Integer dogId, Model model, RedirectAttributes ra) {
        return dogService.fonctionEditDog(dogId, model, ra);
    }

    //----------- ENDPOINT DELETE CHIEN -----------//

    @GetMapping("/admin/gestionDog/delete/{dogId}")
    public String deleteDog(@PathVariable("dogId") Integer dogId, RedirectAttributes ra) {
        return dogService.fonctionDeleteDog(dogId, ra);
    }

}