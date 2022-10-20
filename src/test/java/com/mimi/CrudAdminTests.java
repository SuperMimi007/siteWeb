package com.mimi;

import com.mimi.config.Role;
import com.mimi.modele.Admin;
import com.mimi.repository.AdminRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CrudAdminTests {
    @Autowired
    private AdminRepository repo;


    @Test
    public void testAddNew() {
        Admin admin = new Admin();
        admin.setName("Christophe");
        admin.setPassword("Poupette");
        admin.setEmail("tot@gmail.com");
        admin.setRole(Role.valueOf("ADMIN"));

        Admin savedAdmin = repo.save(admin);

        Assertions.assertThat(savedAdmin).isNotNull();
        Assertions.assertThat(savedAdmin.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAdmins() {
        Iterable<Admin> admins = repo.findAll();
        Assertions.assertThat(admins).hasSizeGreaterThan(0);

        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void testUpdateAdmin() {
        Integer adminId = 37;
        Optional<Admin> optionalAdmin = repo.findById(adminId);
        Admin admin = optionalAdmin.get();
        admin.setPassword("Kiam");
        repo.save(admin);
        Admin updateAdmin = repo.findById(adminId).get();
        Assertions.assertThat(updateAdmin.getPassword()).isEqualTo("Kiam");

    }

    @Test
    public void testGetAdmin() {
        Integer adminId = 23;
        Optional<Admin> optionalAdmin = repo.findById(adminId);
        Assertions.assertThat(optionalAdmin).isPresent();
        System.out.println(optionalAdmin.get());

    }

    @Test
    public void testDeleteAdmin() {
        Integer adminId = 37;
        repo.deleteById(adminId);
        Optional<Admin> optionalAdmin = repo.findById(adminId);
        Assertions.assertThat(optionalAdmin).isNotPresent();
    }



}