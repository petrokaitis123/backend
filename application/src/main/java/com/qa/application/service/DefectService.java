package com.qa.application.service;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.entity.Defect;
import com.qa.application.model.DefectDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DefectService {

    ResponseEntity<MessageResponse> addDefect(Integer id, DefectDto defect);
    List<DefectDto> findAllDefectsByInspectionId(Integer id);
    DefectDto updateDefect(Integer id, DefectDto newDefect);
    void deleteDefect(Integer id);
}
