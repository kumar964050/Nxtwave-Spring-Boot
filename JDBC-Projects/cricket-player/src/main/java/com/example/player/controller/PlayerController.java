package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
// 
import com.example.player.model.*;
import com.example.player.service.PlayerH2Service;
import java.util.*;

@RestController
public class PlayerController{
    @Autowired
    public PlayerH2Service  playerService ;

    // api 1
    @GetMapping("/players")
    public ArrayList<Player> getTeam(){
        return playerService.getTeam();
    }
    // api 2
     @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }
    // api 3
    @GetMapping("/players/{playerId}")
    public  Player getPlayerById(@PathVariable("playerId") int playerId){
        return playerService.getPlayerById(playerId);
    }
    // api 4
    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId,  @RequestBody Player player){
        return playerService.updatePlayer(playerId,player);
    }
    // api 5
    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerService.deletePlayer(playerId);
    }


}