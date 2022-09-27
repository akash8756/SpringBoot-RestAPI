package com.example.twoTablesRestAPI.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private Long zipCode;
}
