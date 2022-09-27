package com.example.onetoonebidirection.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    @Id
    @SequenceGenerator(sequenceName = "seq_person_id", name = "seq_person_id", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(mappedBy = "personEntity",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AddressEntity addressEntity;

}
