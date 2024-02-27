package com.example.the_spring_cinema_lab.services;

import com.example.the_spring_cinema_lab.models.Movie;
import com.example.the_spring_cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

   @Autowired
    MovieRepository movieRepository;

   public List<Movie> getMovie(){
       return movieRepository.findAll();
   }

   public void addingNewMovie(Movie movie){
       movieRepository.findMovieById(movie.getId());
   }

   public void findMovieById(Movie movie){
       Optional<Movie> movieOptional = movieRepository.findMovieById(movieOptional.isPresent());
   }

}
