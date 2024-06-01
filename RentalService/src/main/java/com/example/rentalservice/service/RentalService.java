package com.example.rentalservice.service;

import com.example.rentalservice.model.Movie;
import com.example.rentalservice.model.RestTemplateConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    private final RestTemplate restTemplate;
    private final String movieServiceUrl = "http://localhost:8080/movies/";

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovieById(long id){
        return restTemplate.getForObject(movieServiceUrl + id, Movie.class);
    }

    public ResponseEntity<Void> makeMovieAvailableById(long id){
        restTemplate.put(movieServiceUrl + id + "/makeAvailable", null);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
