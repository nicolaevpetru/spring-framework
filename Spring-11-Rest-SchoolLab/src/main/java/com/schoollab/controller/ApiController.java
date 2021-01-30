package com.schoollab.controller;

import com.schoollab.model.ResponseWrapper;
import com.schoollab.model.Teacher;
import com.schoollab.repository.ParentRepository;
import com.schoollab.repository.StudentRepository;
import com.schoollab.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {


    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private ParentRepository parentRepository;

    public ApiController(TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
    }

//    @GetMapping("/teachers")
//    public List<Teacher> redAllTeachers() {
//        return teacherRepository.findAll();
//    }

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
}
