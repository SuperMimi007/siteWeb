package com.mimi.repository;

import com.mimi.config.Role;
import com.mimi.modele.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;


    @Test
    public void save() {
        User user = new User();
        user.setUserLastName("Pre");
        user.setUserFirstName("Christophe");
        user.setEmail("Christo@gmail.com");
        user.setPassword("Christo");
        user.setAddress("44 rue des prés 93160 Noisy");
        user.setPhone("01.65.96.36.56");
        user.setContact("vétérinaire");
        user.setRole(Role.valueOf("USER"));

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getUserId()).isGreaterThan(0);
    }

    @Test
    public void testListUsers() {
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUser() {
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("rooooo");
        repo.save(user);
        User updateUser = repo.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("rooooo");
    }

    @Test
    public void testGetUser() {
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());

    }

    @Test
    public void testDeleteUser() {
        Integer userId = 1;
        repo.deleteById(userId);
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }


}
