package com.mimi.controller;

import com.mimi.modele.Report;

import com.mimi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;


@Controller
public class ReportController {

    private final String UPLOAD_DIR = "./uploads/";

    @Autowired
    private ReportService reportService;

   @GetMapping("/admin/gestionReport")
    public String reportList(@RequestParam(defaultValue = "report") String titleName, Model model, ModelMap modelMap) {
        return reportService.fonctionReportList(titleName, model, modelMap);
    }

    @GetMapping("/admin/gestionReport/new")
    public String getData() {
        return "reportForm";
    }

    @PostMapping("/reportUpload")
    public String uploadReport(@RequestParam("report") MultipartFile report, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Téléchargé avec succès " + report.getOriginalFilename() + "!");
        if (report.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Merci de sélectionner un fichier.");
            return "redirect:/admin/reportForm";
        }
        String reportName = StringUtils.cleanPath(Objects.requireNonNull(report.getOriginalFilename()));
        try {
            Path path = Paths.get(UPLOAD_DIR + reportName);
            Files.copy(report.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "Fichier télécharger avec succès " + reportName + '!');
        return "redirect:/admin/gestionReport";
    }


}


