package com.example.movie;
import java.util.ArrayList;
import com.example.movie.Movie;

public interface MovieRepository{
    ArrayList<Movie> getAllMovies();
    Movie addMovie(Movie newMovie);
    Movie getMovieById(int movieId);
    Movie updateMovie(int movieId, Movie newMovie);

    void deleteMovie(int movieId);
}