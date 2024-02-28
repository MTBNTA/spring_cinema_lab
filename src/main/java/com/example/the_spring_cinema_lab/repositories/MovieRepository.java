package com.example.the_spring_cinema_lab.repositories;

import com.example.the_spring_cinema_lab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

// object type - Long
// repository is creating an object you can generate later, provides us with methods to save and find in service
// repository makes sure you can store items and retrieve items