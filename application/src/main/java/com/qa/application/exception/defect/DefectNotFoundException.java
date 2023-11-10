package com.qa.application.exception.defect;


public class DefectNotFoundException  extends RuntimeException {

    public DefectNotFoundException(Integer id) {
        super("Could not find the product with id: " + id);
    }


}


