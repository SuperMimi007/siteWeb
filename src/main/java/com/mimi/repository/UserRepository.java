package com.mimi.repository;

import com.mimi.modele.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    Integer countByUserId(Integer userId);
    List<User> findAll();



    @Query(value="SELECT u FROM User u WHERE "
            +  "CONCAT(u.userFirstName,u.userLastName,u.role)"
            + "LIKE %?1%")
       public List<User> findAll (String keyword);

}




