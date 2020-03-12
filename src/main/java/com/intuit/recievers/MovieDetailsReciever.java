package com.intuit.recievers;

import com.intuit.entities.Movie;
import com.intuit.repositories.MovieRepository;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import java.util.List;

@Component
public class MovieDetailsReciever {

    @Autowired
    private MovieRepository movieRepository;

    @JmsListener(destination="MovieDetailsQueue", containerFactory="stockFactory")
    public void receiveMessage(ObjectMessage message) throws JMSException {
        System.out.println("got message");
        Movie movie = (Movie) message.getObject();
        movieRepository.save(movie);
    }

}
