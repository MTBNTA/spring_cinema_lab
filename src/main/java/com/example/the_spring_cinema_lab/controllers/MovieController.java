package com.example.the_spring_cinema_lab.controllers;

import com.example.the_spring_cinema_lab.models.Movie;
import com.example.the_spring_cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // used to manage beans
@RequestMapping(value = "/movies") // giving suffix at end of url
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping // getting all the movies
    public ResponseEntity<List<Movie>> getAllMovies1(){ // we want a list of movies as our response
        List<Movie> movies = movieService.getAllMovies(); // go through service first not repository to add to list
        return new ResponseEntity<>(movies, HttpStatus.OK); // our list denoted movies will be sent back here
    }

    @GetMapping // extension
    public ResponseEntity<List<Movie>> getAllMovies2(@RequestParam(required = false) Integer maxDuration){
        List<Movie> movies;
        if (maxDuration == null){
            movies = movieService.getAllMovies();
        } else {
            movies = movieService.filterMoviesByDuration(maxDuration);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}") // finding a single movie (response entity could also be a null)
    public ResponseEntity<Movie> getMovieById1(@PathVariable Long id){
        Movie movie = movieService.getMovieById1(id);
//        if(movie == null){  optional addition
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping // creating a new movie, passing over movie object through request body, we get the id of the movie back
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}") // path mapping - what you are updating, request body -  what you are replacing it with are need
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        movie.setId(id);
        movieService.updateMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
