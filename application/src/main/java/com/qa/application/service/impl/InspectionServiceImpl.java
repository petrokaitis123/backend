package com.qa.application.service.impl;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.entity.Inspection;
import com.qa.application.entity.Product;
import com.qa.application.exception.inspection.InspectionNotFoundException;
import com.qa.application.exception.product.ProductNotFoundException;
import com.qa.application.mapper.InspectionMapper;
import com.qa.application.model.InspectionDto;
import com.qa.application.model.ProductDto;
import com.qa.application.repository.InspectionRepository;
import com.qa.application.repository.ProductRepository;
import com.qa.application.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InspectionServiceImpl implements InspectionService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    InspectionRepository inspectionRepository;
    InspectionMapper inspectionMapper;
    @Override
    public ResponseEntity<MessageResponse> addInspection(Integer id, InspectionDto inspection) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        inspection.setProduct(product);
        inspectionRepository.save(inspectionMapper.MAPPER.mapToInspection(inspection));
        return ResponseEntity.ok(new MessageResponse("Inspection added successfully"));
    }
    @Override
    public List<InspectionDto> findAllInspectionsByProductId(@PathVariable Integer id) {
        List<Inspection> inspections = new ArrayList<>();
        inspectionRepository.findAll().forEach(i ->
                inspections.add(i));
        return inspections.stream().map((i) -> inspectionMapper.MAPPER.mapToInspectionDto(i))
                .collect(Collectors.toList());
    }
    @Override
    public InspectionDto updateInspection(@PathVariable Integer id, @RequestBody InspectionDto newInspection) {
        Inspection existingInspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new InspectionNotFoundException(id));
        existingInspection.setInspectionDate(newInspection.getInspectionDate());
        existingInspection.setInspector(newInspection.getInspector());
        existingInspection.setStatus(newInspection.getStatus());
        return inspectionMapper.MAPPER.mapToInspectionDto(inspectionRepository.save(existingInspection));
    }
    @Override
    public void deleteInspection(@PathVariable Integer id) {
        if(!inspectionRepository.existsById(id)){
            throw new InspectionNotFoundException(id);
        }
        inspectionRepository.deleteById(id);
    }

    //will see if i use it
/*    @Override
    public InspectionDto getInspectionById(Integer id) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new InspectionNotFoundException(id));


        return inspectionMapper.MAPPER.mapToInspectionDto(inspection);
    }*/
}
