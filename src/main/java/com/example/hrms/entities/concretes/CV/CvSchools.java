package com.example.hrms.entities.concretes.CV;

import com.example.hrms.entities.concretes.Resumes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schools")
public class CvSchools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "school_name")
    private String schoolName;

    @NotNull
    @Column(name = "department")
    private String schoolDepartment;

    @NotNull
    @Column(name = "started_year")
    private Date startedYear;

    @Column(name = "graduate_year")
    private Date graduateYear;

    @JsonProperty( value = "resumes", access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;

}
