package com.mimi.repository;

import com.mimi.modele.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    public Long countById(Integer id);
}

