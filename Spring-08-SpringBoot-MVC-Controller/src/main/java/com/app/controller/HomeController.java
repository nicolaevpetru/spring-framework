package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping() {
        return "home";
    }

    @RequestMapping("/admin")
    public String getRequestMappingAdmin() {
        return "home";
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
//    public String getRequestMappingManager() {
//        return "welcome";
//    }

    @PostMapping("/admin")
    public String postMappingEx() {
        return "welcome";
    }

    @GetMapping("/welcome")
    public String getMappingEx() {
        return "welcome";
    }

    @GetMapping("/home/{name}")
    public String pathVariable(@PathVariable("name") String name) {
        System.out.printf("Name is : " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx2(@PathVariable("name") String name, @PathVariable("email") String email) {
        System.out.println();
        System.out.println(name + "'s email is " + email);
        return "home";
    }

    @GetMapping("/home/course")
    public String requestParamEx(@RequestParam("course") String course) {
        System.out.println("name is : " + course);
        return "home";
    }

    @GetMapping(value = "/course2")
    public String reqParam2(@RequestParam(value = "name", required = false, defaultValue = "Spring Boot") String name) {
        System.out.println("name is : " + name);
        return "home";
    }
}