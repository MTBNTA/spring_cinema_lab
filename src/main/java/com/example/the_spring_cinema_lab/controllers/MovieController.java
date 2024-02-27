package com.example.the_spring_cinema_lab.controllers;

import com.example.the_spring_cinema_lab.models.Movie;
import com.example.the_spring_cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> getMovie(){
        return movieService.getMovie();
    }

//    @GetMapping(value = "/{id}")

    @PostMapping
    public void postMovie(@RequestBody Movie movie){
        movieService.addingNewMovie(movie);
    }


}
