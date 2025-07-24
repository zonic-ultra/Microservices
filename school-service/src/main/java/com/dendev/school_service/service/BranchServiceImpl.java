package com.dendev.school_service.service;

import com.dendev.school_service.dto.BranchDto;
import com.dendev.school_service.dto.SchoolDto;
import com.dendev.school_service.entity.Branch;
import com.dendev.school_service.entity.School;
import com.dendev.school_service.exception.BranchException;
import com.dendev.school_service.exception.SchoolException;
import com.dendev.school_service.repository.BranchRepository;
import com.dendev.school_service.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    public BranchDto addBranch(BranchDto branchDto) {
        Branch branch = new Branch(branchDto);
        Branch saved = branchRepository.save(branch);
        return new BranchDto(saved);
    }



    @Override
    public BranchDto updateBranch(Long id, BranchDto branchDto) {
        Branch existingBranch = branchRepository.findById(id)
                .orElseThrow(()-> new BranchException("Branch not found with id " + id ));

        existingBranch.setBranchName(branchDto.getBranchName());
        existingBranch.setLocation(branchDto.getLocation());
        branchRepository.save(existingBranch);

       return new BranchDto(existingBranch);
    }

    @Override
    public void deleteBranch(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(()-> new BranchException("Branch not found with id " + id ));
        branchRepository.delete(branch);
    }

    @Override
    public BranchDto getBranchById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(()-> new BranchException("Branch not found with id " + id ));
        return new BranchDto(branch);
    }

    @Override
    public List<BranchDto> getAllBranches() {
        List<BranchDto> schoolDtoList = branchRepository.findAll().stream().map(BranchDto::new).collect(Collectors.toList());

        return schoolDtoList;
    }

    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public BranchDto assignBranchToSchool(Long schoolId, Long branchId) {

        // 1. Find School by ID
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new SchoolException("School not found with id " + schoolId));

        // 2. Find Branch by ID
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new BranchException("Branch not found with id " + branchId));

        // 3. Assign the relationship
        branch.setSchool(school);  // <- This sets the school reference in the branch
        school.getBranches().add(branch); // <- This adds the branch to the school's branch list

        // 4. Save only the branch (or school if needed)
        Branch updatedBranch = branchRepository.save(branch); // or schoolRepository.save(school) if needed

        // 5. Return DTO
        return new BranchDto(updatedBranch);
    }


}
