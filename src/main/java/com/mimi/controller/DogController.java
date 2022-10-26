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
    @Autowired DogService service;

    @RequestMapping("/admin/gestionClient")
    public String gestionClientPage() {
        return "admin/gestionClient";
    }

    @GetMapping("/admin/gestionClient")
    public String dogList(@RequestParam(defaultValue = "Dog") String titleName, Model model, ModelMap modelMap) {
        return service.fonctionDogList(titleName, model, modelMap);
    }

    @GetMapping("/admin/gestionClient/new")
    public String dogForm(Model model) {
        return service.fonctionDogForm(model);
    }

    @PostMapping("/admin/gestionClient/save")
    public String saveDog(Dog dog, RedirectAttributes ra) {
        return service.fonctionSaveDog(dog, ra);
    }

    @GetMapping("/admin/gestionClient/edit/{id}")
    public String editDog(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        return service.fonctionEditDog(id, model, ra);
    }

    @GetMapping("/admin/gestionClient/delete/{id}")
    public String deleteDog(@PathVariable("id") Integer id, RedirectAttributes ra) {
        return service.fonctionDeleteDog(id, ra);
    }

}
