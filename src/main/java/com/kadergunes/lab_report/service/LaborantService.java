package com.kadergunes.lab_report.service;

import com.kadergunes.lab_report.model.Laborant;
import com.kadergunes.lab_report.model.Report;
import com.kadergunes.lab_report.repository.LaborantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaborantService {

    private final LaborantRepository laborantRepository;

    public List<Laborant> getAllLab() {
       return laborantRepository.findAll();
    }
    public  Laborant getOneLaborant(Long laborantId) {
        return laborantRepository.findById(laborantId).orElse(null);
    }
    public Laborant saveOneLab(Laborant newlaborant) {
        return laborantRepository.save(newlaborant);
    }

    public Laborant deleteLabById(Long laborantId) {
        Laborant laborant = getOneLaborant(laborantId);
        laborantRepository.delete(laborant);
        return  laborant;
    }

    public Laborant updateOneLaborant(Long laborantId, Laborant updateLab) {
        return null;
    }

}
