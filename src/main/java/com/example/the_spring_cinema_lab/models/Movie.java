package com.example.the_spring_cinema_lab.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id // adds it to primary key, unique identifier for each row in database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ensures it is an auto incrementing whole number
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private String rating;
    @Column(name = "duration")
    private int duration;

    public Movie(){}  // needed to make class a pojo class, used for serialising and de-serialising, to create objects

    public Movie(String title, String rating, int duration){
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

//    GETTERS & SETTERS - for serialisation

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
