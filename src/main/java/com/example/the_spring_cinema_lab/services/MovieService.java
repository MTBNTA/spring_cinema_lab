package com.example.the_spring_cinema_lab.services;

import com.example.the_spring_cinema_lab.models.Movie;
import com.example.the_spring_cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

   @Autowired
    MovieRepository movieRepository;

   public List<Movie> getAllMovies(){ // controller should only talk to service layer
       return movieRepository.findAll(); // pagination could be done on the service layer
   }

    public Movie getMovieById1(long id){
        return movieRepository.findById(id).get();
    }

    public Movie getMovieById2(long id){ // added error handling by optionals
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()){
            return movie.get();
        }
//        could return a String saying movie not found
        return null;
    }

    public Movie addNewMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

//    EXTENSION -------------

    public Movie updateMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }

    public List<Movie> filterMoviesByDuration(int maxDuration){
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> filteredMovies = new ArrayList<>();

        for (Movie movie : allMovies) {
            if (movie.getDuration() <= maxDuration){
                filteredMovies.add(movie);
            }
        }

        return filteredMovies;
    }


}
