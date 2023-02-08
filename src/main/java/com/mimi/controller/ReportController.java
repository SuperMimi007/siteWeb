package com.mimi.controller;

import com.mimi.modele.Report;

import com.mimi.repository.ReportRepository;
import com.mimi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Controller
public class ReportController {

//    private final String UPLOAD_DIR = "./uploads/";

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/admin/gestionReport")
    public String reportList(@Param("keyword") String keyword, String titleName, Model model, ModelMap modelMap) {
        return reportService.fonctionReportList(titleName, model, modelMap,keyword);
    }


    @GetMapping("/admin/gestionReport/new")
    public String repotForm(Model model) {
        return reportService.fonctionReportForm(model);
    }
    //public String getData() {return "reportForm";}

    @PostMapping("/admin/gestionReport/reportUpload")
    public String uploadReport(@RequestParam("report") MultipartFile multipartFile, RedirectAttributes ra) throws IOException {
        return reportService.fonctionUploadReport(multipartFile,ra);
    }

    @GetMapping("/reportDownload")
    public String downloadReport(@Param("reportId") Integer reportId, HttpServletResponse response) throws Exception {
        return reportService.fonctionDownloadReport(reportId,response);
    }


}


