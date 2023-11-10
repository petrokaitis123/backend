package com.qa.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.application.entity.Defect;
import com.qa.application.entity.EmployeeRecords;
import com.qa.application.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
public class InspectionDto {

    private Integer id;

    private String inspectionDate;

    private String inspector;

    private Boolean status;


    private Set<EmployeeRecords> eRecords = new HashSet<>();

    private List<Defect> defectList;

    private Product product;

}
