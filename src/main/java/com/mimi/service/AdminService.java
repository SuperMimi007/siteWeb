package com.mimi.service;

import com.mimi.repository.AdminRepository;
import com.mimi.exception.AdminNotFoundException;
import com.mimi.modele.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired private AdminRepository repo;

    //---------------------------------------------------//

    public List<Admin> listAll(){
        return (List<Admin>) repo.findAll();
    }

    public String fonctionAdminList(String titleName, Model model, ModelMap modelMap){
        modelMap.put("titleName",titleName);
        model.addAttribute("listAdmins", listAll());
        return "admin/gestionAdmin";
    }

    public String fonctionNewForm(Model model) {
        model.addAttribute("admin", new Admin());
        model.addAttribute("formTitle", "action effectuée avec succès");
        return "admin/adminForm";
    }

    //---------------------------------------------------//

    public void save(Admin admin) {
        repo.save(admin);
    }

    public String fonctionSaveAdmin(Admin admin, RedirectAttributes ra) {
        save(admin);
        ra.addFlashAttribute("message", "action effectuée avec succès");
        return "redirect:/admin/gestionAdmin";
    }

    //---------------------------------------------------//

    public Admin get(Integer  id) throws AdminNotFoundException {
        Optional<Admin> result =repo.findById(id);

        if (result.isPresent()){
            return  result.get();
        }
        throw new AdminNotFoundException("id introuvable"+ id);
    }

    public String fonctionEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            model.addAttribute("admin", get(id));
            model.addAttribute("message", "action effectuée avec succès");
            return  "admin/adminForm";
        } catch (AdminNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/gestionAdmin";
        }
    }

    //---------------------------------------------------//


    public void delete(Integer id) throws AdminNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new AdminNotFoundException("id introuvable" + id);
        }
        repo.deleteById(id);
    }

    public String fonctionDeleteAdmin (@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            delete(id);
            ra.addFlashAttribute("message","action effectuée avec succès");
        } catch (AdminNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/gestionAdmin";
    }

    //---------------------------------------------------//



}
