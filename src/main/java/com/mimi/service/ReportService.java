package com.mimi.service;

import com.mimi.modele.Report;
import com.mimi.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepo;

    public String fonctionReportList(String titleName, Model model, ModelMap modelMap){
        List<Report> listReports = reportRepo.findAll();
        model.addAttribute("listReports", listReports);
        modelMap.put("titleName", titleName);
        return "admin/gestionReport";
    }
}