package com.mimi.data;

import com.mimi.modele.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    public Long countById(Integer id);
}


