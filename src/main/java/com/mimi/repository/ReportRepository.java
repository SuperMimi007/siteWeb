package com.mimi.repository;

import com.mimi.modele.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    List<Report> findAll();

    @Query(value="SELECT r FROM Report r WHERE "
            +  "CONCAT(r.reportName,r.dateOfReport)"
            + "LIKE %?1%")
    public List<Report> findAll (String keyword);

}

