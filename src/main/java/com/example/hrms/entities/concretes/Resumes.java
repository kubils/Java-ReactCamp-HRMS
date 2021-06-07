package com.example.hrms.entities.concretes;

import com.example.hrms.entities.concretes.CV.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumes")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidatesImage","candidateExperiences","candidateSkills","candidateLanguages","candidateLinks","candidateSchools","candidateSummaries"})
public class Resumes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String resumeName;

    @Column(name = "github")
    private String githubLink;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "summary")
    private String summary;

    @JsonProperty( value = "candidates", access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidates candidates;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resumes")
    private List<CvExperiences> candidateExperiences;

    @OneToMany(mappedBy = "resumes")
    private List<CvSchools> candidateSchools;

    @OneToMany(mappedBy = "resumes")
    private List<CvLanguages> candidateLanguages;

    @OneToMany(mappedBy = "resumes")
    private List<CvSkills> candidateSkills;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private CvImages candidatesImage;
}
