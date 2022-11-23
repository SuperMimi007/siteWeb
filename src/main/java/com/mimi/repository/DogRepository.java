package com.mimi.repository;

import com.mimi.modele.Dog;

import com.mimi.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository  extends JpaRepository<Dog, Integer> {
    Integer countByDogId(Integer dogId);

    @Query(value="SELECT d FROM Dog d WHERE "
            +  "CONCAT(d.dogName, d.user.userLastName)"
            + "LIKE %?1%")
    public List<Dog> findAll (String keyword);
}
