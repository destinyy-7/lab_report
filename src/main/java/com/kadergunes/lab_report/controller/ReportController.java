package com.kadergunes.lab_report.controller;


import com.kadergunes.lab_report.model.Report;
import com.kadergunes.lab_report.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1/report")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Report>> getAll(){
        return ResponseEntity.ok(this.reportService.getAllReport());
    }
    @PostMapping("/createreport")
    public ResponseEntity<Report> createReport(@RequestBody Report newReport){
        return ResponseEntity.ok(this.reportService.saveOneReport(newReport));
    }
    @PutMapping("/update/{reportId}")
    public  ResponseEntity<Report> updateOneReport(@PathVariable(value = "reportId") Long reportId,@RequestBody Report updateReport){
        return ResponseEntity.ok(this.reportService.updateOneReport(reportId,updateReport));
    }
    @DeleteMapping("/delete/{reportId}")
    public ResponseEntity<Report> deleteOneReport(@PathVariable(name="reportId") Long reportId){
        return ResponseEntity.ok(this.reportService.deleteReportById(reportId));
    }
    @GetMapping("/{reportId}")
    public ResponseEntity<Report>getReportById(@PathVariable(name = "reportId") Long reportId){
        return ResponseEntity.ok(this.reportService.getOneReport(reportId));
    }
//    @GetMapping("/search")
//    public ResponseEntity<Page<Report>> searchReports(
//            @RequestParam String keyword,
//            Pageable pageable
//    ) {
//        Page<Report> reports = reportService.searchReports(keyword, pageable);
//        return ResponseEntity.ok(reports);
//    }
    @GetMapping("/view/getByLaborant/{id}")
    public ResponseEntity<List<Report>> getReportByLabId(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(this.reportService.getReportByLabId(id));
    }
    @PostMapping("/{reportId}/image")
    public ResponseEntity<?> uploadImage(@PathVariable("reportId") Long reportId, @RequestParam("image") MultipartFile image) throws Exception{
        String imagePath=reportService.uploadImage(reportId,image);
        return ResponseEntity.ok(imagePath);
    }

}
