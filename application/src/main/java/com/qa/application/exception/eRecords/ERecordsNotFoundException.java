package com.qa.application.exception.eRecords;

public class ERecordsNotFoundException extends RuntimeException{

    public ERecordsNotFoundException(Integer id) {
        super("Could not find employee records with id: " + id);
    }
}
