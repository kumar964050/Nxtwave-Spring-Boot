package com.example.player.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
// 
import com.example.player.repository.PlayerRepository;
import com.example.player.model.*;

@Service
public class PlayerH2Service implements PlayerRepository{

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Player> getTeam() {
        List<Player> playerList = db.query("select * from team", new PlayerRowMapper());
        ArrayList<Player> players = new ArrayList<>(playerList);
        return players;
    }

    @Override 
    public Player addPlayer (Player player ){
        db.update("insert into team (playerName,jerseyNumber,role) values(?,?,?)", player.getPlayerName(), player.getJerseyNumber(),player.getRole());
        Player getPlayer = db.queryForObject("select * from team where playerName=? and jerseyNumber=? and role=?", new PlayerRowMapper(),player.getPlayerName(), player.getJerseyNumber(),player.getRole());
        return getPlayer;
    }

    @Override
    public  Player getPlayerById(int playerId){
        try{
            return db.queryForObject("select * from team where playerId = ?", new PlayerRowMapper(),playerId); 
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Player updatePlayer(int playerId, Player player){
       Player getPlayer = getPlayerById(playerId);
        if(player.getPlayerName() != null)  db.update("update team set playerName=? where playerId=?", player.getPlayerName(),playerId);
        if(player.getRole() != null) db.update("update team set role=? where playerId=?", player.getRole(),playerId);
        if(player.getJerseyNumber() != 0) db.update("update team set jerseyNumber=? where playerId=?", player.getJerseyNumber(),playerId);
        return getPlayerById(playerId);

    }

    @Override
    public void deletePlayer(int playerId){
        db.update("delete team where playerId=?",playerId);
     }
}