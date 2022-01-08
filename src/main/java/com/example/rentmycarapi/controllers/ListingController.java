package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.Listing;
import com.example.rentmycarapi.services.ListingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/listings")
public class ListingController {
    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping
    public Iterable<Listing> getAll() {
        return listingService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Listing> getById(@PathVariable long id)
    {
        return listingService.getById(id);
    }

    @PostMapping
    public Listing createListing(@RequestBody Listing listing) {
        return listingService.createListing(listing);
    }
}
