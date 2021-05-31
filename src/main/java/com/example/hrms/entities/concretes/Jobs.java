package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_definition")
    private String jobDefinition;

    @Column(name = "number_of_position")
    private int number_of_job_position;

    @Column(name = "min_salary")
    private double minSalary;

    @Column(name = "max_salary")
    private double maxSalary;

    @Column(name = "date_of_open")
    private Date dateOfOpen;

    @Column(name = "date_of_closed")
    private Date dateOfClosed;

    @Column(name = "is_active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "id_job_titles")
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employers employers;
}
