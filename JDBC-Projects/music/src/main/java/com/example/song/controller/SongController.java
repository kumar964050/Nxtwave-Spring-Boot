package com.example.song.controller;
// 
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
// 
import com.example.song.service.SongH2Service;
import com.example.song.model.*; 
import java.util.*;

@RestController
public class SongController{

    @Autowired
    public SongH2Service songService;

    // api 1
    @GetMapping("/songs")
    public ArrayList<Song> getSongs(){
        return songService.getSongs();
    }
    // api 2
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songService.addSong(song);
    }
    // api 3
    @GetMapping("/songs/{songId}")
    public Song getSong( @PathVariable("songId") int songId){
        return songService.getSongById(songId);
    }
    // api 4
    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId,@RequestBody Song song){
        return songService.updateSong(songId, song);
    }

    // api 5
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
        songService.deleteSong(songId);
    }


}