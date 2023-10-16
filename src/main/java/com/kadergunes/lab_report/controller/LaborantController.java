package com.kadergunes.lab_report.controller;

import com.kadergunes.lab_report.model.Laborant;
import com.kadergunes.lab_report.service.LaborantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1/laborant")
public class LaborantController {
    private LaborantService laborantService;

    public LaborantController(LaborantService laborantService) {
        this.laborantService = laborantService;
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Laborant>> getAll(){
        return ResponseEntity.ok(this.laborantService.getAllLab());
    }
    @PostMapping("/createlab")
    public ResponseEntity<Laborant> createLaborant(@RequestBody Laborant newlaborant){
        return ResponseEntity.ok(laborantService.saveOneLab(newlaborant));
    }
    @PutMapping("/update/{laborantId}")
    public  ResponseEntity<Laborant> updateOneReport(@PathVariable(value = "laborantId") Long laborantId,@RequestBody Laborant updateLab){
        return ResponseEntity.ok(this.laborantService.updateOneLaborant(laborantId,updateLab));
    }
    @GetMapping("/{laborantId}")
    public  ResponseEntity<Laborant> getLaborantById(@PathVariable Long laborantId){
        return ResponseEntity.ok(laborantService.getOneLaborant(laborantId));
    }
    @DeleteMapping("/delete/{laborantId}")
    ResponseEntity<Laborant> deleteOneReport(@PathVariable Long laborantId){
        return ResponseEntity.ok(laborantService.deleteLabById(laborantId));
    }
}
