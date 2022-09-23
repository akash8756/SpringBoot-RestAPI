package com.players.cricketPlayers.respository;

import com.players.cricketPlayers.entity.PlayerEntity;
import com.players.cricketPlayers.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
