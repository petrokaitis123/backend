package com.qa.application.service;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.entity.Inspection;
import com.qa.application.model.InspectionDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InspectionService {

    ResponseEntity<MessageResponse> addInspection(Integer id, InspectionDto inspection);
    List<InspectionDto> findAllInspectionsByProductId(Integer id);

    InspectionDto updateInspection(Integer id, InspectionDto newInspection);
    void deleteInspection(Integer id);
}
