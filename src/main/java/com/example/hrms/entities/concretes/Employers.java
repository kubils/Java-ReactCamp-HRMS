package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
public class Employers extends User{

    @Column(name = "name")
    private String name;
    @Column(name = "website")
    private String website;
    @Column(name = "phone")
    private String phone;
}
