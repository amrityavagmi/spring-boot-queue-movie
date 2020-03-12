package com.intuit.controllers;

import com.intuit.entities.Movie;
import com.intuit.services.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
public class MovieDetailsController {

    @Autowired
    private MovieDetailsService movieDetailsService;

    @GetMapping("/details")
    public List<Movie> getAllMovies() {
        return movieDetailsService.getAllMovies();
    }
}
