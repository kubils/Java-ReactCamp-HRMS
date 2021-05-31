package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobsList"}) //recursive solution
public class Employers extends User{

    @Column(name = "name")
    private String name;
    @Column(name = "website")
    private String website;
    @Column(name = "phone")
    private String phone;


    @OneToMany(mappedBy = "employers")
    private List<Jobs> jobsList;
 }
