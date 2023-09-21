package com.example.movie.service;
// 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.movie.repository.MovieJpaRepository;
// 
import com.example.movie.repository.MovieRepository;
import com.example.movie.model.*;


@Service
public class MovieJpaService implements MovieRepository{
    @Autowired
    private MovieJpaRepository movieJpaRepository;

    // api 1
    @Override 
    public  ArrayList<Movie> getAllMovies(){
        List<Movie> movieList = movieJpaRepository.findAll();
        ArrayList<Movie> movies = new ArrayList<>(movieList);
        return movies;
    }

    // api 2
    @Override 
    public Movie addMovie(Movie newMovie){
        movieJpaRepository.save(newMovie);
        return newMovie;
    }

    // api 3
    @Override
    public Movie getMovieById(int id){
        try{
            return movieJpaRepository.findById(id).get();
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // api 4
    @Override
    public Movie updateMovie(int id, Movie newMovie){
        try{
            Movie findMovie = movieJpaRepository.findById(id).get();
            if(newMovie.getMovieName() != null) findMovie.setMovieName(newMovie.getMovieName() );
            if(newMovie.getLeadActor() != null) findMovie.setLeadActor(newMovie.getLeadActor());
            movieJpaRepository.save(findMovie);
            return findMovie;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // api 5
    @Override 
    public void deleteMovie(int id){
        try{
            Movie getMovie = movieJpaRepository.findById(id).get();
            movieJpaRepository.deleteById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}