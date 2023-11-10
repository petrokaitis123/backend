package com.qa.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private Integer productNumber;
    private String name;
    private String description;


}
