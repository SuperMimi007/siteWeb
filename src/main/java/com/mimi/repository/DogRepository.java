package com.mimi.repository;

import com.mimi.modele.Dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository  extends JpaRepository<Dog, Integer> {
    public Integer countByDogId(Integer dogId);


}
