package com.example.the_spring_cinema_lab.repositories;

import com.example.the_spring_cinema_lab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieById(Long id);

}
