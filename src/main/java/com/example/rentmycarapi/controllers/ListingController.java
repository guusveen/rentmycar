package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.Listing;
import com.example.rentmycarapi.repositories.ListingRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/listings")
public class ListingController {
    private final ListingRepository listingRepository;

    public ListingController(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @PostMapping
    public Listing createListing(@RequestBody Listing listing) {
        listingRepository.save(listing);
        return listing;
    }

    @GetMapping
    public Iterable<Listing> getAll() {
        return listingRepository.findAll();
    }
}
