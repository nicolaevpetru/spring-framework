package com.app.controller;

import com.app.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model) {
        model.addAttribute("name", "Petru");
        model.addAttribute("course", "MVC");
        String subject = "Collections";
        model.addAttribute("subject", subject);

        // create some random ID
        int id = new Random().nextInt(1000);
        model.addAttribute("id", id);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(56);
        numbers.add(43);
        model.addAttribute("numbers", numbers);

        // print the birthday
        LocalDate birthday = LocalDate.now().minusYears(60);
        model.addAttribute("birthday", birthday);

        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);
        return "student/welcome";
    }

    @GetMapping("/register")
    public String homePage2() {
        return "student/register";
    }
}
