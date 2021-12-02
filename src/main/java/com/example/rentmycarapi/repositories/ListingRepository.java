package com.example.rentmycarapi.repositories;

import com.example.rentmycarapi.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
