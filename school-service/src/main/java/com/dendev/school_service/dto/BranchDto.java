package com.dendev.school_service.dto;

import com.dendev.school_service.entity.Branch;
import com.dendev.school_service.entity.School;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchDto {
    private Long id;

    @NotBlank(message = "Branch name is required!")
    private String branchName;

    @NotBlank(message = "Location is required!")
    private String location;


    public BranchDto(Branch branch){
        this.id = branch.getId();
        this.branchName = branch.getBranchName();
        this.location = branch.getLocation();
    }

}
