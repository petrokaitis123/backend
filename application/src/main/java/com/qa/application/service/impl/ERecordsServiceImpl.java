package com.qa.application.service.impl;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.entity.EmployeeRecords;
import com.qa.application.entity.User;
import com.qa.application.exception.eRecords.ERecordsNotFoundException;
import com.qa.application.exception.user.UserNotFoundException;
import com.qa.application.mapper.EmployeeRecordsMapper;
import com.qa.application.model.EmployeeRecordsDto;
import com.qa.application.repository.EmployeeRecordsRepository;
import com.qa.application.repository.UserRepository;
import com.qa.application.service.ERecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ERecordsServiceImpl implements ERecordsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EmployeeRecordsRepository employeeRecordsRepository;
    EmployeeRecordsMapper employeeRecordsMapper;

    @Override
    public EmployeeRecordsDto findEmployeeRecords(Integer id) {
       EmployeeRecords eRecords = employeeRecordsRepository.findDetailsByUserId(id)
               .orElseThrow(() -> new ERecordsNotFoundException(id));
       return employeeRecordsMapper.MAPPER.mapToERecordsDto(eRecords);
    }

    @Override
    public ResponseEntity<MessageResponse> addERecords(Integer id, EmployeeRecordsDto employeeRecords) {
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        employeeRecords.setUser(user);
        employeeRecordsRepository.save(employeeRecordsMapper.MAPPER.mapToERecords(employeeRecords));

        return ResponseEntity.ok(new MessageResponse("Employee records added successfully"));
    }

    @Override
    public EmployeeRecordsDto updateEmployeeRecords(Integer id, EmployeeRecordsDto newERecords) {
        EmployeeRecords existingRecords = employeeRecordsRepository.findDetailsByUserId(id)
                .orElseThrow(() -> new ERecordsNotFoundException(id));
        existingRecords.setFirstname(newERecords.getFirstname());
        existingRecords.setLastname(newERecords.getLastname());
        existingRecords.setMobileNumber(newERecords.getMobileNumber());
        existingRecords.setAddress(newERecords.getAddress());
        existingRecords.setOccupation(newERecords.getOccupation());



        employeeRecordsRepository.save(existingRecords);

        return employeeRecordsMapper.MAPPER.mapToERecordsDto(existingRecords);

    }
}
