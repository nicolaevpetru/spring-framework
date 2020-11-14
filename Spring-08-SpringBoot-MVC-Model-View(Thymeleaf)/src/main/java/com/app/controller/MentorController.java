package com.app.controller;

import com.app.enums.Gender;
import com.app.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/list")
    public String showTable(Model model) {

        List<Mentor> mentors = new ArrayList<>();
        mentors.add(new Mentor("Michale", "Smith", 45, Gender.MALE));
        mentors.add(new Mentor("John", "Wick", 30, Gender.MALE));
        mentors.add(new Mentor("Emmy", "Bryan", 25, Gender.FEMALE));
        model.addAttribute("mentors", mentors);
        return "mentor/mentor-list";
    }
}
