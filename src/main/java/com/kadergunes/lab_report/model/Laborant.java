package com.kadergunes.lab_report.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="laborant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laborant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @Column(name = "hospital_id")
    private String hospitalidentitynumber;

    @JsonIgnore
    @OneToMany(mappedBy="laborant")
    private List<Report> reports;

    @Override
    public String toString() {
        return "Laborant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hospitalidentitynumber='" + hospitalidentitynumber + '\'' +
                '}';
    }
}

