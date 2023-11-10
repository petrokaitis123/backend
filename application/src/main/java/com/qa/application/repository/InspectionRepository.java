package com.qa.application.repository;

import com.qa.application.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InspectionRepository extends JpaRepository<Inspection,Integer> {
    List<Inspection> findByProductId(Integer productId);
}
