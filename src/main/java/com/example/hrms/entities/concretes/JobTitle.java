package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//lombok getter- setter and constructor usage
@Data @AllArgsConstructor @NoArgsConstructor

//database object definition
@Entity
@Table(name = "job_titles")
public class JobTitle {
    @JsonIgnore
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
