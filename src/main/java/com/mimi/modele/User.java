package com.mimi.modele;

import com.mimi.config.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 40)
    private String email;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false,length = 20)
    private String firstName;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false,length = 50)
    private String address;

    @Column(nullable = false,length = 20)
    private String phone;

    @Column(nullable = false,length = 20)
    private String contact;

    @Enumerated(EnumType.STRING)
    private Role role;



    public User() {}

    public User(Integer id, String email, String name, String firstName, String password, String address, String phone, String contact, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
        this.role = role;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        this.password=passwordEncoder.encode(password).toString();
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



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", adress='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", contact='" + contact + '\'' +
                ", role=" + role +
                '}';


    }
}