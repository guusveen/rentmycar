package com.example.rentmycarapi.repositories;

import com.example.rentmycarapi.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
