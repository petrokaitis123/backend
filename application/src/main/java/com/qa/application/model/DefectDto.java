package com.qa.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.application.entity.Inspection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class DefectDto {

    private Integer id;

    private String description;

    private String severity;

    private Inspection inspection;

}
