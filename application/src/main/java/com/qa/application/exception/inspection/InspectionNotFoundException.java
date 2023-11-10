package com.qa.application.exception.inspection;

public class InspectionNotFoundException  extends RuntimeException {

    public InspectionNotFoundException(Integer id) {
        super("Could not find the inspection with id: " + id);
    }


}
