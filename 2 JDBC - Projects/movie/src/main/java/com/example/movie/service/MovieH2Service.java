package com.example.movie.service;
// 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
// 
import com.example.movie.repository.MovieRepository;
import com.example.movie.model.*;


@Service

public class MovieH2Service implements MovieRepository{
    @Autowired
    private JdbcTemplate db;
    @Override 
    public  ArrayList<Movie> getAllMovies(){
        List<Movie> movieList = db.query("select * from movielist", new MovieRowMapper());
        ArrayList<Movie> movies = new ArrayList<>(movieList);
        return movies;
    }

    @Override 
    public Movie addMovie(Movie newMovie){
        db.update("insert into movielist (movieName,leadActor) values(?,?)", newMovie.getMovieName(), newMovie.getLeadActor());
        Movie movie = db.queryForObject("select * from movielist where movieName=? and leadActor=?", new MovieRowMapper(),newMovie.getMovieName(), newMovie.getLeadActor());
        return movie;
    }

    @Override
    public Movie getMovieById(int movieId){
        try{
            return db.queryForObject("select * from movielist where movieId=?", new MovieRowMapper(),movieId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie updateMovie(int movieId, Movie newMovie){
        Movie findMovie = getMovieById(movieId);
        if(newMovie.getMovieName() != null) db.update("update movielist set movieName=? where movieId=?",newMovie.getMovieName(),movieId);
        if(newMovie.getLeadActor() != null) db.update("update movielist set leadActor=? where movieId=?",newMovie.getLeadActor(),movieId);
        return getMovieById(movieId);
    }
    @Override 
    public void deleteMovie(int movieId){
        db.update("delete from movielist where movieId=?",movieId);
    }
}