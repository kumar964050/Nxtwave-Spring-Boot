/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here.

package com.example.player;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.player.PlayerService;
import com.example.player.Player;

@RestController
public class PlayerController{
    PlayerService playerService = new PlayerService();

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