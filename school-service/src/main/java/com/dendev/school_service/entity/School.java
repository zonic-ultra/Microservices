package com.dendev.school_service.entity;

import com.dendev.school_service.dto.BranchDto;
import com.dendev.school_service.dto.SchoolDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schools")
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "school_gen")
    @TableGenerator(
            name = "school_gen",
            pkColumnName = "gen_name",
            valueColumnName = "gen_value",
            pkColumnValue = "school_id",
            initialValue = 101,
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Branch> branches = new ArrayList<>();


    public School(SchoolDto schoolDto){
        this.id = schoolDto.getId();
        this.name = schoolDto.getName();
        this.address = schoolDto.getAddress();
        this.branches = new ArrayList<>();
    }

}
