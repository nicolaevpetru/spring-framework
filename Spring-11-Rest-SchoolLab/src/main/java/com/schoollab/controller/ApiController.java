package com.schoollab.controller;


import com.schoollab.model.Address;
import com.schoollab.model.ResponseWrapper;
import com.schoollab.model.Teacher;
import com.schoollab.repository.AddressRepository;
import com.schoollab.repository.ParentRepository;
import com.schoollab.repository.StudentRepository;
import com.schoollab.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {


    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private ParentRepository parentRepository;
    private AddressRepository addressRepository;

    public ApiController(TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository, AddressRepository addressRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/teachers")
    public List<Teacher> redAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {

        return ResponseEntity
                .ok(new ResponseWrapper("students are successfully retrieved", studentRepository.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {

        ResponseWrapper responseWrapper = new ResponseWrapper(true, "Parents are successfully retrieved",
                HttpStatus.ACCEPTED.value(),
                parentRepository.findAll());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(id);

        if (!foundAddress.isPresent()) {
            throw new Exception("Address does not exists!");
        }

        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));
        address.setId(foundAddress.get().getId());

        return addressRepository.save(address);


    }
}
