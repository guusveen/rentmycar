package com.example.rentmycarapi.controllers;

import com.example.rentmycarapi.entities.Reservation;
import com.example.rentmycarapi.repositories.ReservationRepository;
import com.example.rentmycarapi.services.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public Iterable<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable long id) {
        return reservationService.getById(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }
}
