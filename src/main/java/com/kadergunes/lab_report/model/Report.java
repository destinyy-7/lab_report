package com.kadergunes.lab_report.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "file_no")
    private String fileNo;
    private String image;
    private String tc;
    @Column(name = "diagnostic_title")
    private String diagnosticTitle;
    @Column(name = "diagnostic_detail")
    private String diagnosticDetails;
    @Column(name = "report_date")
    private String reportDate;

    @ManyToOne()
    @JoinColumn(name="laborant_id")
    private Laborant laborant;

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", nameSurname='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fileNo='" + fileNo + '\'' +
                ", image='" + image + '\'' +
                ", tc='" + tc + '\'' +
                ", diagnosticTitle='" + diagnosticTitle + '\'' +
                ", diagnosticDetails='" + diagnosticDetails + '\'' +
                ", reportDate='" + reportDate + '\'' +
                ", laborant=" + laborant +
                '}';
    }
}


