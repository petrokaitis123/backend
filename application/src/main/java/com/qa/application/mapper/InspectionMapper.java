package com.qa.application.mapper;

import com.qa.application.entity.Inspection;
import com.qa.application.model.InspectionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InspectionMapper {
    InspectionMapper MAPPER = Mappers.getMapper(InspectionMapper.class);

    InspectionDto mapToInspectionDto(Inspection inspection);
    Inspection mapToInspection(InspectionDto inspectionDto);
}
