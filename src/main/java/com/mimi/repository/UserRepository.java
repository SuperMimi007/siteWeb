package com.mimi.repository;

import com.mimi.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    Integer countById(Integer  id);

    @Query("SELECT u FROM User u WHERE "
            + "CONCAT(u.id,u.name,u.firstName)"
            + "LIKE %?1%")
    List<User> findAll(String keyword);

}


