package com.players.cricketPlayers.service;

import com.players.cricketPlayers.entity.PlayerEntity;
import com.players.cricketPlayers.mapper.PlayerMapper;
import com.players.cricketPlayers.model.Player;
import com.players.cricketPlayers.response.PlayerResponse;
import com.players.cricketPlayers.respository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServices {
    @Autowired
    private PlayerRepository playerRepository;
    private PlayerMapper playerMapper;


    public PlayerResponse createPlayer(Player player) {
        PlayerEntity playerEntity=new PlayerEntity();
        PlayerResponse playerResponse=new PlayerResponse();
        double id=Math.random()*10;
        playerEntity.setId((long) id);
        playerResponse.setId(playerEntity.getId());
        playerEntity.setFirstName(player.getFirstName());
        playerEntity.setLastName(player.getLastName());
        return playerResponse;
    }

    public Player getPlayer(Long id) {
       Player player=new Player();
       Optional<PlayerEntity> playerEntityOptional=playerRepository.findById(id);
       if(playerEntityOptional.isPresent()){
           player=playerMapper.entityToPlayer(playerEntityOptional.get());
       }
       else {
           throw new RuntimeException();
       }
       return player;
    }
}
