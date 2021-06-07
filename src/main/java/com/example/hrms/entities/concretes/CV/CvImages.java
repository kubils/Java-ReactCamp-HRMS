package com.example.hrms.entities.concretes.CV;

import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Resumes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"}) //recursive solution
public class CvImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="photo_url")
    private String photoUrl;

    @JsonProperty( value = "candidates", access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidates candidates;

    @JsonIgnore
    @OneToMany(mappedBy = "candidatesImage")
    private List<Resumes> resumes ;
}
