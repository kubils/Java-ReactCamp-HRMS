package com.example.hrms.entities.concretes.CV;

import com.example.hrms.entities.concretes.Resumes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skills")
public class CvSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String skillName;

    @JsonProperty( value = "resumes", access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;
}
