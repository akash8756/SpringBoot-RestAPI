package com.example.twoTablesRestAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    private AddressEntity addressEntity;


}
