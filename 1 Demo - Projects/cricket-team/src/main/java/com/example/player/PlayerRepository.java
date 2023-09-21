package com.example.player;


import java.util.ArrayList;
import com.example.player.Player;

public interface PlayerRepository{
    ArrayList<Player> getTeam();

    Player addPlayer(Player player);
    Player getPlayerById(int playerId);
    Player updatePlayer(int playerId,Player player);
    void deletePlayer(int playerId);

}