package com.example.song;

import java.util.*;
import com.example.song.Song;

public interface SongRepository{
    ArrayList<Song> getSongs();
    Song addSong(Song song);
    Song getSongById(int songId);
    Song updateSong(int songId, Song song);

    void deleteSong(int songId);

}