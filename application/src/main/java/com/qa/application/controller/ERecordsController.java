package com.qa.application.controller;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.entity.EmployeeRecords;
import com.qa.application.model.EmployeeRecordsDto;
import com.qa.application.service.ERecordsService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ERecordsController {


    ERecordsService eRecordsService;

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    ResponseEntity<MessageResponse> addERecords(@PathVariable Integer id, @RequestBody @Valid EmployeeRecordsDto employeeRecords) {
       return eRecordsService.addERecords(id, employeeRecords);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    EmployeeRecordsDto getDetailsByUserId(@PathVariable Integer id) {
        return eRecordsService.findEmployeeRecords(id);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    EmployeeRecordsDto updateRecords(@PathVariable Integer id, @RequestBody @Valid EmployeeRecordsDto employeeRecords){

        return eRecordsService.updateEmployeeRecords(id, employeeRecords);
    }
}
