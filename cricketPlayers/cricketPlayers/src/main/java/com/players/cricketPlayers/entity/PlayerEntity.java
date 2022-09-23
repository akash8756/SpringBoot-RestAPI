package com.players.cricketPlayers.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String roles;
}
