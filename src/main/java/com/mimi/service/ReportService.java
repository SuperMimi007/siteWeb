package com.mimi.service;

import com.mimi.modele.Dog;
import com.mimi.modele.Report;
import com.mimi.modele.User;
import com.mimi.repository.DogRepository;
import com.mimi.repository.ReportRepository;
import com.mimi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private UserRepository userRepository;

    //----------- LISTE USERS + RECHERCHE/FILTRE -----------//
    public List<Report> listAll(String keyword) {
        if (keyword != null) {
            return reportRepository.findAll(keyword);
        }
        return reportRepository.findAll();
    }

    public String fonctionReportList(String titleName, Model model, ModelMap modelMap, @Param("keyword") String keyword) {
        List<Report> listReports = listAll(keyword);
        model.addAttribute("listReports", listReports);
        model.addAttribute("keyword", keyword);
        modelMap.put("titleName", titleName);
        return "admin/gestionReport";
    }

    public String fonctionReportForm(Model model) {
/*        List<User> usersName = userRepository.findAll();
        model.addAttribute("usersName",usersName);*/
        model.addAttribute("report", new Report());
        List<Dog> dogsName = dogRepository.findAll();
        model.addAttribute("dogsName",dogsName);
        model.addAttribute("formTitle", "Ajout d'un nouvel compte rendu");
        return "admin/reportForm";
    }

    public String fonctionUploadReport(@RequestParam("report") MultipartFile multipartFile, RedirectAttributes ra) throws IOException {
        String reportName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Report report = new Report();
        report.setReportName(reportName);
        report.setContent(multipartFile.getBytes());
        report.setSize(multipartFile.getSize());
        reportRepository.save(report);
        ra.addFlashAttribute("message", "Fichier télécharger avec succès " + reportName + '!');
        return "redirect:/admin/gestionReport";
    }

    public String fonctionDownloadReport(@Param("reportId") Integer reportId, HttpServletResponse response) throws Exception {
        Optional<Report> result = reportRepository.findById(reportId);
        if (!result.isPresent()) {
            throw new Exception("Document introuvable avec l'id " + reportId);
        }
        Report report = result.get();
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment reportName=" + report.getReportName();
        response.setHeader(headerKey, headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(report.getContent());
        outputStream.close();
        return "redirect:/admin/gestionReport";
    }

}