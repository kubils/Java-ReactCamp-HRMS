package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//lombok getter- setter and constructor usage
@Data @AllArgsConstructor @NoArgsConstructor
//database object definition
@Entity
@Table(name = "job_titles")
public class JobTitle {
    @Id //table id
    @GeneratedValue  //id increments
    @Column(name = "id") //table column name in db
    private int id;
    @Column(name = "title")
    private String title;
}
