package com.example.rentalservice.controller;

import com.example.rentalservice.model.Movie;
import com.example.rentalservice.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id)
    {
        return ResponseEntity.ok(rentalService.getMovieById(id));
    }

    @PutMapping("/{id}/makeAvailable")
    public ResponseEntity<Void> makeMovieAvailable(@PathVariable Long id) {
        return rentalService.makeMovieAvailableById(id);
    }
}
