package com.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidates extends User{

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String lastName;
    @Column(name = "identity_number")
    private String identityNumber;
    @Column(name = "birth_date")
    private Date birthDate;

/*
    @OneToOne
    private ActivationCode activationCode;
*/
}
