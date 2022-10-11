package com.mimi.modele;

import com.mimi.config.Role;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20,nullable = false, unique = true)
    private String name;

    @Column(length = 40, nullable = false,unique = true)
    private String email;

    @Column(length = 10, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Admin (){}

    public Admin(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }




    public Integer getId() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {return role;}

    public void setRole(Role role) {this.role = role;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
