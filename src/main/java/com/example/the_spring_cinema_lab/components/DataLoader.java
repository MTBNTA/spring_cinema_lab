package com.example.the_spring_cinema_lab.components;

import com.example.the_spring_cinema_lab.models.Movie;
import com.example.the_spring_cinema_lab.repositories.MovieRepository;
import com.example.the_spring_cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieRepository movieRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Movie movie1 = null;
        movieRepository.save(movie1);
        Movie movie2 = null;
        movieRepository.save(movie2);
        Movie movie3 = null;
        movieRepository.save(movie3);

        movie1 = new Movie(
                "Alien",
                "18",
                117
        );
        movie2 = new Movie(
                "The Imitation Game",
                "12A",
                144
        );
        movie3 = new Movie(
                "You Only Live Twice",
                "PG",
                117
        );
    }
}
