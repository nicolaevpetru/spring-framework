package com.jpql.entity;

import com.jpql.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @ManyToOne
    private Region region;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer salary;
}
