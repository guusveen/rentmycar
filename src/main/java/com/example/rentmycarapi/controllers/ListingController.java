package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.Listing;
import com.example.rentmycarapi.services.ListingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * This is the RestController for accessing ListingService methods
 */
@RestController
@RequestMapping("/v1/listings")
public class ListingController {
    /**
     * Instance of ListingService
     */
    private final ListingService listingService;

    /**
     * Constructor
     * @param listingService
     */
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    /**
     * Gets all Listings
     * @return
     */
    @GetMapping
    public Iterable<Listing> getAll() {
        return listingService.getAll();
    }

    /**
     * Get Listing by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Listing> getById(@PathVariable long id)
    {
        return listingService.getById(id);
    }

    /**
     * Create Listing
     * @param listing
     * @return
     */
    @PostMapping
    public Listing createListing(@RequestBody Listing listing) {
        return listingService.createListing(listing);
    }
}
