package com.intuit.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/movie")
public class MovieNameController {
    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/{movieName}")
    public  String createPerson(@PathVariable String movieName) {
        jmsTemplate.convertAndSend("MovieNameQueue", movieName);
        return "Thanks for adding movie: " + movieName ;
    }
}