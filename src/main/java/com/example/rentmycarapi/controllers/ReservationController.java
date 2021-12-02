package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.Reservation;
import com.example.rentmycarapi.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }

    @GetMapping
    public Iterable<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
