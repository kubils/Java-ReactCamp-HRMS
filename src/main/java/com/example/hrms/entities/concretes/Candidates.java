package com.example.hrms.entities.concretes;


import com.example.hrms.entities.concretes.CV.CvImages;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"}) //recursive solution
public class Candidates extends User{

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String lastName;
    @Column(name = "identity_number")
    private String identityNumber;
    @Column(name = "birth_date")
    private Date birthDate;


    @OneToMany(mappedBy = "candidates")
    private List<Resumes> resume;

    @OneToMany(mappedBy = "candidates")
    private List<CvImages> cvImages;
}
