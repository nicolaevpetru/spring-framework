package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.app.enums.Gender;
import org.springframework.stereotype.Controller;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mentor {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
}
