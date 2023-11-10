package com.qa.application.controller;

import com.qa.application.entity.Inspection;
import com.qa.application.model.InspectionDto;
import com.qa.application.service.InspectionService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/inspections")
public class InspectionController {

    InspectionService inspectionService;


    @PostMapping("/add/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    void addInspection(@PathVariable Integer id, @RequestBody @Valid InspectionDto inspection) {
        inspectionService.addInspection(id,inspection);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    List<InspectionDto> findAllInspections(@PathVariable Integer id){
        return inspectionService.findAllInspectionsByProductId(id);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseBody
    InspectionDto updateInspection(@PathVariable Integer id, @RequestBody InspectionDto inspection){
        return inspectionService.updateInspection(id, inspection);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    void deleteInspection(@PathVariable Integer id) {
        inspectionService.deleteInspection(id);
    }


}