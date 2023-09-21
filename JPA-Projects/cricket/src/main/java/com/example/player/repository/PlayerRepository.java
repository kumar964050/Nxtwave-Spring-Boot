package com.example.player.repository;

import com.example.player.model.Player;
import java.util.ArrayList;


public interface PlayerRepository{
    ArrayList<Player> getAllPlayers();
    Player addPlayer(Player newPlayer);
    Player getPlayerById(int id);
    Player updatePlayer(int id, Player newPlayer);
    void deletePlayer(int id);
}
