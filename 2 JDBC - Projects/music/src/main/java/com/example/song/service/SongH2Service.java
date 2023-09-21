package com.example.song.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

// 
import com.example.song.repository.SongRepository;
import com.example.song.model.*;


@Service
public class SongH2Service implements SongRepository{
    @Autowired
    private  JdbcTemplate db;

    @Override
    public ArrayList<Song> getSongs(){
        List<Song> playList = db.query("select * from playlist", new SongRowMapper());
        ArrayList<Song> songs = new ArrayList<>(playList);
        return songs;
    }

    // api 2
    @Override
    public Song addSong(Song song){
        db.update("insert into playlist (songName,lyricist,singer,musicDirector) values(?,?,?,?)",song.getSongName(),song.getLyricist(),song.getSinger(),song.getMusicDirector());
        Song getSong = db.queryForObject("select * from playlist where songName=? and lyricist=? and singer=? and musicDirector=?", new SongRowMapper(),song.getSongName(),song.getLyricist(),song.getSinger(),song.getMusicDirector());
        return getSong;
    }

    // api 3
    @Override
    public Song getSongById(int songId){
       try{
            return db.queryForObject("select * from playlist where songId = ?", new SongRowMapper(),songId); 
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // api4
    @Override
    public Song updateSong(int songId, Song song){
        Song getSong = getSongById(songId);
        if(song.getSongName() != null)  db.update("update playlist set songName=? where songId=?", song.getSongName(),songId);
        if(song.getLyricist() != null) db.update("update playlist set lyricist=? where songId=?", song.getLyricist(),songId);
        if(song.getSinger() != null) db.update("update playlist set singer=? where songId=?",song.getSinger(),songId);
        if(song.getMusicDirector() != null) db.update("update playlist set musicDirector=? where songId=?",song.getMusicDirector(),songId);
        return getSongById(songId);
    }

    // api 5
    @Override
    public void deleteSong(int songId){
        db.update("delete from playlist where songId=?", songId);
    }
    
}