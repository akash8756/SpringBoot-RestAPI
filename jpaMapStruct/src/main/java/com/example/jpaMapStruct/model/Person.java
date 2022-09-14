package com.example.jpaMapStruct.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
//@AllArgsConstructor
public class Person {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
