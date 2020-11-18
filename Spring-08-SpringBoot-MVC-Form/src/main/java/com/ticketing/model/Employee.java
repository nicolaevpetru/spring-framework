package com.ticketing.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private String firstName;
    private String lastName;
    private String birthDay;
    private String email;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
}
