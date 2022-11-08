package com.mimi.repository;

import com.mimi.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    Integer countByUserId(Integer userId);



    @Query(value="SELECT * FROM User u WHERE u.userFirstName like %:keyword% or u.userLastName like %:keyword%", nativeQuery = true)
       List<User> findByKeyword (String keyword);
}


