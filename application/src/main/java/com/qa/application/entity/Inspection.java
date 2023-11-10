package com.qa.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import java.util.HashSet;
import java.util.Set;

/*
* Inspections will have id assigned and incremented by one after each new inspection inserted.
* Also it will have when inspection was done, whos working on that inspection, and status which says if its ON GOING or COMPLETED.
* Inspections will have relationships with EmployeeRecord @ManyToMany bidirectional, that either inspection will be able to see who and how many were working on it as well as employeeRecords can track how many inspections particular employee made.
* Inspection will have @OneToMany unidirectional relationship, so inspection will be able to have multiple defect records available .
* Inspection will have @ManytoOne bidirectional relationship, so Product will be able to have multiple Inspections list.
* */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "inspections")
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String inspectionDate;

    @NotBlank
    private String inspector;

    @NotNull
    private Boolean status;

    @JsonIgnore
    @ManyToMany(mappedBy = "inspections")
    private Set<EmployeeRecords> eRecords = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "inspection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Defect> defectList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}

