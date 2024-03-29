package com.derivedqueries;

import com.derivedqueries.repository.DepartmentRepository;
import com.derivedqueries.repository.EmployeeRepository;
import com.derivedqueries.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DerivedqueriesApplication {


    @Autowired
    RegionRepository regionRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DerivedqueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions() {
        System.out.println();
        System.out.println("------------------ REGION STARTS -----------------");
        System.out.println("findByCountry : " + regionRepository.findByCountry("Canada"));
        System.out.println();
        System.out.println("findDistinctByCountry : " + regionRepository.findByCountry("Canada"));
        System.out.println();
        System.out.println("findByCountryContaining : " + regionRepository.findByCountryContaining("United"));
        System.out.println();
        System.out.println("findByCountryContainingOrderByCountry : " + regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println();
        System.out.println("findTopBy2ByCountry : " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("------------------ REGION ENDS -----------------");
        System.out.println();

    }

    @PostConstruct
    public void testDepartments() {

        System.out.println("------------------ DEPARTMENTS STARTS -----------------");
        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));
        System.out.println();
        System.out.println("findByDivision: " + departmentRepository.findByDivision("Outdoors"));
        System.out.println();
        System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println();
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("------------------ DEPARTMENTS ENDS -----------------");
        System.out.println();

    }

    @PostConstruct
    public void testEmployees() {
        System.out.println("------------------ EMPLOYEES STARTS -----------------");
        System.out.println();
        System.out.println("findByEmailIsNull : " + employeeRepository.findByEmailIsNull());
        System.out.println("------------------ EMPLOYEES ENDS -----------------");
        System.out.println();
    }
}
