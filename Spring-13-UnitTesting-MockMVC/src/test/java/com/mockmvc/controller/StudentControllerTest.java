package com.mockmvc.controller;

import com.mockmvc.entity.Student;
import com.mockmvc.service.StudentService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    void getStudent_service() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\"id\":0,\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":20}"))
                .andReturn();
    }

    @Test
    void jsonAssert() throws JSONException {
        String actual = "{\"id\":0,\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":20}";
        String expected = "{\"id\":0,\"firstName\":\"John\",\"lastName\":\"Smith\"}";

        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    void jsonAssert_withoutEscapeCharacters() throws JSONException {
        String actual = "{id :0,firstName:John,lastName:Smith,age:20}";
        String expected = "{id:0,firstName:John,lastName:Smith}";

        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    void getStudent_data() throws Exception {
        when(studentService.getStudent_data()).thenReturn(Arrays.asList(
                new Student("Student 1 FirstName", "Student 1 LastName", 24),
                new Student("Student 2 FirstName", "Student 2 LastName", 50)
        ));
        mockMvc.perform(MockMvcRequestBuilders.get("/data").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":0,\"firstName\":\"Student 1 FirstName\",\"lastName\":\"Student 1 LastName\",\"age\":24},{\"id\":0,\"firstName\":\"Student 2 FirstName\",\"lastName\":\"Student 2 LastName\",\"age\":50}]"))
                .andReturn();
    }
}