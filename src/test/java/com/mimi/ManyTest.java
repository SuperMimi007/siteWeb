package com.mimi;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class ManyTest {

   /* public void saveDogWithOneToOneAssociation_thenSuccess() {
        User user = new User("Bob", "Smith");
        Address address = new Address("London", "221b Baker Street");
        user.setAddress(address);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }*/
}
