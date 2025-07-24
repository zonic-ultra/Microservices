package com.dendev.school_service.controller;

import com.dendev.school_service.dto.BranchDto;
import com.dendev.school_service.dto.SchoolDto;
import com.dendev.school_service.entity.School;
import com.dendev.school_service.service.BranchService;
import com.dendev.school_service.service.BranchServiceImpl;
import com.dendev.school_service.service.SchoolService;
import com.dendev.school_service.service.SchoolServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private BranchService branchService;

    @PostMapping("/add")
    public ResponseEntity<SchoolDto> createSchool(@Valid @RequestBody SchoolDto schoolDto){
        SchoolDto add  = schoolService.addSchool(schoolDto);

        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllSchools(){
        List<SchoolDto> schoolDtoList = schoolService.getAllSchools();
        return new ResponseEntity<>(schoolDtoList, HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable Long id){
        SchoolDto findById = schoolService.getSchoolById(id);

        return new ResponseEntity<>(findById,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<SchoolDto> updateSchool(@Valid @RequestBody School school){
        SchoolDto update = schoolService.updateSchool(school);
        return new ResponseEntity<>(update, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSchool(@PathVariable Long id){
         schoolService.deleteSchool(id);
    }

//    ==========Branch==========

    @PostMapping("/addBranch")
    public ResponseEntity<BranchDto> addBranch(@RequestBody BranchDto branchDto){
        BranchDto add  = branchService.addBranch(branchDto);

        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @GetMapping("/branches/all")
    public ResponseEntity<?> getAllBranch(){
        List<BranchDto> branchDtoList = branchService.getAllBranches();
        return new ResponseEntity<>(branchDtoList, HttpStatus.ACCEPTED);
    }
    @GetMapping("/branches/{id}")
    public ResponseEntity<?> getBranchById(@PathVariable Long id){
        BranchDto findById = branchService.getBranchById(id);

        return new ResponseEntity<>(findById,HttpStatus.OK);
    }
    @PutMapping("/branches/update/{id}")
    public ResponseEntity<BranchDto> updateBranch(@PathVariable Long id, @Valid @RequestBody BranchDto branchDto){
        BranchDto update = branchService.updateBranch(id, branchDto);
        return new ResponseEntity<>(update, HttpStatus.CREATED);
    }

    @DeleteMapping("/branches/delete/{id}")
    public void deleteBranch(@PathVariable Long id){
        branchService.deleteBranch(id);
    }

    @PostMapping("/branches/{branchId}/assign-to-school/{schoolId}")
    public ResponseEntity<BranchDto> assignBranchToSchool(@PathVariable Long branchId, @PathVariable Long schoolId) {
        BranchDto updatedBranch = branchService.assignBranchToSchool(schoolId, branchId);
        return ResponseEntity.ok(updatedBranch);
    }


}
