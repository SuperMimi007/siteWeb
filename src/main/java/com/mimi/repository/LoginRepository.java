package com.mimi.repository;

import com.mimi.modele.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository <Admin,Integer> {
    public Admin findByEmail(String email);
}
