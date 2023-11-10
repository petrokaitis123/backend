package com.qa.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/*
* Defect will have id which will be auto incremented and assigned after each insert, description, severity of defect.
* It will have @ManytoOne bidirectional relationship, so multipleDefects will be assigned to Inspections
*
* */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "defects")
public class Defect {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String description;

    @NotBlank
    private String severity;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "inspection_id")
    private Inspection inspection;


}