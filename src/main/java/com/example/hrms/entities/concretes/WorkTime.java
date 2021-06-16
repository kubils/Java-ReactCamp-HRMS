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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "jobs"}) //recursive solution
//database object definition
@Entity
@Table(name = "work_time")
public class WorkTime {

    @Id //table id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id increments
    @Column(name = "workTime_id") //table column name in db
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "workTime")
    private List<Jobs> jobs;
}
