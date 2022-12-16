package com.crossasyst.userdetailsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private String firstName;
    private String lastName;
    private Date dayMonth;
    private String emailId;

}
