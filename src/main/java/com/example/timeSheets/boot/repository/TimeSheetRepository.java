package com.example.timeSheets.boot.repository;

import com.example.timeSheets.boot.model.Customer;
import com.example.timeSheets.boot.model.TimeSheet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {

    @Query(value = "select ts from TimeSheet ts order by id desc")
    Page<TimeSheet> getTimeSheets(Pageable pageable);

    @Query(value = "select count(ts)>0 from TimeSheet ts where ts.project.id = :projectId")
    Boolean existsProjectById(@Param("projectId") Long projectId);
}