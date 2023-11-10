package com.qa.application.mapper;

import com.qa.application.entity.EmployeeRecords;
import com.qa.application.model.EmployeeRecordsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeRecordsMapper {

    EmployeeRecordsMapper MAPPER = Mappers.getMapper(EmployeeRecordsMapper.class);

    EmployeeRecords mapToERecords(EmployeeRecordsDto employeeRecordsDto);
    EmployeeRecordsDto mapToERecordsDto(EmployeeRecords employeeRecords);
}
