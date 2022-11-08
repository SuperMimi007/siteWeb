package com.mimi.modele;

import com.mimi.config.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer userId;

    @Column(unique = true, length = 40)
    private String email;

    @Column(nullable = false,length = 20)
    private String userLastName;

    @Column(length = 20)
    private String userFirstName;

    @Column(length = 64)
    private String password;

    @Column(nullable = false,length = 90)
    private String address;

    @Column(length = 20)
    private String phone;

    @Column(length = 20)
    private String contact;

    @Enumerated(EnumType.STRING)
    private Role role;

      public User() {}

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String email, String userLastName, String userFirstName, String password, String address, String phone, String contact, Role role) {
        this.userId = userId;
        this.email = email;
        this.userLastName = userLastName;
        this.userFirstName = userFirstName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        this.password=passwordEncoder.encode(password).toString();
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", contact='" + contact + '\'' +
                ", role=" + role +
                '}';
    }
}