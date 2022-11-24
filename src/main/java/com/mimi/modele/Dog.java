package com.mimi.modele;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dogId;

    @Column(nullable = false, unique = false, length = 20)
    private String dogName;

    private Date dateOfBirth;

    @Column(nullable = false, unique = false, length = 20)
    private String breed;

    @Column(nullable = false, unique = false, length = 10)
    private String sexe;

    @Column(nullable = false, unique = false, length = 5)
    private String sterilization;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}