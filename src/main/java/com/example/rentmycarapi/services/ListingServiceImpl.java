package com.example.rentmycarapi.services;

import com.example.rentmycarapi.entities.Listing;
import com.example.rentmycarapi.repositories.ListingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This class implements the methods of ListingService
 */
@Service
public class ListingServiceImpl implements ListingService {
    private final ListingRepository listingRepository;

    public ListingServiceImpl(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Override
    public Iterable<Listing> getAll() {
        return listingRepository.findAll();
    }

    @Override
    public Optional<Listing> getById(Long id) {
        return listingRepository.findById(id);
    }

    @Override
    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }
}
