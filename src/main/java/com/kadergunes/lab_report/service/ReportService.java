package com.kadergunes.lab_report.service;

import com.kadergunes.lab_report.model.Report;
import com.kadergunes.lab_report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    public List<Report> getAllReport() {
        List<Report> reports = this.reportRepository.findAll();
        return reports;
    }
    public Report saveOneReport(Report newReport) {
        return reportRepository.save(newReport);
    }
    public Report getOneReport(Long reportId) {
        return reportRepository.findById(reportId).orElse(null);
    }
    public Report updateOneReport(Long reportId, Report updateReport) {
        Report oldReport = getOneReport(reportId);
        oldReport.setFileNo(updateReport.getFileNo());
        oldReport.setImage(updateReport.getImage());
        oldReport.setTc(updateReport.getTc());
        oldReport.setDiagnosticTitle(updateReport.getDiagnosticTitle());
        oldReport.setDiagnosticDetails(updateReport.getDiagnosticDetails());
        oldReport.setReportDate(updateReport.getReportDate());
        oldReport.setLaborant(updateReport.getLaborant());
        return reportRepository.save(oldReport);
    }
    public Report deleteReportById(Long reportId) {
        Report report=getOneReport(reportId);
        reportRepository.delete(report);
        return report;
    }

    public List<Report> getReportByLabId(Long id) {
        List<Report> reports = this.reportRepository.findByLaborant_Id(id);
        return reports;
    }


    @Value("${app.upload.dir}")
    private String uploadDir;

    public String uploadImage(Long reportId, MultipartFile image)throws Exception {
        Report report = getOneReport(reportId);
        String fileName= StringUtils.cleanPath(image.getOriginalFilename());
        String fileExtension =StringUtils.getFilenameExtension(fileName);
        String newFileName="report_"+report.getId()+"."+fileExtension;
        String uploadPath= uploadDir+"/"+newFileName;
        Path uploadPathDir = Paths.get(uploadDir);
        if (!Files.exists(uploadPathDir)){
            Files.createDirectories(uploadPathDir);
        }
        Path uploadPathFile=Paths.get(uploadPath);
        Files.deleteIfExists(uploadPathFile);
        Files.copy(image.getInputStream(),uploadPathFile);

        report.setImage(uploadPath);
        reportRepository.save(report);
        return uploadPath;
    }



//    public Page<Report> searchReports(String keyword, Pageable pageable) {
//        return reportRepository.searchReports(keyword, pageable);
//    }
}
