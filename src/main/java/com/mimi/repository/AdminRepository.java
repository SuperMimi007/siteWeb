package com.mimi.repository;

import com.mimi.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User,Integer> {
    public Integer countById(Integer  id);
}
