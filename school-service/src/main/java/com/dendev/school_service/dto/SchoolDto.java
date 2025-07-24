package com.dendev.school_service.dto;

import com.dendev.school_service.entity.Branch;
import com.dendev.school_service.entity.School;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolDto {
    private Long id;

    @NotBlank(message = "School name is required!")
    private String name;

    @NotBlank(message = "Address name is required!")
    private String address;

    private List<BranchDto> branches = new ArrayList<>();

    public SchoolDto(School school){
        this.id = school.getId();
        this.name = school.getName();
        this.address = school.getAddress();
        if(school.getBranches() != null){
            this.branches = school.getBranches().stream()
                    .map(BranchDto::new)
                    .collect(Collectors.toList());

        }
    }

}
