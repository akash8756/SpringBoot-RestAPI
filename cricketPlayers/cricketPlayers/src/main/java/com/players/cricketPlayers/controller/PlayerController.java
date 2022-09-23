package com.players.cricketPlayers.controller;

import com.players.cricketPlayers.entity.PlayerEntity;
import com.players.cricketPlayers.model.Player;
import com.players.cricketPlayers.response.PlayerResponse;
import com.players.cricketPlayers.service.PlayerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    @Autowired
    private PlayerServices playerServices;

    @PostMapping(path = "/players", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerResponse> createPlayer(@RequestBody Player player){
        PlayerResponse playerResponse=playerServices.createPlayer(player);
        return new ResponseEntity<>(playerResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/players/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayer(@PathVariable Long id){
        Player player=playerServices.getPlayer(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
