package com.example.onetoonebidirection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table
@NoArgsConstructor
public class AddressEntity {
    @Id
    private Long id;
    @Column(name = "address_line")
    private String addressLine;
    private String city;
    private String state;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private PersonEntity personEntity;

}
