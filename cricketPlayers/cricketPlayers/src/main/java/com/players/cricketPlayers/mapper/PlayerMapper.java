package com.players.cricketPlayers.mapper;

import com.players.cricketPlayers.entity.PlayerEntity;
import com.players.cricketPlayers.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {
    PlayerMapper INSTANCE= Mappers.getMapper(PlayerMapper.class);

    Player entityToPlayer(PlayerEntity playerEntity);
    PlayerEntity playerToEntity(Player player);
}
