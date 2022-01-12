package com.example.rentmycarapi.repositories;

import com.example.rentmycarapi.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The JPA repository for Reservation class
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
