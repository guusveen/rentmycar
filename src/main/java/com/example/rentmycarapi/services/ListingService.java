package com.example.rentmycarapi.services;

import com.example.rentmycarapi.entities.Listing;

import java.util.Optional;

public interface ListingService {
    Iterable<Listing> getAll();
    Optional<Listing> getById(Long id);

    Listing createListing(Listing listing);
}
