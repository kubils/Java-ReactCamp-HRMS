package com.example.hrms.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "activation_codes")
public class ActivationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String activation_codes;

    //@ManyToOne(targetEntity =User.class, fetch = FetchType.LAZY, optional = false) //!!!!!
    //@JoinColumn(name = "id", referencedColumnName = "id", nullable = false)

    @OneToOne
    private Candidates candidates;

}
