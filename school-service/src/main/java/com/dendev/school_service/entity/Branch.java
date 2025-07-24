package com.dendev.school_service.entity;

import com.dendev.school_service.dto.BranchDto;
import com.dendev.school_service.dto.SchoolDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "branches")
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_seq")
    @SequenceGenerator(
            name = "branch_seq",
            sequenceName = "branch_sequence",
            initialValue = 201,
            allocationSize = 1
    )
    private Long id;

    private String branchName;
    private String location;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Branch(){

    }
    public Branch (BranchDto branchDto){
        this.id = branchDto.getId();
        this.branchName = branchDto.getBranchName();
        this.location = branchDto.getLocation();
    }

}
