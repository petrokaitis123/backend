package com.qa.application.mapper;

import com.qa.application.entity.Defect;

import com.qa.application.model.DefectDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DefectMapper {

    DefectMapper MAPPER = Mappers.getMapper(DefectMapper.class);
    Defect mapToDefect(DefectDto defect);
    DefectDto mapToToDefectDto(Defect defect);

    }

