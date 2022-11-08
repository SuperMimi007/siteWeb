package com.mimi.modele;

import com.mimi.modele.User;

import javax.persistence.*;
import java.sql.Date;


@Entity
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


    public Dog(Integer dogId, String dogName, Date dateOfBirth, String breed, String sexe, String sterilization, User user) {
        this.dogId = dogId;
        this.dogName = dogName;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.sexe = sexe;
        this.sterilization = sterilization;
        this.user = user;
    }

    public Dog() {

    }

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
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

    public String getSexe() {

        return sexe;
    }

    public void setSexe(String sexe) {

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

    @Override
    public String toString() {
        return "Dog{" +
                "dogId=" + dogId +
                ", dogName='" + dogName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", breed='" + breed + '\'' +
                ", sexe='" + sexe + '\'' +
                ", sterilization='" + sterilization + '\'' +
                ", user=" + user +
                '}';
    }
}