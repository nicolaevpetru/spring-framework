package com.derivedqueries.repository;

import com.derivedqueries.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Display all employees with email address ''
    List<Employee> findByEmail(String email);

    // Display all employee with first name '', and last name '', also show all employees with a email address ''
    List<Employee> findByFirstNameAndLastNameOrEmail(String firsName, String lastName, String email);

    // Display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where last name starts with ''
    List<Employee> findByLastNameStartingWith(String pattern);

    // Display all employees with salaries higher that ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Display all employees with salaries less that ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // Display some employees that has been hired between '' and '' date
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salary is greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top unique 3 employees that is making less that ''
    List<Employee> findDistinctTop3BySalaryLessThanEqual(Integer salary);


    // Display all employees that do not have email address
    List<Employee> findByEmailIsNull();
}
