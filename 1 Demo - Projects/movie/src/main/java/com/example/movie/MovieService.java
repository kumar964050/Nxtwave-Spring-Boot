package com.example.movie;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import java.util.*;

import javax.validation.OverridesAttribute;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();
    private int unqId = 6;

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    // Write your code here
    @Override 
    public  ArrayList<Movie> getAllMovies(){
        Collection<Movie> movieCollection = movieList.values();
        ArrayList<Movie> movies = new ArrayList<>(movieCollection);
        return movies;
    }

    @Override 
    public Movie addMovie(Movie newMovie){
        newMovie.setMovieId(unqId);
        movieList.put(unqId,newMovie);
        unqId += 1;
        return newMovie;
    }

    @Override
    public Movie getMovieById(int movieId){
        Movie findMovie = movieList.get(movieId);
        if(findMovie == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return findMovie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie newMovie){
        Movie findMovie = movieList.get(movieId);
        if(findMovie == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if(newMovie.getMovieName() != null) findMovie.setMovieName(newMovie.getMovieName());
        if(newMovie.getLeadActor() != null) findMovie.setLeadActor(newMovie.getLeadActor());
        return findMovie;
    }
    @Override 
    public void deleteMovie(int movieId){
         Movie findMovie = movieList.get(movieId);
        if(findMovie == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else{
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
    


}
