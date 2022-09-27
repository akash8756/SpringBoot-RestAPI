package com.example.onetoonebidirection.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
}
