package com.mimi.modele;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false, length = 20)
    private String dogName;

    @Basic
    private java.sql.Date dateOfBirth;

    @Column(nullable = false, unique = false, length = 20)
    private String breed;

    @Column(nullable = false, unique = false, length = 10)
    private Boolean sexe;

    @Column(nullable = false, unique = false, length = 5)
    private String sterilization;

    @ManyToOne
    private User user;

    public Dog(Integer id, String dogName, Date dateOfBirth, String breed, Boolean sexe, String sterilization, User user) {
        this.id = id;
        this.dogName = dogName;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.sexe = sexe;
        this.sterilization = sterilization;
        this.user=user;
    }

    public Dog() {

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getDogName() {

        return dogName;
    }

    public void setDogName(String dogName) {

        this.dogName = dogName;
    }

    public Date getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getBreed() {

        return breed;
    }

    public void setBreed(String breed) {

        this.breed = breed;
    }

    public Boolean getSexe() {

        return sexe;
    }

    public void setSexe(Boolean sexe) {

        this.sexe = sexe;
    }

    public String getSterilization() {
        return sterilization;
    }

    public void setSterilization(String sterilization) {
        this.sterilization = sterilization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
