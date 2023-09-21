/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    private int unqSongId = 6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    // Write your code here
    // api 1
    @Override
    public ArrayList<Song> getSongs(){
        Collection<Song> songCollection = playlist.values();
        ArrayList<Song> songList = new ArrayList<>(songCollection);
        return songList;
    }

    // api 2
    @Override
    public Song addSong(Song song){
        song.setSongId(unqSongId);
        playlist.put(unqSongId,song);
        unqSongId +=1;
        return song;
    }

    // api 3
    @Override
    public Song getSongById(int songId){
        Song getSong = playlist.get(songId);
        if(getSong == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return getSong;
    }

    // api4
    @Override
    public Song updateSong(int songId, Song song){
        Song findSong = playlist.get(songId);
        if(findSong == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        if(song.getSongName() != null) findSong.setSongName(song.getSongName());
        if(song.getLyricist() != null) findSong.setLyricist(song.getLyricist());
        if(song.getSinger() != null) findSong.setSinger(song.getSinger());
        if(song.getMusicDirector() != null) findSong.setMusicDirector(song.getMusicDirector());
        return findSong;
    }

    // api 5
    @Override
    public void deleteSong(int songId){
        Song getSong = playlist.get(songId);
        if(getSong == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}