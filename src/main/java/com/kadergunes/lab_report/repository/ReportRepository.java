package com.kadergunes.lab_report.repository;

import com.kadergunes.lab_report.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {

//    @Query("SELECT r FROM Report r WHERE " +
//            "CONCAT(r.nameSurname, ' ', r.tc, ' ', r.laborant.name) " +
//            "LIKE %:keyword% " + // :keyword kullanarak parametreyi belirtiyoruz
//            "ORDER BY r.reportDate DESC")
//    Page<Report> searchReports(@Param("keyword") String keyword, Pageable pageable);

    List<Report> findByLaborant_Id(Long laborantId);

}

