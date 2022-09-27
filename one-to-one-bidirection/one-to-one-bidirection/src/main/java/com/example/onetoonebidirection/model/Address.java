package com.example.onetoonebidirection.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long id;
    private String addressLine;
    private String city;
    private String state;
}
