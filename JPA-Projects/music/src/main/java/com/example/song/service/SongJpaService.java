package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
// 
import com.example.song.model.Song;
import com.example.song.repository.*;


@Service
public class SongJpaService implements SongRepository {
    @Autowired
    private SongJpaRepository songJpaRepository;

    @Override 
    public ArrayList<Song> getAllSongs(){
        List<Song> songList = songJpaRepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(songList);
        return songs;
    }
    // 
    @Override 
    public Song addSong(Song newSong){
        songJpaRepository.save(newSong);
        return newSong;
    }
    // 
    @Override 
    public Song getSongById(int id){
        try{
            return songJpaRepository.findById(id).get();
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // 
    @Override 
    public Song updateSong(int id, Song song){
        try{
            Song findSong = songJpaRepository.findById(id).get();
            if(song.getSongName() != null) findSong.setSongName(song.getSongName());
            if(song.getLyricist() != null) findSong.setLyricist(song.getLyricist());
            if(song.getSinger() != null) findSong.setSinger(song.getSinger());
            if(song.getMusicDirector() != null) findSong.setMusicDirector(song.getMusicDirector());
            songJpaRepository.save(findSong);
            return findSong;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // 
    @Override 
    public void deleteSong(int id){
        try{
            songJpaRepository.deleteById(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}