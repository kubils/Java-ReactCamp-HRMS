package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//lombok getter- setter and constructor usage
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "jobs"}) //recursive solution
//database object definition
@Entity
@Table(name = "job_titles")
public class JobTitle {

    @Id //table id
    @GeneratedValue(strategy =GenerationType.IDENTITY)  //id increments
    @Column(name = "id") //table column name in db
    private int id;
    @Column(name = "title")
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "jobTitle")
    List<Jobs> jobs;
}
