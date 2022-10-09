package com.mimi.data;

import com.mimi.service.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

    public Long countById(Integer id);
}
