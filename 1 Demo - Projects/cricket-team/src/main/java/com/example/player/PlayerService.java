/*
 
* You can use the following import statements
 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 
 */

package com.example.player;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.player.Player;
import com.example.player.PlayerRepository;

// Don't modify the below code

public class PlayerService implements PlayerRepository  {

    private static HashMap<Integer, Player> team = new HashMap<>();
    private int unqPlayerId = 12;

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    // Don't modify the above code
    @Override
    public ArrayList<Player> getTeam() {
        Collection<Player> teamCollection = team.values();
        ArrayList<Player> teamList = new ArrayList<>(teamCollection);
        return teamList;
    }

    @Override 
    public Player addPlayer (Player player ){
        player.setPlayerId(unqPlayerId);
        team.put(player.getPlayerId(), player);
        unqPlayerId +=1;
        return player;
    }

    @Override
    public  Player getPlayerById(int playerId){
        Player findPlayer = team.get(playerId);
        if(findPlayer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return findPlayer;
    }

    public Player updatePlayer(int playerId, Player player){
        Player findPlayer = team.get(playerId);
        if(findPlayer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        if(player.getPlayerName() != null){
            findPlayer.setPlayerName(player.getPlayerName());
        }
        if(player.getRole() != null){
            findPlayer.setRole(player.getRole());
        }
        if(player.getJerseyNumber() != 0){
            findPlayer.setJerseyNumber(player.getJerseyNumber());
        }
        return findPlayer;
    }

    @Override
    public void deletePlayer(int playerId){
        Player findPlayer = team.get(playerId);
        if(findPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            System.out.print(team);
            team.remove(playerId);
            System.out.print(team);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
     }


}
