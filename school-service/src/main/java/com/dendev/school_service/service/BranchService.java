package com.dendev.school_service.service;

import com.dendev.school_service.dto.BranchDto;
import com.dendev.school_service.dto.SchoolDto;
import com.dendev.school_service.entity.Branch;

import java.util.List;

public interface BranchService {
    BranchDto addBranch(BranchDto branchDto);
    BranchDto updateBranch(Long id, BranchDto branchDto);

    void deleteBranch(Long id);
    BranchDto getBranchById(Long id);
    List<BranchDto> getAllBranches();
//    SchoolDto assignBranch(Long school_id, Long branch_id);
     Branch saveBranch(Branch branch);
    BranchDto assignBranchToSchool(Long schoolId, Long branchId);

}
