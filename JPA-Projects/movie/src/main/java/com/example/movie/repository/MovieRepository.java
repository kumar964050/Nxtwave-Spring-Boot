package com.example.movie.repository;

import java.util.ArrayList;
import com.example.movie.model.*;

public interface MovieRepository{
    ArrayList<Movie> getAllMovies();
    Movie addMovie(Movie newMovie);
    Movie getMovieById(int movieId);
    Movie updateMovie(int movieId, Movie newMovie);

    void deleteMovie(int movieId);
}