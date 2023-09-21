

package com.example.player.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

import com.example.player.model.Player;
import com.example.player.repository.PlayerJpaRepository;
import com.example.player.repository.PlayerRepository;

@Service
public class PlayerJpaService  implements  PlayerRepository{
    @Autowired
    private PlayerJpaRepository playerJpaRepository;
    // api 1
    @Override
    public ArrayList<Player> getAllPlayers(){
        List<Player> playerList = playerJpaRepository.findAll();
        ArrayList<Player> players = new ArrayList<>(playerList);
        return players;
    }

    // api 2
    @Override
    public Player addPlayer(Player newPlayer){
        playerJpaRepository.save(newPlayer);
        return newPlayer;
    }
    // api 3
    @Override
    public Player getPlayerById(int id){
        try{
            return playerJpaRepository.findById(id).get();
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // api 4
    @Override
    public Player updatePlayer(int id, Player newPlayer){
        try{
            Player getPlayer=  playerJpaRepository.findById(id).get();
            if(newPlayer.getPlayerName() != null) getPlayer.setPlayerName(newPlayer.getPlayerName());
            if(newPlayer.getJerseyNumber() != 0) getPlayer.setJerseyNumber(newPlayer.getJerseyNumber());
            if(newPlayer.getRole() != null) getPlayer.setRole(newPlayer.getRole());
            playerJpaRepository.save(getPlayer);
            return getPlayer;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public void deletePlayer(int id){
        try{
            Player getplayer = playerJpaRepository.findById(id).get();
            playerJpaRepository.deleteById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}