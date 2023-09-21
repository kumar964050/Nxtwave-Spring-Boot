package com.example.song.repository;

import java.util.ArrayList;
import com.example.song.model.Song;

public interface SongRepository{
    ArrayList<Song> getAllSongs();
    Song addSong(Song newSong);
    Song getSongById(int id);
    Song updateSong(int id, Song newSong);
    void deleteSong(int id);
}