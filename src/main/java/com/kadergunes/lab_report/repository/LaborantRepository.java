package com.kadergunes.lab_report.repository;

import com.kadergunes.lab_report.model.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaborantRepository extends JpaRepository<Laborant,Long> {

}


