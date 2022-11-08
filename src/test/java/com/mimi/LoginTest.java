package com.mimi;

import com.mimi.modele.User;
import com.mimi.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class LoginTest {
   @Autowired
    private UserRepository userRepo;
    @Test
    public void testFindUserByEmail() {
        String email = "emilie@gmail.com";
        User user = userRepo.findByEmail(email);
        Assertions.assertThat(user).isNotNull();
    }


}
