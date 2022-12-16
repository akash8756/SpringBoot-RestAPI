package com.mongodbuserdetails.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "person_entity")
public class PersonEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Date dayMonth;
}
