package com.mimi;

import com.mimi.modele.Admin;
import com.mimi.repository.LoginRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class LoginTest {
    @Autowired
    private LoginRepository loginRepo;
    @Test
    public void testFindUserByEmail() {
        String email = "testeur@gmail.com";
        Admin admin = loginRepo.findByEmail(email);
        Assertions.assertThat(admin).isNotNull();
    }


}
