package com.mimi.modele;


import com.mimi.config.Role;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
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


    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        this.password=passwordEncoder.encode(password).toString();
    }

    public String getFullName(){
        return getUserFirstName()+" "+getUserLastName();
    }


}