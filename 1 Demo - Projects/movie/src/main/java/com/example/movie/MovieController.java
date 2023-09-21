package com.example.movie;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.movie.*;

@RestController
public class MovieController{
    MovieService movieService = new MovieService();
   
   //  api 1 
    @GetMapping("/movies")
     public  ArrayList<Movie> getAllMovies(){
        return movieService.getAllMovies();
     }

      //   api 2
     @PostMapping("/movies")
      public Movie addMovie(@RequestBody Movie newMovie){
         return  movieService.addMovie(newMovie);
      }

      // api3 
      @GetMapping("/movies/{movieId}")
      public Movie getMovieById(@PathVariable("movieId") int movieId){
         return  movieService.getMovieById(movieId);
      }

      // api 4
      @PutMapping("/movies/{movieId}")
      public Movie updateMovie(@PathVariable("movieId") int movieId,@RequestBody Movie newMovie){
         return movieService.updateMovie(movieId,newMovie);
      }

      @DeleteMapping("/movies/{movieId}")
      public void deleteMovie(@PathVariable("movieId") int movieId){
         movieService.deleteMovie(movieId);
      }

}