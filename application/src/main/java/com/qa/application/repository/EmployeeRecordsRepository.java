package com.qa.application.repository;

import com.qa.application.entity.EmployeeRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRecordsRepository extends JpaRepository<EmployeeRecords,Integer> {

    Optional<EmployeeRecords> findDetailsByUserId(Integer id);
}
