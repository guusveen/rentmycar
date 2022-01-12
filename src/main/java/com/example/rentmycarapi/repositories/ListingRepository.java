package com.example.rentmycarapi.repositories;

import com.example.rentmycarapi.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The JPA repository for Listing class
 */
public interface ListingRepository extends JpaRepository<Listing, Long> {
}
