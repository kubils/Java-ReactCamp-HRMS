package com.example.hrms.entities.concretes.CV;

import com.example.hrms.entities.concretes.Resumes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "experiences")
public class CvExperiences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "employer_name")
    private String employerName;

    @NotNull
    @Column(name = "position")
    private String position;

    @NotNull
    @Column(name = "started_year")
    private Date startedYear;

    @Column(name = "leave_year")
    private Date leaveYear;

    @JsonProperty( value = "resumes", access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;
}
