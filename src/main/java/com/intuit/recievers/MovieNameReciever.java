package com.intuit.recievers;

import com.intuit.entities.Movie;
import com.intuit.services.MovieDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MovieNameReciever {

    @Autowired
    private MovieDetailsService movieDetailsService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "MovieNameQueue")
    public void recieveMovieName(String movieName) {
        Movie movie= movieDetailsService.getMovieDetails(movieName);
        jmsTemplate.convertAndSend("MovieDetailsQueue", movie);
    }
}
