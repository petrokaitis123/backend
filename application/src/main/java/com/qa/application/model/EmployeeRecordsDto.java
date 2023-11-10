package com.qa.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.application.entity.Inspection;
import com.qa.application.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeRecordsDto {

    private Integer id;

    private String firstname;

    private String lastname;

    private String occupation;

    private String address;

    private String mobileNumber;

    private User user;

    private Set<Inspection> inspections = new HashSet<>();
}
