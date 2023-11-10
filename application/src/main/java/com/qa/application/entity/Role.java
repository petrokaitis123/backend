package com.qa.application.entity;

import com.qa.application.enums.ERole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;


}
