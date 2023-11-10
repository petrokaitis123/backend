package com.qa.application.service;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.entity.EmployeeRecords;
import com.qa.application.model.EmployeeRecordsDto;
import org.springframework.http.ResponseEntity;

public interface ERecordsService {

    EmployeeRecordsDto findEmployeeRecords(Integer id);

    ResponseEntity<MessageResponse> addERecords(Integer id, EmployeeRecordsDto employeeRecords);
    EmployeeRecordsDto updateEmployeeRecords(Integer id, EmployeeRecordsDto newERecords);

}
