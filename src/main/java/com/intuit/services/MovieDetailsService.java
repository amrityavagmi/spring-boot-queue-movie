package com.intuit.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.entities.Movie;
import com.intuit.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.List;

@Service
public class MovieDetailsService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovieDetails(String movieName) {
        String uri = "http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=" + movieName;
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(uri, String.class);
        Movie movie = null;
        try {
            movie = new ObjectMapper().readValue(jsonResponse, Movie.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }
}
