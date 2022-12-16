package com.crossasyst.userdetailsservice.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_details")
public class UsersEntity {
    @Id
    @SequenceGenerator(sequenceName = "user_Id", name = "user_Id", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Id")
    private Long id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dayMonth;
    private String emailId;

}
