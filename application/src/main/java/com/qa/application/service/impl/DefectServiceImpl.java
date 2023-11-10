package com.qa.application.service.impl;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.entity.Defect;
import com.qa.application.entity.Inspection;
import com.qa.application.exception.defect.DefectNotFoundException;
import com.qa.application.mapper.DefectMapper;
import com.qa.application.model.DefectDto;
import com.qa.application.repository.DefectRepository;
import com.qa.application.repository.InspectionRepository;
import com.qa.application.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefectServiceImpl implements DefectService {

    @Autowired
    InspectionRepository inspectionRepository;
    @Autowired
    DefectRepository defectRepository;

    DefectMapper defectMapper;

    @Override
    public ResponseEntity<MessageResponse> addDefect(Integer id, DefectDto defect) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new DefectNotFoundException(id));
        defect.setInspection(inspection);
        defectRepository.save(defectMapper.MAPPER.mapToDefect(defect));
        return ResponseEntity.ok(new MessageResponse("Defect added successfully"));
    }

    @Override
    public List<DefectDto> findAllDefectsByInspectionId(Integer id) {
        List<Defect> defects = new ArrayList<>();
        defectRepository.findAll().forEach(d -> defects.add(d));
        return defects.stream().map((d) -> defectMapper.MAPPER.mapToToDefectDto(d))
                .collect(Collectors.toList());
    }

    @Override
    public DefectDto updateDefect(Integer id, DefectDto newDefect) {
        Defect existingDefect = defectRepository.findById(id)
                .orElseThrow(() -> new DefectNotFoundException(id));
        existingDefect.setDescription(newDefect.getDescription());
        existingDefect.setInspection(newDefect.getInspection());
        existingDefect.setSeverity(newDefect.getSeverity());
        return defectMapper.MAPPER.mapToToDefectDto(existingDefect);
    }
    @Override
    public void deleteDefect(Integer id) {
        if(!defectRepository.existsById(id)){
            throw new DefectNotFoundException(id);
        }
        defectRepository.deleteById(id);
    }
}
