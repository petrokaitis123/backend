package com.qa.application.controller;

import com.qa.application.controller.payload.response.MessageResponse;
import com.qa.application.entity.Defect;
import com.qa.application.model.DefectDto;
import com.qa.application.service.DefectService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.bridge.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/defects")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefectController {

    DefectService defectService;

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> addDefect(@PathVariable Integer id, @RequestBody @Valid DefectDto defect) {
       return defectService.addDefect(id,defect);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    List<DefectDto> getDefectsByInspectionId(@PathVariable Integer id) {
        return defectService.findAllDefectsByInspectionId(id);
    }
    @PutMapping("/update/{id}")
    @PreAuthorize("or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseBody
    public DefectDto updateDefect(@PathVariable Integer id, @RequestBody DefectDto defect) {
        return defectService.updateDefect(id,defect);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteDefect(@PathVariable Integer id){
        defectService.deleteDefect(id);
    }
}

